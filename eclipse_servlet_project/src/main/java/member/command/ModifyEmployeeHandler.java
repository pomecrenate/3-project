package member.command;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.PermissionChecker;
import auth.service.User;
import exception.DuplicateIdException;
import exception.EmployeeNotFoundException;
import member.model.Company;
import member.model.Employee;
import member.service.GetBusinessItemService;
import member.service.GetBusinessTypeService;
import member.service.GetCompanyService;
import member.service.GetDepartmentService;
import member.service.GetEmployeeService;
import member.service.GetPositionService;
import member.service.ModifyEmployeeRequest;
import member.service.ModifyEmployeeService;
import mvc.command.CommandHandler;

// ModifyEmployeeHandler는
// ModifyEmployService, GetEmployeeService 같이 사용
// ModifyEmployeeHandlerは
// ModifyEmployService, GetEmployeeService 一緒に使用
public class ModifyEmployeeHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/modifyEmployee.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/view/employeeList.jsp";
	private GetEmployeeService getEmployeeService = new GetEmployeeService();
	private ModifyEmployeeService modifyEmployeeService = new ModifyEmployeeService();
	private GetCompanyService getCompanyService = new GetCompanyService();
	private GetPositionService getPositionService = new GetPositionService();
	private GetDepartmentService getDepartmentService = new GetDepartmentService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("get")) { // GET 요청일 때, GETリクエストの時
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("post")) { // POST 요청일 때, POSTリクエストの時
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 폼 처리, get 방식일때, フォーム処理、get方式の場合
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			String codeValue = request.getParameter("employeeCode");
			int no = Integer.parseInt(codeValue);
			// 로그인한 정보를 넣어준다.
			// 폼에 보여줄 사원 정보 보여주기
			// ログインした情報を入れてくれる
			// フォームに表示する社員情報を表示する
			Employee employee = getEmployeeService.get(no);

			int companyCode = employee.getCompany().getCompanyCode();

			Company company = getCompanyService.get(companyCode);
			// option에 value 전달
			// optionにvalueを配信
			Map<Integer, String> departmentCodes = getDepartmentService.get();
			request.setAttribute("departmentCodes", departmentCodes);

			Map<Integer, String> positionCodes = getPositionService.get();
			request.setAttribute("positionCodes", positionCodes);
			// 현재 로그인한 회사가 맞는지 확인하는 if문, 現在ログインした会社であることを確認するif文
			// canModify() 문을 사용해서 비교 할것임, canModify()文を使って比較
			// 맞지 않다면 403 응답(금지) 전송, 合わなければ 403 転送
			// 로그인 정보 얻음, ログイン情報を取得
			User authUser = (User) request.getSession().getAttribute("authUser");

			// 로그인 아이디와 회사 아이디 일치 여부
			if (!PermissionChecker.canModify(authUser.getId(), company)) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);

				return null;
			}

			request.setAttribute("employee", employee); 
			// 폼에 데이터를 보여줄 때 사용할 객체 생성, フォームにデータを表示するときに使用するオブジェクトの作成
			// =====================================
			/*
			 * ModifyEmployeeRequest modrequestuest = new ModifyEmployeeRequest();
			 * request.setAttribute("modrequestuest", modrequestuest);
			 */
			return FORM_VIEW;
		} catch (EmployeeNotFoundException e) {
			request.getServletContext().log("no employee", e); 
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	// 폼전송 처리, post
	// フォーム転送処理、post
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 직원 수정을 요청한 회사 정보 구함.
		// 社員の修正を要請した会社情報を求める。
		User authUser = (User) request.getSession().getAttribute("authUser");
		String codeValue = request.getParameter("employeeCode");
		int code = Integer.parseInt(codeValue);

		Employee employee = getEmployeeService.get(code);

		int companyCode = employee.getCompany().getCompanyCode();

		Company company = getCompanyService.get(companyCode);

		// 로그인 아이디와 작성자 아이디 일치 여부
		if (!PermissionChecker.canModify(authUser.getId(), company)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);

			return null;
		}
		// option에 value 전달
		// optionにvalueを配信
		Map<Integer, String> departmentCodes = getDepartmentService.get();
		request.setAttribute("departmentCodes", departmentCodes);

		Map<Integer, String> positionCodes = getPositionService.get();
		request.setAttribute("positionCodes", positionCodes);
		// 요청 파라미터와 현재 회사 정보를 이용해서 ModifyEmployeeRequest 객체가 유효한지 검사
		// 유효하지 않으면 폼_뷰
		// 要請パラメータと現在の会社情報を利用してModifyEmployeeRequestオブジェクトが有効かどうかを検査
		// 有効でなければフォーム_ビュー
		// ===========================================
		ModifyEmployeeRequest modrequest = new ModifyEmployeeRequest();

		modrequest.setEmployeeCode(code);
		modrequest.setCompanyCode(companyCode);
		modrequest.setDepartmentCode(Integer.parseInt(request.getParameter("departmentCode")));
		modrequest.setPositionCode(Integer.parseInt(request.getParameter("positionCode")));
		modrequest.setEmployeeName(request.getParameter("employeeName"));
		modrequest.setEmploymentType(request.getParameter("employmentType"));
		modrequest.setAddress(request.getParameter("address"));
		modrequest.setPhoneNumber(request.getParameter("phoneNumber"));
		modrequest.setEmail(request.getParameter("email"));
		modrequest.setHireDate(LocalDate.parse(request.getParameter("hireDate")));
		modrequest.setCompanyId(company.getId());

		System.out.println("HANDLER employeeName: " + modrequest.getEmployeeName());
		
		// 데이터 수정 기능
		// データ修正機能
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		modrequest.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		modifyEmployeeService.modify(modrequest);
		return SUCCESS_VIEW;

	}
}
