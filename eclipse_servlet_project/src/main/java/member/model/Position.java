package member.model;

public class Position {
	private int positionCode; // 職位コード
	private String positionName; // 職位名
	
	// 生成器	
	public Position(int positionCode, String positionName) {
		super();
		this.positionCode = positionCode;
		this.positionName = positionName;
	}

	// getter, setter
	public int getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(int positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	
}
