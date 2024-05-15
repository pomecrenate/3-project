package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import jdbc.JdbcUtil;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;

public class CompanyDao {
  // 회사 코드로 회사 정보를 조회하는 메서드
  // 会社コードで会社情報を照会するメソッド
  public Company selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("company code: " + code);

    try {
      pstmt = conn.prepareStatement("SELECT * FROM company WHERE company_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Company company = null;
      BusinessTypeDao businessTypeDao = new BusinessTypeDao();
      BusinessItemDao businessItemDao = new BusinessItemDao();

      // ResultSet에서 결과를 추출하여 Company 객체 생성
      // ResultSetから結果を抽出して当社オブジェクトを作成
      if (rs.next()) {
        int companyCode = rs.getInt("company_code");
        int businessTypeCode = rs.getInt("business_type_code");
        BusinessType businessType = businessTypeDao.selectByCode(conn, businessTypeCode);
        int businessItemCode = rs.getInt("business_item_code");
        BusinessItem businessItem = businessItemDao.selectByCode(conn, businessItemCode);
        String id = rs.getString("id");
        String password = rs.getString("password");
        LocalDate registerDate = rs.getTimestamp("register_date").toLocalDateTime().toLocalDate();
        String companyName = rs.getString("company_name");
        String ceoName = rs.getString("ceo_name");
        String businessNumber = rs.getString("business_number");
        String corporateNumber = rs.getString("corporate_number");
        LocalDate establishmentDate =
            rs.getTimestamp("establishment_date").toLocalDateTime().toLocalDate();
        String website = rs.getString("website");
        String address = rs.getString("address");
        String phoneNumber = rs.getString("phone_number");
        String faxNumber = rs.getString("fax_number");

        company = new Company(companyCode, businessType, businessItem, id, password, registerDate,
            companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website,
            address, phoneNumber, faxNumber);
      }

      // 생성된 Company 객체 반환
      // 生成された当社オブジェクトの返却
      return company;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 아이디로 회사 정보를 조회하는 메서드
  // IDで会社情報を照会するメソッド
  public Company selectById(Connection conn, String userId) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("company id: " + userId);

    try {
      pstmt = conn.prepareStatement("SELECT * FROM company WHERE id = ?");
      pstmt.setString(1, userId);
      rs = pstmt.executeQuery();

      Company company = null;
      BusinessTypeDao businessTypeDao = new BusinessTypeDao();
      BusinessItemDao businessItemDao = new BusinessItemDao();

      // ResultSet에서 결과를 추출하여 Company 객체 생성
      // ResultSetから結果を抽出して当社オブジェクトを作成
      if (rs.next()) {
        int companyCode = rs.getInt("company_code");
        int businessTypeCode = rs.getInt("business_type_code");
        BusinessType businessType = businessTypeDao.selectByCode(conn, businessTypeCode);
        int businessItemCode = rs.getInt("business_item_code");
        BusinessItem businessItem = businessItemDao.selectByCode(conn, businessItemCode);
        String id = rs.getString("id");
        String password = rs.getString("password");
        LocalDate registerDate = rs.getTimestamp("register_date").toLocalDateTime().toLocalDate();
        String companyName = rs.getString("company_name");
        String ceoName = rs.getString("ceo_name");
        String businessNumber = rs.getString("business_number");
        String corporateNumber = rs.getString("corporate_number");
        LocalDate establishmentDate =
            rs.getTimestamp("establishment_date").toLocalDateTime().toLocalDate();
        String website = rs.getString("website");
        String address = rs.getString("address");
        String phoneNumber = rs.getString("phone_number");
        String faxNumber = rs.getString("fax_number");

        company = new Company(companyCode, businessType, businessItem, id, password, registerDate,
            companyName, ceoName, businessNumber, corporateNumber, establishmentDate, website,
            address, phoneNumber, faxNumber);
      }

      // 생성된 Company 객체 반환
      // 生成された当社オブジェクトの返却
      return company;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 회사 정보를 추가하는 메서드
  // 会社情報を追加するメソッド
  public void insert(Connection conn, Company company) throws SQLException {
    String sql = "INSERT INTO company "
        + "(company_code, business_type_code, business_item_code, id, password, register_date, "
        + "company_name, ceo_name, business_number, corporate_number, establishment_date, "
        + "website, address, phone_number, fax_number) "
        + "VALUES (seq_company.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, company.getBusinessType().getBusinessTypeCode());
      pstmt.setInt(2, company.getBusinessItem().getBusinessItemCode());
      pstmt.setString(3, company.getId());
      pstmt.setString(4, company.getPassword());
      pstmt.setTimestamp(5, Timestamp.valueOf(company.getRegisterDate().atStartOfDay()));
      pstmt.setString(6, company.getCompanyName());
      pstmt.setString(7, company.getCeoName());
      pstmt.setString(8, company.getBusinessNumber());
      pstmt.setString(9, company.getCorporateNumber());
      pstmt.setTimestamp(10, Timestamp.valueOf(company.getEstablishmentDate().atStartOfDay()));
      pstmt.setString(11, company.getWebsite());
      pstmt.setString(12, company.getAddress());
      pstmt.setString(13, company.getPhoneNumber());
      pstmt.setString(14, company.getFaxNumber());

      pstmt.executeUpdate();
    }
  }

  // 회사 정보를 수정하는 메서드
  // 会社情報を修正するメソッド
  public void update(Connection conn, Company company) throws SQLException {
    String sql = "UPDATE company "
        + "SET business_type_code = ?, business_item_code = ?, password = ?, company_name = ?, ceo_name = ?, "
        + "business_number = ?, corporate_number = ?, establishment_date = ?, website = ?, address = ?, "
        + "phone_number = ?, fax_number = ? " + "WHERE company_code = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, company.getBusinessType().getBusinessTypeCode());
      pstmt.setInt(2, company.getBusinessItem().getBusinessItemCode());
      pstmt.setString(3, company.getPassword());
      pstmt.setString(4, company.getCompanyName());
      pstmt.setString(5, company.getCeoName());
      pstmt.setString(6, company.getBusinessNumber());
      pstmt.setString(7, company.getCorporateNumber());
      pstmt.setTimestamp(8, Timestamp.valueOf(company.getEstablishmentDate().atStartOfDay()));
      pstmt.setString(9, company.getWebsite());
      pstmt.setString(10, company.getAddress());
      pstmt.setString(11, company.getPhoneNumber());
      pstmt.setString(12, company.getFaxNumber());
      pstmt.setInt(13, company.getCompanyCode());

      // SQL 실행
      pstmt.executeUpdate();
    }
  }
}
