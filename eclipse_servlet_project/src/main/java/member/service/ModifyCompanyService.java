package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.PermissionChecker;
import exception.CompanyNotFoundException;
import exception.EmployeeNotFoundException;
import exception.PermissionDeniedException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.dao.EmployeeDao;
import member.model.Company;
import member.model.Employee;

// ModifyCompanyRequest를 통해 사원 정보 수정 기능의 클래스
// ModifyCompanyRequestを通じて社員情報修正機能のクラス
public class ModifyCompanyService {

	// Modify 메서드를 위해 필요한 객체들 불러옴. DAO의 메서드 필요함.
	private CompanyDao companyDao = new CompanyDao();

	// 수정할 데이터, 수정될 데이터?는 ModifyCompanyRequest에 저장
	// Modifyメソッドのために必要なオブジェクトを読み込む。 DAOのメソッドが必要。
	public boolean modify(ModifyCompanyRequest modReq) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			// 회사 코드에 맞는 company 객체 구함.
			// 会社コードに合うコンポーネントオブジェクトを探す。
			Company company = companyDao.selectByCode(conn, modReq.getCompanyCode());
			if (company == null) {
				// 회사 코드가 일치 하지 않으면! 예외 발생
				// 会社コードが一致しない場合は例外発生
				throw new EmployeeNotFoundException();
			}

			// 로그인 아이디가 작성자 아이디와 다르면 예외
			// ログインIDが作成者IDと異なる場合は例外
			if (!PermissionChecker.canModify(modReq.getCompanyId(), companyDao.selectByCode(conn, modReq.getCompanyCode()))) {
				throw new PermissionDeniedException();
			}

			// companyDao를 이용해 내용 수정.
			// companyDaoを利用して内容を修正。
			companyDao.update(conn, company);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
			// catch (permissionDeniedException e) {
		} finally {
			JdbcUtil.close(conn);
		}
		return false;

	}
}
