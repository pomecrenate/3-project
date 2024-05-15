package member.service;

import java.time.LocalDate;
import java.util.Map;

// 会社情報を修正する際の情報の集合
public class ModifyCompanyRequest {

  private int companyCode;
  private int businessTypeCode;
  private int businessItemCode;
  private String id;
  private String password;
  private LocalDate registerDate;
  private String companyName;
  private String ceoName;
  private String businessNumber;
  private String corporateNumber;
  private LocalDate establishmentDate;
  private String website;
  private String address;
  private String phoneNumber;
  private String faxNumber;


  public ModifyCompanyRequest() {
    super();
  }


  public ModifyCompanyRequest(int companyCode, int businessTypeCode, int businessItemCode,
      String id, String password, LocalDate registerDate, String companyName, String ceoName,
      String businessNumber, String corporateNumber, LocalDate establishmentDate, String website,
      String address, String phoneNumber, String faxNumber) {
    super();
    this.companyCode = companyCode;
    this.businessTypeCode = businessTypeCode;
    this.businessItemCode = businessItemCode;
    this.id = id;
    this.password = password;
    this.registerDate = registerDate;
    this.companyName = companyName;
    this.ceoName = ceoName;
    this.businessNumber = businessNumber;
    this.corporateNumber = corporateNumber;
    this.establishmentDate = establishmentDate;
    this.website = website;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.faxNumber = faxNumber;
  }


  public int getCompanyCode() {
    return companyCode;
  }


  public void setCompanyCode(int companyCode) {
    this.companyCode = companyCode;
  }


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


  public LocalDate getRegisterDate() {
    return registerDate;
  }


  public void setRegisterDate(LocalDate registerDate) {
    this.registerDate = registerDate;
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

  // 에러 검증
  // エラー検証
  public void validate(Map<String, Boolean> errors) {
    // 값이 없으면 해당 컬럼 에러, 値がない場合は、該当カラムエラー
    // 회사 테이블에서 낫널인 애들만 체크엠티, 社員テーブルでnot nullの値だけcheck Empty設定
    checkEmptyForInt(errors, companyCode, "companyCode");
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


  }

  // Null 검증
  // Null 検証
  private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
    if (value == null || value.isEmpty()) { // 값이 없으면 에러, 値がなければエラー
      errors.put(fieldName, Boolean.TRUE);
    }
  }

  private void checkEmptyForInt(Map<String, Boolean> errors, int value, String fieldName) {
    if (value == 0) { // 값이 없으면 에러, 値がなければエラー
      errors.put(fieldName, Boolean.TRUE);
    }
  }

  private void checkEmptyForLocalDate(Map<String, Boolean> errors, LocalDate value,
      String fieldName) {
    if (value == null) { // 값이 없으면 에러
      errors.put(fieldName, Boolean.TRUE);
    }
  }



}
