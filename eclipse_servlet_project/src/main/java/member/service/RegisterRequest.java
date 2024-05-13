package member.service;

import java.time.LocalDate;

import member.model.Company;
import member.model.Department;
import member.model.Position;

public class RegisterRequest {

	private int departmentCode; // 部署コード
	private int positionCode; // 職位コード
	private String employeeName; // 社員名
	private String employmentType; // 雇用形態
	private String address; // 居所
	private String phoneNumber; // 電話番号
	private String email; // メール
	private int birthNumber; // 生年月日番号
	private int residentNumber; // 住民番号
	private LocalDate hireDate; // 入社日
	private String companyId;

	public int getDepartmentCode() {
		return departmentCode;
	}

	public int getPositionCode() {
		return positionCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getBirthNumber() {
		return birthNumber;
	}

	public int getResidentNumber() {
		return residentNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setPositionCode(int positionCode) {
		this.positionCode = positionCode;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthNumber(int birthNumber) {
		this.birthNumber = birthNumber;
	}

	public void setResidentNumber(int residentNumber) {
		this.residentNumber = residentNumber;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public RegisterRequest(int departmentCode, int positionCode, String employeeName,
			String employmentType, String address, String phoneNumber, String email, int birthNumber,
			int residentNumber, LocalDate hireDate, String companyId) {
		super();
		this.departmentCode = departmentCode;
		this.positionCode = positionCode;
		this.employeeName = employeeName;
		this.employmentType = employmentType;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthNumber = birthNumber;
		this.residentNumber = residentNumber;
		this.hireDate = hireDate;
		this.companyId = companyId;
	}

	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
