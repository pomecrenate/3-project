package member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.PermissionChecker;
import auth.service.User;
import member.model.Company;
import member.model.Employee;
import member.service.GetCompanyService;
import member.service.GetEmployeeService;
import member.service.ModifyEmployeeService;
import member.service.ModifyListService;
import mvc.command.CommandHandler;

public class ModifyListHandler implements CommandHandler {
	private GetCompanyService getCompanyService = new GetCompanyService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 직원 수정을 요청한 회사 정보 구함.
		// 社員の修正を要請した会社情報を求める。
		User authUser = (User) request.getSession().getAttribute("authUser");
		System.out.println("company id of List: " + authUser.getId());
		Company company = getCompanyService.get(authUser.getId());
		
		int companyCode = company.getCompanyCode();
		
		System.out.println("company code of List: " + companyCode);

		List<Employee> employees = ModifyListService.selectModifyList(companyCode);

		request.setAttribute("employees", employees);
		return "/employeeList.do";
	}

}
