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

  // 회원가입
  public void join(JoinRequest joinRequest) {
    Connection conn = null;

    try {
      // try-with-resources로 선언하면 catch에서 rollback을 사용 못 하므로 try 밖에 먼저 선언
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

      // id와 일치하는 멤버 계정을 찾음
      Company existedCompany = companyDao.selectById(conn, joinRequest.getId());

      // id와 일치하는 멤버 계정이 이미 있으면 롤백 후 중복아이디 예외 발생
      if (existedCompany != null) {
        JdbcUtil.rollback(conn);
        throw new DuplicateIdException();
      }

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

      Company joinCompany = new Company(businessType, businessItem, id, password, registerDate,
          companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website,
          address, phoneNumber, faxNumber);

      // 새로운 멤버 추가
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
