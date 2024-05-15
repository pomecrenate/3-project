package auth.service;

import java.time.LocalDate;
import java.util.Map;

public class JoinRequest {
  private int businessTypeCode; // 業態コード
  private int businessItemCode; // 種目コード
  private String id; // アイディー
  private String password; // パスワード
  private String companyName; // 社名
  private String ceoName; // 代表者名
  private String businessNumber; // 事業者番号
  private String corporateNumber; // 法人登録番号
  private LocalDate establishmentDate; // 設立日
  private String website; // ホームページ
  private String address; // 事業場の住所
  private String phoneNumber; // 電話番号
  private String faxNumber; // ファックス番号
  private String confirmPassword; // パスワード確認

  public int getBusinessTypeCode() {
    return businessTypeCode;
  }

  public void setBusinessTypeCode(int businessTypeCode) {
    this.businessTypeCode = businessTypeCode;
  }

  public int getBusinessItemCode() {
    return businessItemCode;
  }

  public void setBusinessItemCode(int businessItemCode) {
    this.businessItemCode = businessItemCode;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCeoName() {
    return ceoName;
  }

  public void setCeoName(String ceoName) {
    this.ceoName = ceoName;
  }

  public String getBusinessNumber() {
    return businessNumber;
  }

  public void setBusinessNumber(String businessNumber) {
    this.businessNumber = businessNumber;
  }

  public String getCorporateNumber() {
    return corporateNumber;
  }

  public void setCorporateNumber(String corporateNumber) {
    this.corporateNumber = corporateNumber;
  }

  public LocalDate getEstablishmentDate() {
    return establishmentDate;
  }

  public void setEstablishmentDate(LocalDate establishmentDate) {
    this.establishmentDate = establishmentDate;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
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

  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
  //エラー検証
  // 에러 검증
  public void validate(Map<String, Boolean> errors) {
    // 값이 없으면 해당 컬럼 에러	// 値がない場合は、該当カラムエラー
    checkEmptyForInt(errors, businessTypeCode, "businessTypeCode");
    checkEmptyForInt(errors, businessItemCode, "businessItemCode");
    checkEmpty(errors, id, "id");
    checkEmpty(errors, password, "password");
    checkEmpty(errors, companyName, "companyName");
    checkEmpty(errors, ceoName, "ceoName");
    checkEmpty(errors, businessNumber, "businessNumber");
    checkEmpty(errors, corporateNumber, "corporateNumber");
    checkEmptyForLocalDate(errors, establishmentDate, "establishmentDate");
    checkEmpty(errors, website, "website");
    checkEmpty(errors, address, "address");
    checkEmpty(errors, phoneNumber, "phoneNumber");
    checkEmpty(errors, faxNumber, "faxNumber");
    checkEmpty(errors, confirmPassword, "confirmPassword");
 // confirmPassword値があってパスワードと一致しないとnotMatchエラー
    // confirmPassword 값이 있고 암호와 일치하지 않으면 notMatch 에러
    if (!errors.containsKey("confirmPassword")) {
      if (!isPasswordEqualToConfirm()) {
        errors.put("notMatch", Boolean.TRUE);
      }
    }
  }
  //暗号一致検証
  // 암호 일치 검증									// 暗号一致するとtrue
  private boolean isPasswordEqualToConfirm() { // 암호 일치하면 true
    return password != null && password.equals(confirmPassword);
  }
  //Null検証
  // Null 검증
  private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
    if (value == null || value.isEmpty()) { // 값이 없으면 에러	// 値がなければエラー
      errors.put(fieldName, Boolean.TRUE);
    }
  }

  private void checkEmptyForInt(Map<String, Boolean> errors, int value, String fieldName) {
    if (value == 0) { // 값이 없으면 에러				// 値がなければエラー
      errors.put(fieldName, Boolean.TRUE);
    }
  }

  private void checkEmptyForLocalDate(Map<String, Boolean> errors, LocalDate value,
      String fieldName) {
    if (value == null) { // 값이 없으면 에러		// 値がなければエラー
      errors.put(fieldName, Boolean.TRUE);
    }
  }
}
