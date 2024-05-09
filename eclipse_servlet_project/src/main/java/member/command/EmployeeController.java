package member.command;



import member.model.Employee;
import member.service.EmployeeService;
import mvc.command.CommandHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class EmployeeController implements CommandHandler {
	private static final String CONTENT_VIEW = "/WEB-INF/view/readEmployee.jsp";
	private EmployeeService employeeService = new EmployeeService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String stringCode = request.getParameter("code");
		int code = Integer.parseInt(stringCode);

		try {
			Employee employee = employeeService.getEmployee(code);
			request.setAttribute("employee", employee);

			return CONTENT_VIEW;
			// 게시글 없으면 에러
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);

			return null;
		}
	}
}
