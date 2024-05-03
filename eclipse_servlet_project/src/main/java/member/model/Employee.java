package member.model;
import java.time.LocalDate;

public class Employee{
	
	private int employeeCode; // 社員コード
	private Company company; // 会社コード
	private Department department; // 部署コード
	private Position position; // 職位コード
	private String employeeName; // 社員名
	private String employmentType; // 雇用形態
	private LocalDate hireDate; // 入社日
	private String address; // 居所
	private String phoneNumber; // 電話番号
	private String email; // メール
	private LocalDate birthdate; // 生年月日
	private String status; // 状態
	
	// 生成器
	public Employee(int employeeCode, Company company, Department department, Position position, String employeeName,
			String employmentType, LocalDate hireDate, String address, String phoneNumber, String email,
			LocalDate birthdate, String status) {
		super();
		this.employeeCode = employeeCode;
		this.company = company;
		this.department = department;
		this.position = position;
		this.employeeName = employeeName;
		this.employmentType = employmentType;
		this.hireDate = hireDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthdate = birthdate;
		this.status = status;
	}

	// getter, setter
	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
	
}
