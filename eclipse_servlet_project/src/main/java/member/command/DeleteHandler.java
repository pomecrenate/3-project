package member.command; 
 
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.SQLException; 
 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import jdbc.connection.ConnectionProvider; 
import member.dao.EmployeeDao; 
import mvc.command.CommandHandler; 
 
public class DeleteHandler implements CommandHandler { 
 
    private static final String SUCCESS_VIEW = "/WEB-INF/view/deleteSuccess.jsp"; 
     
    private EmployeeDao employeeDao = new EmployeeDao(); 
 
    @Override 
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
            int employeeCode = Integer.parseInt(request.getParameter("employeeCode")); 
         
            employeeDao.deleteEmployee(conn, employeeCode); 
             
            return SUCCESS_VIEW; 
        } catch (SQLException e) { 
            throw new ServletException("Failed to delete employee.", e); 
        } 
    } 
} 
