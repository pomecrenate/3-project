package member.command;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.PermissionChecker;
import auth.service.User;
import exception.CompanyNotFoundException;
import exception.EmployeeNotFoundException;
import member.model.Company;
import member.model.Employee;
import member.service.GetBusinessItemService;
import member.service.GetBusinessTypeService;
import member.service.GetCompanyService;
import member.service.GetEmployeeService;
import member.service.ModifyCompanyRequest;
import member.service.ModifyCompanyService;
import member.service.ModifyEmployeeService;
import member.service.ModifyEmployeeRequest;
import mvc.command.CommandHandler;


// ModifyCompanyHandler는
// ModifyCompanyService, GetCompanyService 같이 사용
//ModifyCompanyHandlerは
//ModifyCompanyService, GetCompanyService 一緒に使用
public class ModifyCompanyHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/modifyCompany.jsp";
	private ModifyCompanyService modifyCompanyService = new ModifyCompanyService();
	private GetCompanyService getCompanyService = new GetCompanyService();
	private GetBusinessTypeService getBusinessTypeService = new GetBusinessTypeService();
	private GetBusinessItemService getBusinessItemService = new GetBusinessItemService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse responsep) throws Exception {
		if (request.getMethod().equalsIgnoreCase("get")) { 
			return processForm(request, responsep);
		} else if (request.getMethod().equalsIgnoreCase("post")) { 
			return processSubmit(request, responsep);
		} else {
			responsep.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 폼 처리, get 방식일때, フォーム処理、get方式の場合
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

	    // 로그인 정보 얻음, ログイン情報を取得
	    User authUser = (User) request.getSession().getAttribute("authUser");
	    try {
	      Company company = getCompanyService.get(authUser.getId());

	      // option에 value 전달
	      // optionにvalueを配信
	      Map<Integer, String> businessTypes = getBusinessTypeService.get();
	      request.setAttribute("businessTypes", businessTypes);

	      Map<Integer, String> businessItems = getBusinessItemService.get();
	      request.setAttribute("businessItems", businessItems);

	      // 폼에 데이터를 보여줄 때 사용할 객체 생성, フォームにデータを表示するときに使用するオブジェクトの作成
	      request.setAttribute("company", company);
			return FORM_VIEW;
		} catch (CompanyNotFoundException e) {
			request.getServletContext().log("no company", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	// 폼전송 처리, post
	// フォーム転送処理、post
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회사 수정을 요청한 회사 정보 구함.
		// 会社の修正を要請した会社情報を求める。
		User authUser = (User) request.getSession().getAttribute("authUser");
		String codeValue = request.getParameter("companyCode");
		int code = Integer.parseInt(codeValue);

		Company company = getCompanyService.get(code);
		
		// 로그인 아이디와 작성자 아이디 일치 여부, ログインIDと作成者IDが一致しているかどうか
		if (!PermissionChecker.canModify(authUser.getId(), company)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);

			return null;
		}
	    // option에 value 전달
		// optionにvalueを配信
	    Map<Integer, String> businessTypes = getBusinessTypeService.get();
	    request.setAttribute("businessTypes", businessTypes);

	    Map<Integer, String> businessItems = getBusinessItemService.get();
	    request.setAttribute("businessItems", businessItems);
		// 요청 파라미터와 현재 회사 정보를 이용해서 ModifyCompanyRequest 객체가 유효한지 검사
		// 유효하지 않으면 폼_뷰
	    // 要請パラメータと現在の会社情報を利用してModifyCompanyRequestオブジェクトが有効かどうかを検査
	    // 有効でなければフォーム_ビュー
		// ===========================================
		ModifyCompanyRequest modifyCompanyRequest = new ModifyCompanyRequest();
		
		modifyCompanyRequest.setCompanyCode(code);
		modifyCompanyRequest.setBusinessTypeCode(Integer.parseInt(request.getParameter("businessTypeCode"))); 
		modifyCompanyRequest.setBusinessItemCode(Integer.parseInt(request.getParameter("businessItemCode")));
		modifyCompanyRequest.setId(request.getParameter("id"));
		modifyCompanyRequest.setPassword(request.getParameter("password"));
		modifyCompanyRequest.setCompanyName(request.getParameter("companyName"));
		modifyCompanyRequest.setCeoName(request.getParameter("ceoName"));
		modifyCompanyRequest.setBusinessNumber(request.getParameter("businessNumber"));
		modifyCompanyRequest.setCorporateNumber(request.getParameter("corporateNumber"));
		modifyCompanyRequest.setEstablishmentDate(LocalDate.parse(request.getParameter("establishmentDate")));
		modifyCompanyRequest.setWebsite(request.getParameter("website"));
		modifyCompanyRequest.setAddress(request.getParameter("address"));
		modifyCompanyRequest.setPhoneNumber(request.getParameter("phoneNumber"));
		modifyCompanyRequest.setFaxNumber(request.getParameter("faxNumber"));
		
		// 데이터 수정 기능
		// データ修正機能
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		modifyCompanyRequest.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			modifyCompanyService.modify(modifyCompanyRequest);
			return "/getCompany.do";
		} catch (CompanyNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
