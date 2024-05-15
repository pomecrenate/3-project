package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auth.model.User;
import auth.service.LoginService;
import exception.LoginFailException;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
  private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";
  private LoginService loginService = new LoginService();

  @Override
  public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 로그인 페이지로 이동
      return processForm(request, response);			// GETリクエストがあればログインページに移動
    } else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 로그인 요청
      return processSubmit(request, response);					// POSTリクエストならログインリクエスト
    } else {
      response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }
  //ログインページへ移動
  // 로그인 페이지로 이동
  private String processForm(HttpServletRequest request, HttpServletResponse response) {
    return FORM_VIEW;
  }
  //ログインリクエスト
  // 로그인 요청
  private String processSubmit(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String userId = trim(request.getParameter("id"));
    String password = trim(request.getParameter("password"));

    Map<String, Boolean> errors = new HashMap<>();
    request.setAttribute("errors", errors);
    // エラー検証(Null検証)
    // 에러 검증(Null 검증)
    if (userId == null || userId.isEmpty()) {
      errors.put("id", Boolean.TRUE);
    }
    if (password == null || password.isEmpty()) {
      errors.put("password", Boolean.TRUE);
    }
    // エラーがある場合はログインページへ移動
    // 에러가 있으면 로그인 페이지로 이동
    if (!errors.isEmpty()) {
      return FORM_VIEW;
    }
    	// ログインに成功したらホームページに移動
    try { // 로그인 성공하면 홈 페이지로 이동
      User user = loginService.login(userId, password);
      request.getSession().setAttribute("authUser", user);
      response.sendRedirect(request.getContextPath() + "/getCompany.do");
      return null;							// IDが重複するとエラーが発生し、会員登録ページに移動
    } catch (LoginFailException e) { // 아이디가 중복되면 에러 발생 및 회원가입 페이지로 이동
      errors.put("idOrPasswordNotMatch", Boolean.TRUE);
      return FORM_VIEW;
    }
  }
  //文字列値があれば空白を削除
  // 문자열 값이 있으면 공백 제거
  private String trim(String str) {
    return str == null ? null : str.trim();
  }

}
