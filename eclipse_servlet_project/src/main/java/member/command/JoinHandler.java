package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/view/joinSuccess.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 회원가입 페이지로 이동
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 회원가입 요청
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 회원가입 페이지로 이동
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	// 회원가입 요청
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		JoinRequest joinRequest = new JoinRequest();

		joinRequest.setId(request.getParameter("id"));
		joinRequest.setName(request.getParameter("name"));
		joinRequest.setPassword(request.getParameter("password"));
		joinRequest.setConfirmPassword(request.getParameter("confirmPassword"));

		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		// 에러 검증
		joinRequest.validate(errors);

		// 에러가 있으면 회원가입 페이지로 이동
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try { // 가입 성공하면 가입 완료 페이지로 이동
			joinService.join(joinRequest);
			return SUCCESS_VIEW;
		} catch (DuplicateIdException e) { // 아이디가 중복되면 에러 발생 및 회원가입 페이지로 이동
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
