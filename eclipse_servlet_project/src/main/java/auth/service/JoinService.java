package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import exception.DuplicateIdException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessItemDao;
import member.dao.BusinessTypeDao;
import member.dao.CompanyDao;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;

public class JoinService {
  private CompanyDao companyDao = new CompanyDao();
  BusinessTypeDao businessTypeDao = new BusinessTypeDao();
  BusinessItemDao businessItemDao = new BusinessItemDao();

  // 회원가입 | 会員加入
  public void join(JoinRequest joinRequest) {
    Connection conn = null;

    try {
      // try-with-resources로 선언하면 catch에서 rollback을 사용 못 하므로 try 밖에 먼저 선언
      // try-with-resourcesと宣言すると、catchでrollbackが使用できないので、tryしか先に宣言
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

      // id와 일치하는 멤버 계정을 찾음
      // idと一致するメンバーアカウントを探す
      Company existedCompany = companyDao.selectById(conn, joinRequest.getId());

      // id와 일치하는 멤버 계정이 이미 있으면 롤백 후 중복아이디 예외 발생
      // idと一致するメンバーアカウントが既にある場合、ロールバック後に重複IDが発生
      if (existedCompany != null) {
        JdbcUtil.rollback(conn);
        throw new DuplicateIdException();
      }

      // 회사 가입 정보 가져오기
      // 会社の加入情報を取得する
      int businessTypeCode = joinRequest.getBusinessTypeCode();
      BusinessType businessType = businessTypeDao.selectByCode(conn, businessTypeCode);
      int businessItemCode = joinRequest.getBusinessItemCode();
      BusinessItem businessItem = businessItemDao.selectByCode(conn, businessItemCode);
      String id = joinRequest.getId();
      String password = joinRequest.getPassword();
      LocalDate registerDate = LocalDate.now();
      String companyName = joinRequest.getCompanyName();
      String ceoName = joinRequest.getCeoName();
      String businessNumber = joinRequest.getBusinessNumber();
      String corporateNumber = joinRequest.getCorporateNumber();
      LocalDate establishmentDate = joinRequest.getEstablishmentDate();
      String website = joinRequest.getWebsite();
      String address = joinRequest.getAddress();
      String phoneNumber = joinRequest.getPhoneNumber();
      String faxNumber = joinRequest.getFaxNumber();

      // 새로운 회사 객체 생성
      // 新しい会社オブジェクト作成
      Company joinCompany = new Company(businessType, businessItem, id, password, registerDate,
          companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website,
          address, phoneNumber, faxNumber);

      // 회사 정보를 데이터베이스에 추가
      // 会社情報をデータベースに追加
      companyDao.insert(conn, joinCompany);

      conn.commit();
    } catch (SQLException e) {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);
    } finally {
      JdbcUtil.close(conn);
    }
  }
}
