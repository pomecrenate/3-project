package member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String name;
	private String password;
	private String confirmPassword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// 에러 검증
	public void validate(Map<String, Boolean> errors) {
		// 값이 없으면 해당 컬럼 에러
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");

		// confirmPassword 값이 있고 암호와 일치하지 않으면 notMatch 에러
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	// 암호 일치 검증
	private boolean isPasswordEqualToConfirm() { // 암호 일치하면 true
		return password != null && password.equals(confirmPassword);
	}

	// Null 검증
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) { // 값이 없으면 에러
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
