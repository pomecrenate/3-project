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
	private static final String FORM_VIEW = "/WEB-INF/view/RegisterForm.jsp"; // 등록 폼 뷰 경로 | 登録フォームビューのパス
	private static final String SUCCESS_VIEW = "/WEB-INF/view/RegisterSuccess.jsp"; // 등록 성공 뷰 경로 | 登録成功ビューのパス
	private RegisterService registerService = new RegisterService(); // RegisterService 인스턴스 생성  |  RegisterServiceインスタンスの生成
	private GetDepartmentService getDepartmentService = new GetDepartmentService(); // GetDepartmentService 인스턴스 생성 | GetDepartmentServiceインスタンスの生成
	private GetPositionService GetpositionService = new GetPositionService(); // GetPositionService 인스턴스 생성 | GetPositionServiceインスタンスの生成

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) { // GET 요청이면 사원등록 페이지로 이동 | GETリクエストの場合、従業員登録ページに移動する
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) { // POST 요청이면 사원등록 요청 | POSTリクエストの場合、従業員登録リクエスト
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// 사원등록 페이지로 이동
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<Integer, String> departments = getDepartmentService.get();  // 부서 정보 가져오기 | 部署情報を取得する
		request.setAttribute("departments", departments); // 부서 정보를 request에 저장 | 部署情報をリクエストに保存する

		Map<Integer, String> positions = getDepartmentService.get();  // 직책 정보 가져오기 | 役職情報を取得する
		request.setAttribute("positions", positions); // 직책 정보를 request에 저장 | 役職情報をリクエストに保存する

		return FORM_VIEW; // 등록 폼 뷰 반환 | 登録フォームビューを返す
	} 

	// 사원등록 요청
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		User authUser = (User)request.getSession().getAttribute("authUser"); // 현재 세션에서 사용자 정보 가져오기 | 現在のセッションからユーザー情報を取得する
		// TODO Auto-generated method stub
		// option에 value 전달
		Map<Integer, String> departments = getDepartmentService.get(); // 부서 정보 가져오기 |  部署情報を取得する
		request.setAttribute("departments", departments); // 부서 정보를 request에 저장 | 部署情報をリクエストに保存する

		Map<Integer, String> positions = GetpositionService.get(); // 직책 정보 가져오기 | 役職情報を取得する
		request.setAttribute("positions", positions); // 직책 정보를 request에 저장 | 役職情報をリクエストに保存する

		RegisterRequest registerRequest = new RegisterRequest(); // 사원 등록 요청 객체 생성 | 従業員登録要求オブジェクトの生成

		// 등록 요청 정보 설정
		// 登録要求情報の設定
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
	    	registerService.Register(registerRequest); // 사원 등록 서비스 실행 | 従業員登録サービスを実行する
	    	return SUCCESS_VIEW; // 등록 성공 뷰 반환
	    } catch( Exception e) {
	    	return FORM_VIEW; // 등록 폼 뷰 반환
	    }


	}

}