package member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import exception.CompanyNotFoundException;
import member.model.Company;
import member.service.EmploymentTypeService;
import member.service.GetCompanyService;
import mvc.command.CommandHandler;

public class EmploymentTypeHandler implements CommandHandler {
	private static final String CONTENT_VIEW = "/getCompany.do";
	private GetCompanyService getCompanyService = new GetCompanyService();
	private EmploymentTypeService employmentTypeService = new EmploymentTypeService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		try {
			Map<String, Integer> typeCount = employmentTypeService.get();
			request.setAttribute("typeCount", typeCount);

			return CONTENT_VIEW;
		} catch (CompanyNotFoundException e) {
			request.getServletContext().log("no Employee", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);

			return null;
		}
	}
}
	
