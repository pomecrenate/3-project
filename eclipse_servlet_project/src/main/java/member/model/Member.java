package member.model;

import java.util.Date;

public class Member {
	private String id;
	private String name;
	private String password;
	private Date regDate;

	public Member(String id, String name, String password, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegDate() {
		return regDate;
	}

	// 기존 비밀번호와 일치하는지 확인
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	// 기존 비밀번호를 새로운 비밀번호로 변경
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
}
