package member.command; 
 
import java.util.List; 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import member.model.Employee;
import member.service.DeleteListService;
import mvc.command.CommandHandler; 
 
public class DeleteListHandler implements CommandHandler { 
 
	@Override
	// リクエスト処理
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // 従業員の基本情報を取得する
	    List<Employee> employees = DeleteListService.getAllEmployeesBasicInfo();

	    // リクエスト属性に従業員リストを設定する
	    request.setAttribute("employees", employees);

	    // 削除リストビューを返す
	    return "/WEB-INF/view/deleteList.jsp";
	}
} 
