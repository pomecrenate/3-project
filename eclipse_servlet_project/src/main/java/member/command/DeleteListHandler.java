package member.command; 
 
import java.util.List; 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import member.model.Employee;
import member.service.DeleteListService;
import mvc.command.CommandHandler; 
 
public class DeleteListHandler implements CommandHandler { 
 
	@Override 
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		// TODO Auto-generated method stub 
		List<Employee> employees = DeleteListService.getAllEmployeesBasicInfo(); 
 
		request.setAttribute("employees", employees); 
 
		return "/WEB-INF/view/deleteList.jsp"; 
 
	} 
} 
