package member.model;

public class BusinessItem {
	private int businessItemCode; // 種目コード
	private String businessItemName; // 種目名
	
	// 生成器
	public BusinessItem(int businessItemCode, String businessItemName) {
		super();
		this.businessItemCode = businessItemCode;
		this.businessItemName = businessItemName;
	}

	// getter, setter
	public int getBusinessItemCode() {
		return businessItemCode;
	}

	public void setBusinessItemCode(int businessItemCode) {
		this.businessItemCode = businessItemCode;
	}

	public String getBusinessItemName() {
		return businessItemName;
	}

	public void setBusinessItemName(String businessItemName) {
		this.businessItemName = businessItemName;
	}

	
	
}
