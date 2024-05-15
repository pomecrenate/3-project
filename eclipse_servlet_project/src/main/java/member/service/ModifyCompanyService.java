package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import auth.service.PermissionChecker;
import exception.CompanyNotFoundException;
import exception.PermissionDeniedException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessItemDao;
import member.dao.BusinessTypeDao;
import member.dao.CompanyDao;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;

// ModifyCompanyRequest를 통해 사원 정보 수정 기능의 클래스
// ModifyCompanyRequestを通じて社員情報修正機能のクラス
public class ModifyCompanyService {

  // Modify 메서드를 위해 필요한 객체들 불러옴. DAO의 메서드 필요함.
  // Modifyメソッドのために必要なオブジェクトを読み込む。 DAOのメソッドが必要。
  private CompanyDao companyDao = new CompanyDao();
  private BusinessItemDao businessItemDao = new BusinessItemDao();
  private BusinessTypeDao businessTypeDao = new BusinessTypeDao();


  // 수정할 데이터, 수정될 데이터?는 ModifyCompanyRequest에 저장
  // 修正データはModifyCompanyRequestに保存
  public boolean modify(ModifyCompanyRequest modifyRequest) {
    Connection conn = null;

    try {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

      // 회사 코드에 맞는 company 객체 구함.
      // 会社コードに合うコンポーネントオブジェクトを探す。
      Company companyInfo = companyDao.selectByCode(conn, modifyRequest.getCompanyCode());
      if (companyInfo == null) {
        // 회사 코드가 일치 하지 않으면! 예외 발생
        // 会社コードが一致しない場合は例外発生
        throw new CompanyNotFoundException();
      }

      // 로그인 아이디가 작성자 아이디와 다르면 예외
      // ログインIDが作成者IDと異なる場合は例外
      if (!PermissionChecker.canModify(modifyRequest.getId(),
          companyDao.selectByCode(conn, modifyRequest.getCompanyCode()))) {
        throw new PermissionDeniedException();
      }

      int companyCode = modifyRequest.getCompanyCode();
      int businessTypeCode = modifyRequest.getBusinessTypeCode();
      BusinessType businessType = businessTypeDao.selectByCode(conn, businessTypeCode);
      int businessItemCode = modifyRequest.getBusinessItemCode();
      BusinessItem businessItem = businessItemDao.selectByCode(conn, businessItemCode);
      String password = modifyRequest.getPassword();
      String companyName = modifyRequest.getCompanyName();
      String ceoName = modifyRequest.getCeoName();
      String businessNumber = modifyRequest.getBusinessNumber();
      String corporateNumber = modifyRequest.getCorporateNumber();
      LocalDate establishmentDate = modifyRequest.getEstablishmentDate();
      String website = modifyRequest.getWebsite();
      String address = modifyRequest.getAddress();
      String phoneNumber = modifyRequest.getPhoneNumber();
      String faxNumber = modifyRequest.getFaxNumber();

      Company company = new Company(companyCode, businessType, businessItem, password, companyName,
          ceoName, businessNumber, corporateNumber, establishmentDate, website, address,
          phoneNumber, faxNumber);

      System.out.println("companynameService: " + company.getCompanyName());

      // companyDao를 이용해 내용 수정.
      // companyDaoを利用して内容を修正。
      companyDao.update(conn, company);
      conn.commit();
    } catch (SQLException e) {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);
      // catch (permissionDeniedException e) {
    } finally {
      JdbcUtil.close(conn);
    }
    return false;

  }
}
