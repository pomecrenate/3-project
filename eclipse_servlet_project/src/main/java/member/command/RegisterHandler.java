package member.command;

import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auth.model.User;
import member.service.GetDepartmentService;
import member.service.GetPositionService;
import member.service.RegisterRequest;
import member.service.RegisterService;
import mvc.command.CommandHandler;

public class RegisterHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/RegisterForm.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/view/RegisterSuccess.jsp";
	private RegisterService registerService = new RegisterService();
	private GetDepartmentService getDepartmentService = new GetDepartmentService();
	private GetPositionService GetpositionService = new GetPositionService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 사원등록 페이지로 이동
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 사원등록 요청
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 사원등록 페이지로 이동
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<Integer, String> departments = getDepartmentService.get();
		request.setAttribute("departments", departments);

		Map<Integer, String> positions = getDepartmentService.get();
		request.setAttribute("positions", positions);

		return FORM_VIEW;
	}

	// 사원등록 요청
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		User authUser = (User)request.getSession().getAttribute("authUser");
		// TODO Auto-generated method stub
		// option에 value 전달
		Map<Integer, String> departments = getDepartmentService.get();
		request.setAttribute("departments", departments);

		Map<Integer, String> positions = GetpositionService.get();
		request.setAttribute("positions", positions);

		RegisterRequest registerRequest = new RegisterRequest();

		registerRequest.setCompanyId(authUser.getId());
		registerRequest.setDepartmentCode(Integer.parseInt(request.getParameter("departmentCode")));
		registerRequest.setPositionCode(Integer.parseInt(request.getParameter("positionCode")));
		registerRequest.setEmployeeName(request.getParameter("employeeName"));
		registerRequest.setEmploymentType(request.getParameter("employmentType"));
		registerRequest.setAddress(request.getParameter("address"));
		registerRequest.setPhoneNumber(request.getParameter("phoneNumber"));
		registerRequest.setEmail(request.getParameter("email"));
		registerRequest.setBirthNumber(Integer.parseInt(request.getParameter("birthNumber")));
		registerRequest.setResidentNumber(Integer.parseInt(request.getParameter("residentNumber")));
	    registerRequest.setHireDate(LocalDate.parse(request.getParameter("hireDate")));
	    
	    try {
	    	registerService.Register(registerRequest);
	    	return SUCCESS_VIEW;
	    } catch( Exception e) {
	    	return FORM_VIEW;
	    }


	}

}