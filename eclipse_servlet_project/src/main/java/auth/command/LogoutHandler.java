package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		if (session != null) { // 세션이 존재하면 세션 삭제
			session.invalidate();
		}

		// 홈페이지로 이동
		response.sendRedirect(request.getContextPath() + "/index.jsp");

		return null;
	}
}
