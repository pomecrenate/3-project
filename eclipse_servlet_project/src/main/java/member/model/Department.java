package member.model;

public class Department {
	private int departmentCode; // 部署コード
	private String departmentName; // 部署名
	
	// 生成器
	public Department() {
		super();
	}
	
	public Department(int departmentCode, String departmentName) {
		super();
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}
	

	// getter, setter
	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
