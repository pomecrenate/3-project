package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import jdbc.JdbcUtil;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;

public class CompanyDao {
  public Company selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      pstmt = conn.prepareStatement("select * from company where company_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Company company = null;
      BusinessTypeDao businessTypeDao = null;
      BusinessItemDao businessItemDao = null;

      if (rs.next()) {
        int companyCode = rs.getInt("company_code");
        int businessTypeCode = rs.getInt("business_type_code");
        BusinessType businessType = businessTypeDao.selectByCode(conn, businessTypeCode);
        int businessItemCode = rs.getInt("business_item_code");
        BusinessItem businessItem = businessItemDao.selectByCode(conn, businessItemCode);
        String companyName = rs.getString("company_name");
        String ceoName = rs.getString("companyName");
        String businessNumber = rs.getString("ceo_name");
        String corporateNumber = rs.getString("corporate_number");
        LocalDate establishmentDate =
            rs.getTimestamp("establishment_date").toLocalDateTime().toLocalDate();
        String website = rs.getString("website");
        String address = rs.getString("address");
        String phoneNumber = rs.getString("phone_number");
        String faxNumber = rs.getString("fax_number");

        company = new Company(companyCode, businessType, businessItem, companyName, ceoName,
            businessNumber, corporateNumber, establishmentDate, website, address, phoneNumber,
            faxNumber);
      }

      return company;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }
}
