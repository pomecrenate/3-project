package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.dao.DepartmentDao;
import member.dao.EmployeeDao;
import member.dao.PositionDao;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

public class RegisterService {
    // DAO 객체 생성
	// DAOオブジェクト作成
    private EmployeeDao employeeDao = new EmployeeDao();
    private CompanyDao companyDao = new CompanyDao();
    private DepartmentDao departmentDao = new DepartmentDao();
    private PositionDao positionDao = new PositionDao();

    // 사원 등록 메서드
    // 社員登録メソッド
    public void Register(RegisterRequest registerRequest) {
        Connection conn = null;

        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);
 
            // registerRequest에서 회사 아이디를 가져옴
            // registerRequestから会社のIDを取得
            String companyId = registerRequest.getCompanyId();
            
            // companyDao.selectById를 통해 회사 정보를 가져옴
            // company Dao.select ByIdを通じて会社情報を取得
            Company company = companyDao.selectById(conn, companyId);

            // registerRequest에서 부서 코드를 가져옴
            // registerRequestから部署コードを取得する
            int departmentCode = registerRequest.getDepartmentCode();
            
            // departmentDao.selectByCode를 통해 부서 정보를 가져옴
            // department Dao.select By Codeを通じて部署情報を取得する
            Department department = departmentDao.selectByCode(conn, departmentCode);

            // registerRequest에서 positionCode를 가져옴
            // registerRequestからpositionCodeを取得
            int positionCode = registerRequest.getPositionCode();
            // DAO를 통해 직위 정보를 가져옴
            // DAOを通じて職位情報を取得
            Position position = positionDao.selectByCode(conn, positionCode);

            // 등록 요청에서 필요한 정보들을 가져와서 사원 객체를 생성
            // 登録要求から必要な情報を取得し、社員オブジェクトを作成
            String employeeName = registerRequest.getEmployeeName();
            String employmentType = registerRequest.getEmploymentType();
            String address = registerRequest.getAddress();
            String phoneNumber = registerRequest.getPhoneNumber();
            String email = registerRequest.getEmail();
            int birthNumber = registerRequest.getBirthNumber();
            int residentNumber = registerRequest.getResidentNumber();
            LocalDate hireDate = registerRequest.getHireDate();

           // 사원 객체를 생성하여 등록 요청에서 받은 정보들로 초기화
           // 社員オブジェクトを作成し、登録要求から受信した情報に初期化
            Employee employeeRegister = new Employee(company, department, position, employeeName, employmentType,
                    address, phoneNumber, email, birthNumber, residentNumber, hireDate);

            // 사원 객체를 DB에 등록
            // 社員オブジェクトをDBに登録
            employeeDao.insert(conn, employeeRegister);
			
            conn.commit();

        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn);
        }
    }
}
