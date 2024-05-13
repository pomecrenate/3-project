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
	// 成功時のビュー
    private static final String SUCCESS_VIEW = "/WEB-INF/view/deleteSuccess.jsp"; 
    // 従業員DAO
    private EmployeeDao employeeDao = new EmployeeDao(); 
 
    @Override 
    // リクエスト処理
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
        	// 従業員コードを取得
            int employeeCode = Integer.parseInt(request.getParameter("employeeCode")); 
         
            // 従業員を削除
            employeeDao.deleteEmployee(conn, employeeCode); 
             
            // 成功ビューを返す
            return SUCCESS_VIEW; 
        } catch (SQLException e) { 
        	// 従業員の削除に失敗した場合の処理
            throw new ServletException("Failed to delete employee.", e); 
        } 
    } 
} 
