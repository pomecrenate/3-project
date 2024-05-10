package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exception.EmployeeNotFoundException;
import member.model.Employee;
import member.service.GetEmployeeService;
import mvc.command.CommandHandler;

public class GetEmployeeHandler implements CommandHandler {
  private static final String CONTENT_VIEW = "/WEB-INF/view/getEmployee.jsp";
  private GetEmployeeService readService = new GetEmployeeService();

  @Override
  public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String codeValue = request.getParameter("code");
    int code = Integer.parseInt(codeValue);

    try {
      Employee employee = readService.get(code);
      request.setAttribute("employee", employee);

      return CONTENT_VIEW;
    } catch (EmployeeNotFoundException e) {
      request.getServletContext().log("no employee", e);
      response.sendError(HttpServletResponse.SC_NOT_FOUND);

      return null;
    }
  }
}
