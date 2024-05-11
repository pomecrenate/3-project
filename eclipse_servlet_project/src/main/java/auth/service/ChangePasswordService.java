package auth.service; 
 
import java.sql.Connection; 
import java.sql.SQLException; 
 
import exception.CompanyNotFoundException; 
import exception.InvalidPasswordException; 
import jdbc.JdbcUtil; 
import jdbc.connection.ConnectionProvider; 
import member.dao.CompanyDao; 
import member.model.Company; 
 
public class ChangePasswordService { 
  private CompanyDao companyDao = new CompanyDao(); 
 
  // 비밀번호 변경 
  public void changePassword(String userId, String currentPassword, String newPassword) { 
    Connection conn = null; 
 
    try { 
      conn = ConnectionProvider.getConnection(); 
      conn.setAutoCommit(false); 
 
      // 로그인된 id와 일치하는 멤버 계정을 찾음 
      Company existedCompany = companyDao.selectById(conn, userId); 
 
      // 로그인된 id와 일치하는 멤버 계정이 없으면 멤버 찾을 수 없음 예외 발생 
      if (existedCompany == null) { 
        throw new CompanyNotFoundException(); 
      } 
 
      // 비밀번호가 일치하지 않으면 유효하지 않은 비밀번호 예외 발생 
      if (!existedCompany.matchPassword(currentPassword)) { 
        throw new InvalidPasswordException(); 
      } 
 
      // 비밀번호 변경 
      existedCompany.changePassword(newPassword); 
 
      // 멤버 정보 변경 
      companyDao.update(conn, existedCompany); 
 
      conn.commit(); 
    } catch (SQLException e) { 
      JdbcUtil.rollback(conn); 
      throw new RuntimeException(e); 
    } finally { 
      JdbcUtil.close(conn); 
    } 
  } 
} 
