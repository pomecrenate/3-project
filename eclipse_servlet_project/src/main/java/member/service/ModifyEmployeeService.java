package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import auth.service.PermissionChecker;
import exception.CompanyNotFoundException;
import exception.EmployeeNotFoundException;
import exception.PermissionDeniedException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.dao.DepartmentDao;
import member.dao.EmployeeDao;
import member.dao.PositionDao;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

// ModifyEmployeeRequest를 통해 사원 정보 수정 기능의 클래스
// ModifyEmployeeRequestを通じて社員情報修正機能のクラス
public class ModifyEmployeeService {

	// Modify 메서드를 위해 필요한 객체들 불러옴. DAO의 메서드 필요함.
	// Modifyメソッドのために必要なオブジェクトを読み込む。 DAOのメソッドが必要。
	private EmployeeDao employeeDao = new EmployeeDao();
	private CompanyDao companyDao = new CompanyDao();
	private DepartmentDao departmentDao = new DepartmentDao();
	private PositionDao positionDao = new PositionDao();

	// 수정 데이터는 ModifyEmployeeRequest에 저장
	// 修正データはModifyEmployeeRequestに保存
	public void modify(ModifyEmployeeRequest modifyRequest) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			// 회사 코드에 맞는 Employee 객체 구함.
			// 会社コードに合うEmployeeオブジェクトを探す。
			Employee employeeInfo = employeeDao.selectByCode(conn, modifyRequest.getEmployeeCode());
			if (employeeInfo == null) {
				// 회사 코드가 일치 하지 않으면 예외 발생
				// 会社コードが一致しない場合は例外発生
				throw new EmployeeNotFoundException();
			}

			// 로그인 아이디가 작성자 아이디와 다르면 예외
			// ログインIDが作成者IDと異なる場合は例外
			if (!PermissionChecker.canModify(modifyRequest.getCompanyId(),
					companyDao.selectByCode(conn, modifyRequest.getCompanyCode()))) {
				throw new PermissionDeniedException();
			}

			int employeeCode = modifyRequest.getEmployeeCode();
			int companyCode = modifyRequest.getCompanyCode();
			Company company = companyDao.selectByCode(conn, companyCode);
			int departmentCode = modifyRequest.getDepartmentCode();
			Department department = departmentDao.selectByCode(conn, departmentCode);
			int positionCode = modifyRequest.getPositionCode();
			Position position = positionDao.selectByCode(conn, positionCode);
			String employeeName = modifyRequest.getEmployeeName();
			String employmentType = modifyRequest.getEmploymentType();
			LocalDate hireDate = LocalDate.now();
			int birthNumber = modifyRequest.getBirthNumber();
			int residentNumber = modifyRequest.getResidentNumber();
			String address = modifyRequest.getAddress();
			String phoneNumber = modifyRequest.getPhoneNumber();
			String email = modifyRequest.getEmail();

			Employee employee = new Employee(employeeCode, company, department, position, employeeName, employmentType,
					hireDate, birthNumber, residentNumber, address, phoneNumber, email);

			System.out.println("MODIFY SERVICE employeeName: " + employee.getEmployeeName());

			// employeeDAO를 이용해 내용 수정
			// employeeDAOを利用して内容を修正。
			employeeDao.update(conn, employee);

			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
			// catch (permissionDeniedException e) {
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
