package member.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auth.model.User;
import exception.CompanyNotFoundException;
import member.model.Company;
import member.service.EmploymentTypeService;
import member.service.GetCompanyService;
import mvc.command.CommandHandler;

public class GetCompanyHandler implements CommandHandler {
  private static final String CONTENT_VIEW = "/index.jsp";
  
  //회사 정보 서비스
  private GetCompanyService getCompanyService = new GetCompanyService();
  
  //고용 형태 서비스
  private EmploymentTypeService employmentTypeService = new EmploymentTypeService();

  @Override
  public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	// 인증된 사용자 정보 가져오기
    User authUser = (User) request.getSession().getAttribute("authUser");
    String id = authUser.getId();
    System.out.println("id: " + id);
    try {
      // 회사 정보 가져오기
      Company company = getCompanyService.get(id);
      
      // request에 고용 형태별 인원수를 설정하여 뷰에 전달
      request.setAttribute("company", company);

      // 회사 코드 가져오기
      int companyCode = company.getCompanyCode();

      // 고용 형태별 인원수 가져오기
      Map<String, Integer> typeCount = employmentTypeService.get(companyCode);
      request.setAttribute("typeCount", typeCount);

      return CONTENT_VIEW;
    } catch (CompanyNotFoundException e) {
      request.getServletContext().log("no Company", e);
      response.sendError(HttpServletResponse.SC_NOT_FOUND);

      return null;
    }
  }
}
