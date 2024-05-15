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
      return processForm(request, response);			// GETリクエストがあれば会員登録ページに移動
    } else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 회원가입 요청
      return processSubmit(request, response);						// POSTリクエストであれば会員登録リクエスト
    } else {
      response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }
  //会員登録ページへ移動
  // 회원가입 페이지로 이동
  private String processForm(HttpServletRequest request, HttpServletResponse response) {
	// optionにvalueを配信
    // option에 value 전달
    Map<Integer, String> businessTypes = getBusinessTypeService.get();
    request.setAttribute("businessTypes", businessTypes);

    Map<Integer, String> businessItems = getBusinessItemService.get();
    request.setAttribute("businessItems", businessItems);

    return FORM_VIEW;
  }
  //会員登録要請
  // 회원가입 요청
  private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
    // option에 value 전달
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
    // エラー検証
    // 에러 검증
    joinRequest.validate(errors);
    // エラーがある場合は会員登録ページに移動
    // 에러가 있으면 회원가입 페이지로 이동
    if (!errors.isEmpty()) {
      return FORM_VIEW;
    }
    		// 登録に成功したら登録完了ページに移動
    try { // 가입 성공하면 가입 완료 페이지로 이동
      joinService.join(joinRequest);
      return SUCCESS_VIEW;			// IDが重複するとエラーが発生し、会員登録ページに移動
    } catch (DuplicateIdException e) { // 아이디가 중복되면 에러 발생 및 회원가입 페이지로 이동
      errors.put("duplicateId", Boolean.TRUE);
      return FORM_VIEW;
    }
  }

}
