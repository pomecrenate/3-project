package member.model;

public class BusinessType {
	private int businessTypeCode; // 業態コード
	private String businessTypeName; // 業態名
	
	// 生成器
	public BusinessType() {
		super();
	}
	
	public BusinessType(int businessTypeCode, String businessTypeName) {
		super();
		this.businessTypeCode = businessTypeCode;
		this.businessTypeName = businessTypeName;
	}


	// getter, setter
	public int getBusinessTypeCode() {
		return businessTypeCode;
	}

	public void setBusinessTypeCode(int businessTypeCode) {
		this.businessTypeCode = businessTypeCode;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}
	
	
	
}
