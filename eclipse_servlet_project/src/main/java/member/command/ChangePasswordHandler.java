package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changePasswordForm.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/view/changePasswordSuccess.jsp";
	private ChangePasswordService changePasswordService = new ChangePasswordService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 비밀번호 변경 페이지로 이동
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 비밀번호 변경 요청
			return processSubmit(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 비밀번호 변경 페이지로 이동
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	// 비밀번호 변경 요청
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();

		request.setAttribute("errors", errors);

		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");

		// 현재 비밀번호를 입력하지 않으면 에러
		if (currentPassword == null || currentPassword.isEmpty()) {
			errors.put("currentPassword", Boolean.TRUE);
		}

		// 새로운 비밀번호를 입력하지 않으면 에러
		if (newPassword == null || newPassword.isEmpty()) {
			errors.put("newPassword", Boolean.TRUE);
		}

		// 에러가 있으면 비밀번호 변경 페이지로 이동
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try { // 비밀번호 변경 성공하면 비밀번호 변경 완료 페이지로 이동
			changePasswordService.changePassword(user.getId(), currentPassword, newPassword);
			return SUCCESS_VIEW;
		} catch (InvalidPasswordException e) { // 비밀번호가 일치하지 않으면 에러 발생
			errors.put("invalidPassword", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) { // 멤버가 존재하지 않으면 에러 발생
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
