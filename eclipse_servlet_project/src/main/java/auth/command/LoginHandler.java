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
    												   // GETリクエストがあればログインページに移動
      return processForm(request, response);
    } else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 로그인 요청
    														   //POSTの要請でログイン要請 
      return processSubmit(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

  // 로그인 페이지로 이동
  // ログインページに移動
  private String processForm(HttpServletRequest request, HttpServletResponse response) {
    return FORM_VIEW; // ログインフォームビューを返す
  }

  // 로그인 요청
  //ログイン要求
  private String processSubmit(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String userId = trim(request.getParameter("id")); // 사용자 아이디 | ユーザーID
    String password = trim(request.getParameter("password")); // 사용자 비밀번호ユ | ーザーパスワード

    Map<String, Boolean> errors = new HashMap<>(); // 에러 맵 초기화 |  エラーマップ初期化
    request.setAttribute("errors", errors); // 에러 맵을 request에 설정 | エラーマップをリクエストに設定

    // 에러 검증(Null 검증) | エラー検証（Null検証)
    if (userId == null || userId.isEmpty()) { // 아이디가 null이거나 빈 경우 | ユーザーIDがnullまたは空の場合
      errors.put("id", Boolean.TRUE); // 에러 맵에 아이디 에러 추가 |  エラーマップにユーザーIDエラーを追加 
    }
    if (password == null || password.isEmpty()) { // 비밀번호가 null이거나 빈 경우 | パスワードがnullまたは空の場合
      errors.put("password", Boolean.TRUE); // 에러 맵에 비밀번호 에러 추가 | エラーマップにパスワードエラーを追加
    }

    // 에러가 있으면 로그인 페이지로 이동 | エラーがあればログインページに移動
    if (!errors.isEmpty()) { // 에러 맵이 비어있지 않으면 | エラーマップが空でない場合
      return FORM_VIEW; // 로그인 폼 뷰 반환 | ログインフォームビューを返す
    }

    try { // 로그인 성공하면 홈 페이지로 이동 | ログインに成功したらホームページに移動
      User user = loginService.login(userId, password); // 로그인 서비스 호출 | ログインサービス呼び出し
      request.getSession().setAttribute("authUser", user); // 사용자 정보를 세션에 저장 | ユーザー情報をセッションに保
      response.sendRedirect(request.getContextPath() + "/getCompany.do"); // 홈 페이지로 리다이렉트 | ホームページへのリダイレクト
      return null;  // 반환값 없음
    } catch (LoginFailException e) { // 아이디가 중복되면 에러 발생 및 회원가입 페이지로 이동 | IDが重複するとエラーが発生し、会員登録ページに移動
      errors.put("idOrPasswordNotMatch", Boolean.TRUE); // 아이디 또는 비밀번호 불일치 에러 추가 | IDまたはパスワード不一致エラー追加
      return FORM_VIEW;
    }
  }

  // 문자열 값이 있으면 공백 제거 | 文字列値があれば空白を削除
  private String trim(String str) {
    return str == null ? null : str.trim(); // 문자열이 null이면 null 반환, 아니면 공백 제거 후 반환 | 文字列がnullの場合はnull返却、または空白を削除してから返却
  }

}
