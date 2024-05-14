package member.command; 
 
import java.util.List; 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import auth.service.PermissionChecker;
import auth.service.User;
import member.model.Company;
import member.model.Employee;
import member.service.DeleteListService;
import member.service.GetCompanyService;
import member.service.GetEmployeeService;
import mvc.command.CommandHandler; 
 
public class DeleteListHandler implements CommandHandler { 
	private GetCompanyService getCompanyService = new GetCompanyService();
	
	@Override
	// リクエスト処理
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 직원 수정을 요청한 회사 정보 구함.
		// 社員の修正を要請した会社情報を求める。
		User authUser = (User) request.getSession().getAttribute("authUser");

		Company company = getCompanyService.get(authUser.getId());
		
		int companyCode = company.getCompanyCode();
		
	    // 従業員の基本情報を取得する
	    List<Employee> employees = DeleteListService.getDeleteList(companyCode);

	    // リクエスト属性に従業員リストを設定する
	    request.setAttribute("employees", employees);

	    // 削除リストビューを返す
	    return "/WEB-INF/view/deleteList.jsp";
	}
} 
