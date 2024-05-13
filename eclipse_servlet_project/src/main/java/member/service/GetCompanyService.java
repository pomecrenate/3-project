package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import exception.CompanyNotFoundException;
import exception.EmployeeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.model.Company;

public class GetCompanyService {
  private CompanyDao companyDao = new CompanyDao();

  public Company get(int code) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Company company = companyDao.selectByCode(conn, code);

      if (company == null) {
        throw new CompanyNotFoundException();
      }

      return company;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  
  public Company get(String id) {
      try (Connection conn = ConnectionProvider.getConnection()) {
      	Company company = companyDao.selectById(conn, id);

        if (company == null) {
          throw new CompanyNotFoundException();
        }

        return company;
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
}