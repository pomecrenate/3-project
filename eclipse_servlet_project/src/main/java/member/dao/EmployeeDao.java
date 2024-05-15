package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdbc.JdbcUtil;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

public class EmployeeDao {
  // DAO 클래스들을 사용하기 위한 인스턴스 변수
  // DAOクラスを使用するためのインスタンス変数	
  private CompanyDao companyDao;
  private DepartmentDao departmentDao;
  private PositionDao positionDao;

  // 생성자를 통한 DAO 인스턴스 초기화
  // ジェネレータによるDAOインスタンスの初期化
  public EmployeeDao() {
    this.companyDao = new CompanyDao();
    this.departmentDao = new DepartmentDao();
    this.positionDao = new PositionDao();
  }

  // 주어진 직원 코드로 직원 정보를 조회하는 메서드
  //指定された従業員コードで従業員情報を照会するメソッド
  public Employee selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("employee code: " + code); 

    try {
      pstmt = conn.prepareStatement("SELECT * FROM employee WHERE employee_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Employee employee = null;

      if (rs.next()) {
        // 조회된 직원 정보를 추출하여 객체로 생성
    	// 照会された職員情報を抽出してオブジェクトとして生成  
        int employeeCode = rs.getInt("employee_code");
        int companyCode = rs.getInt("company_code");
        Company company = companyDao.selectByCode(conn, companyCode);
        int departmentCode = rs.getInt("department_code");
        Department department = departmentDao.selectByCode(conn, departmentCode);
        int positionCode = rs.getInt("position_code");
        Position position = positionDao.selectByCode(conn, positionCode);
        String employeeName = rs.getString("employee_name");
        String employmentType = rs.getString("employment_type");
        LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();
        int birthNumber = rs.getInt("birth_number");
        int residentNumber = rs.getInt("resident_number");
        String address = rs.getString("address");
        String phoneNumber = rs.getString("phone_number");
        String email = rs.getString("email");

        // 직원 객체 생성
        // 従業員オブジェクト作成
        employee = new Employee(employeeCode, company, department, position, employeeName,
            employmentType, hireDate, birthNumber, residentNumber, address, phoneNumber, email);
      }
      return employee; // 조회된 직원 객체 반환
      				   // 照会された従業員オブジェクトの返却
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 수정 리스트를 조회하는 메서드
  //修正リストを照会するメソッド
  public List<Employee> selectModifyList(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Employee> employees = new ArrayList<>();

    try {
      // 수정 리스트 조회를 위한 SQL 문장 준비
      // 修正リスト照会のためのSQL文章を準備
      pstmt = conn.prepareStatement(
          "SELECT employee_code, department_code, position_code, employee_name, employment_type, hire_date FROM employee WHERE company_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        // 조회된 정보를 추출하여 객체로 생성하여 리스트에 추가
    	// 照会された情報を抽出してオブジェクトに生成し、リストに追加
        int employeeCode = rs.getInt("employee_code");
        int departmentCode = rs.getInt("department_code");
        Department department = departmentDao.selectByCode(conn, departmentCode);
        int positionCode = rs.getInt("position_code");
        Position position = positionDao.selectByCode(conn, positionCode);
        String employeeName = rs.getString("employee_name");
        String employmentType = rs.getString("employment_type");
        LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();

        Employee employee = new Employee();
        employee.setEmployeeCode(employeeCode);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setEmployeeName(employeeName);
        employee.setEmploymentType(employmentType);
        employee.setHireDate(hireDate);

        employees.add(employee);
      }
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }

    return employees; // 수정 리스트 반환
    		          // 修正リストの返却
  }

  // 삭제 리스트를 조회하는 메서드
  // 削除リストを照会するメソッド
  public List<Employee> selectDeleteList(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Employee> employees = new ArrayList<>();

    try {
      pstmt = conn.prepareStatement(
          "SELECT employee_code, employee_name, department_code, position_code, hire_date FROM employee WHERE company_code = ?");
      pstmt.setInt(1, code);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        // 조회된 정보를 추출하여 객체로 생성하여 리스트에 추가
    	// 照会された情報を抽出してオブジェクトに生成し、リストに追加
        int employeeCode = rs.getInt("employee_code");
        String employeeName = rs.getString("employee_name");
        int departmentCode = rs.getInt("department_code");
        Department department = departmentDao.selectByCode(conn, departmentCode);
        int positionCode = rs.getInt("position_code");
        Position position = positionDao.selectByCode(conn, positionCode);
        LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();

        Employee employee = new Employee();
        employee.setEmployeeCode(employeeCode);
        employee.setEmployeeName(employeeName);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setHireDate(hireDate);

        employees.add(employee);
      }
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }

    return employees; // 삭제 리스트 반환
    				  // 削除リストの返却
  }

  // 직원 정보를 수정하는 메서드
  //従業員情報を修正するメソッド
  public int update(Connection conn, Employee employee) throws SQLException {
    String sql = "UPDATE employee SET department_code = ?, position_code = ?, "
        + "employee_name = ?, employment_type = ?, address = ?, phone_number = ?, email = ?, "
        + "hire_date = ? WHERE employee_code = ?";

    System.out.println("UPDATEemployeName: " + employee.getEmployeeName());

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, employee.getDepartment().getDepartmentCode());
      pstmt.setInt(2, employee.getPosition().getPositionCode());
      pstmt.setString(3, employee.getEmployeeName());
      pstmt.setString(4, employee.getEmploymentType());
      pstmt.setString(5, employee.getAddress());
      pstmt.setString(6, employee.getPhoneNumber());
      pstmt.setString(7, employee.getEmail());
      pstmt.setTimestamp(8, Timestamp.valueOf(employee.getHireDate().atStartOfDay()));
      pstmt.setInt(9, employee.getEmployeeCode());

      return pstmt.executeUpdate(); 
    }
  }

  // 직원 정보를 삭제하는 메서드
  // 従業員情報を削除するメソッド
  public void deleteEmployee(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement("DELETE FROM employee WHERE employee_code = ?");
      pstmt.setInt(1, code);
      pstmt.executeUpdate(); 
    } finally {
      JdbcUtil.close(pstmt);
    }
  }

  // 직원 정보를 추가하는 메서드
  //従業員情報を追加するメソッド
  public void insert(Connection conn, Employee emp) throws SQLException {
    String sql =
        "INSERT INTO employee (employee_code, company_code, department_code, position_code, "
            + "employee_name, employment_type, address, phone_number, email, "
            + "birth_number, resident_number, hire_date) "
            + "VALUES (seq_employee.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, emp.getCompany().getCompanyCode());
      pstmt.setInt(2, emp.getDepartment().getDepartmentCode());
      pstmt.setInt(3, emp.getPosition().getPositionCode());
      pstmt.setString(4, emp.getEmployeeName());
      pstmt.setString(5, emp.getEmploymentType());
      pstmt.setString(6, emp.getAddress());
      pstmt.setString(7, emp.getPhoneNumber());
      pstmt.setString(8, emp.getEmail());
      pstmt.setInt(9, emp.getBirthNumber());
      pstmt.setInt(10, emp.getResidentNumber());
      pstmt.setTimestamp(11, Timestamp.valueOf(emp.getHireDate().atStartOfDay()));

      pstmt.executeUpdate(); 
    }
  }

  // 회사의 고용 형태별 직원 수를 조회하는 메서드
  //会社の雇用形態別従業員数を照会するメソッド
  public Map<String, Integer> employmentType(Connection conn, int companyCode) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Map<String, Integer> typeCount = new LinkedHashMap<>();
    String sql =
        "SELECT employment_type, COUNT(*) AS count FROM employee WHERE company_code = ? GROUP BY employment_type UNION ALL SELECT '전체' AS employment_type, COUNT(*) FROM employee WHERE company_code = ?";

    try {
      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, companyCode);
      pstmt.setInt(2, companyCode);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        // 조회된 결과를 Map에 저장
    	// 照会された結果をMapに保存
        String employmentType = rs.getString("employment_type");
        int count = rs.getInt("count");
        typeCount.put(employmentType, count);
      }
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
    return typeCount; // 고용 형태별 직원 수를 담은 Map 반환
    		  		  // 雇用形態別職員数を盛り込んだMap返還
  }
}
