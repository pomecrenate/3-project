package auth.command;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auth.service.JoinRequest;
import auth.service.JoinService;
import exception.DuplicateIdException;
import member.service.GetBusinessItemService;
import member.service.GetBusinessTypeService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
  private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
  private static final String SUCCESS_VIEW = "/WEB-INF/view/joinSuccess.jsp";
  private JoinService joinService = new JoinService();
  private GetBusinessTypeService getBusinessTypeService = new GetBusinessTypeService();
  private GetBusinessItemService getBusinessItemService = new GetBusinessItemService();

  @Override
  public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 회원가입 페이지로 이동
    												   // GETリクエストがあれば会員登録ページに移動
      return processForm(request, response);
    } else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 회원가입 요청
    														   // POSTリクエストであれば会員登録リクエスト
      return processSubmit(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

  // 회원가입 페이지로 이동
  //会員登録ページに移動
  private String processForm(HttpServletRequest request, HttpServletResponse response) {

    // option에 value 전달
	// オプションに値を渡す
    Map<Integer, String> businessTypes = getBusinessTypeService.get();
    request.setAttribute("businessTypes", businessTypes);

    Map<Integer, String> businessItems = getBusinessItemService.get();
    request.setAttribute("businessItems", businessItems);

    return FORM_VIEW;
  }

  // 회원가입 요청
  //会員登録リクエスト
  private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
    // option에 value 전달
	// オプションに値を渡す
    Map<Integer, String> businessTypes = getBusinessTypeService.get();
    request.setAttribute("businessTypes", businessTypes);

    Map<Integer, String> businessItems = getBusinessItemService.get();
    request.setAttribute("businessItems", businessItems);

    JoinRequest joinRequest = new JoinRequest();

    joinRequest.setBusinessTypeCode(Integer.parseInt(request.getParameter("businessTypeCode")));
    joinRequest.setBusinessItemCode(Integer.parseInt(request.getParameter("businessItemCode")));
    joinRequest.setId(request.getParameter("id"));
    joinRequest.setPassword(request.getParameter("password"));
    joinRequest.setCompanyName(request.getParameter("companyName"));
    joinRequest.setCeoName(request.getParameter("ceoName"));
    joinRequest.setBusinessNumber(request.getParameter("businessNumber"));
    joinRequest.setCorporateNumber(request.getParameter("corporateNumber"));
    joinRequest.setEstablishmentDate(LocalDate.parse(request.getParameter("establishmentDate")));
    joinRequest.setWebsite(request.getParameter("website"));
    joinRequest.setAddress(request.getParameter("address"));
    joinRequest.setPhoneNumber(request.getParameter("phoneNumber"));
    joinRequest.setFaxNumber(request.getParameter("faxNumber"));
    joinRequest.setConfirmPassword(request.getParameter("confirmPassword"));

    Map<String, Boolean> errors = new HashMap<>();
    request.setAttribute("errors", errors);

    // 에러 검증
    // エラー検証
    joinRequest.validate(errors);

    // 에러가 있으면 회원가입 페이지로 이동
    // エラーがあれば会員登録ページに移動
    if (!errors.isEmpty()) {
      return FORM_VIEW;
    }

    try { // 가입 성공하면 가입 완료 페이지로 이동
    	  // 登録成功したら登録完了ページに移動
      joinService.join(joinRequest);
      return SUCCESS_VIEW;
    } catch (DuplicateIdException e) { // 아이디가 중복되면 에러 발생 및 회원가입 페이지로 이동
    								   // IDが重複する場合はエラー発生し、会員登録ページに移動
      errors.put("duplicateId", Boolean.TRUE);
      return FORM_VIEW;
    }
  }

}
