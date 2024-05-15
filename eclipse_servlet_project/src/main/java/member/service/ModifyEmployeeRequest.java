package member.service;

import java.time.LocalDate;
import java.util.Map;

import member.model.Company;
import member.model.Department;
import member.model.Position;
// 社員情報修正時の情報集合
public class ModifyEmployeeRequest {

	private int employeeCode; // 社員コード
	private int companyCode; // 会社コード
	private int departmentCode; // 部署コード
	private int positionCode; // 職位コード
	private String employeeName; // 社員名
	private String employmentType; // 雇用形態
	private LocalDate hireDate; // 入社日
	private int birthNumber; // 生年月日番號
	private int residentNumber; // 住民番號
	private String address; // 居所
	private String phoneNumber; // 電話番號
	private String email; // メール
	private String companyId; // 会社のID
	 
	public ModifyEmployeeRequest() {
		super();
	}
	public ModifyEmployeeRequest(int employeeCode, int companyCode, int departmentCode, int positionCode, String employeeName,
			String employmentType, String address, String phoneNumber, String email, LocalDate hireDate,
			int birthNumber, int residentNumber, String companyId) {
		super();
		this.employeeCode = employeeCode;
		this.companyCode = companyCode;
		this.departmentCode = departmentCode;
		this.positionCode = positionCode;
		this.employeeName = employeeName;
		this.employmentType = employmentType;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.hireDate = hireDate;
		this.birthNumber = birthNumber;
		this.residentNumber = residentNumber;
		this.companyId = companyId;
	}
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public int getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}
	public int getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(int positionCode) {
		this.positionCode = positionCode;
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
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public int getBirthNumber() {
		return birthNumber;
	}
	public void setBirthNumber(int birthNumber) {
		this.birthNumber = birthNumber;
	}
	public int getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(int residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	

	
	
	// 에러 검증
	// エラー検証
	public void validate(Map<String, Boolean> errors) {
		// 값이 없으면 해당 컬럼 에러, 値がない場合は、該当カラムエラー
		// 사원 테이블에서 낫널인 애들만 체크엠티, 社員テーブルでnot nullの値だけcheck Empty設定
		checkEmptyForInt(errors, employeeCode, "employeeCode");
		checkEmptyForInt(errors, companyCode, "companyCode");
		checkEmpty(errors, employeeName, "employeeName");
		checkEmpty(errors, employmentType, "employmentType");
		checkEmptyForLocalDate(errors, hireDate, "hireDate");
		checkEmpty(errors, companyId, "companyId");


	}
	
	// Null 검증
	// Null 検証
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) { // 값이 없으면 에러
			errors.put(fieldName, Boolean.TRUE);
		}
	}

	private void checkEmptyForInt(Map<String, Boolean> errors, int value, String fieldName) {
		if (value == 0) { // 값이 없으면 에러, 値がなければエラー
			errors.put(fieldName, Boolean.TRUE);
		}
	}

	private void checkEmptyForLocalDate(Map<String, Boolean> errors, LocalDate value, String fieldName) {
		if (value == null) { // 값이 없으면 에러, 値がなければエラー
			errors.put(fieldName, Boolean.TRUE);
		}
	}



}
