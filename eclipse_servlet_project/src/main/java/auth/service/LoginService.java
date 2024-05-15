package auth.service; 
 
import java.sql.Connection; 
import java.sql.SQLException;
import auth.model.User;
import exception.LoginFailException; 
import jdbc.connection.ConnectionProvider; 
import member.dao.CompanyDao; 
import member.model.Company; 
 
public class LoginService { 
  private CompanyDao companyDao = new CompanyDao(); 
 
  public User login(String userId, String password) { 
    try (Connection conn = ConnectionProvider.getConnection()) { 
      // 아이디 검색 
      Company company = companyDao.selectById(conn, userId); 
 
      // 아이디 없으면 예외 
      if (company == null) { 
        throw new LoginFailException(); 
      } 
 
      // 암호틀리면 예외 
      if (!company.matchPassword(password)) { 
        throw new LoginFailException(); 
      } 
 
      return new User(company.getId(), company.getCompanyName()); 
    } catch (SQLException e) { 
      throw new RuntimeException(); 
    } 
  } 
} 
