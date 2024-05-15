package member.model; 
 
import java.time.LocalDate; 
 
public class Company { 
 
  private int companyCode; // 会社コード 
  private BusinessType businessType; // 業態コード 
  private BusinessItem businessItem; // 種目コード 
  private String id; // アイディー 
  private String password; // パスワード 
  private LocalDate registerDate; // 加入日 
  private String companyName; // 社名 
  private String ceoName; // 代表者名 
  private String businessNumber; // 事業者番号 
  private String corporateNumber; // 法人登録番号 
  private LocalDate establishmentDate; // 設立日 
  private String website; // ホームページ 
  private String address; // 事業場の住所 
  private String phoneNumber; // 電話番号 
  private String faxNumber; // ファックス番号 
 
  // 生成器 
  public Company() { 
    super(); 
  } 
 
  public Company(int companyCode, BusinessType businessType, BusinessItem businessItem, String password,
		String companyName, String ceoName, String businessNumber, String corporateNumber, LocalDate establishmentDate,
		String website, String address, String phoneNumber, String faxNumber) {
	super();
	this.companyCode = companyCode;
	this.businessType = businessType;
	this.businessItem = businessItem;
	this.password = password;
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

public Company(int companyCode, BusinessType businessType, BusinessItem businessItem, String id, 
      String password, LocalDate registerDate, String companyName, String ceoName, 
      String businessNumber, String corporateNumber, LocalDate establishmentDate, String website, 
      String address, String phoneNumber, String faxNumber) { 
    super(); 
    this.companyCode = companyCode; 
    this.businessType = businessType; 
    this.businessItem = businessItem; 
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
 
  public Company(BusinessType businessType, BusinessItem businessItem, String id, String password, 
      LocalDate registerDate, String companyName, String ceoName, String businessNumber, 
      String corporateNumber, LocalDate establishmentDate, String website, String address, 
      String phoneNumber, String faxNumber) { 
    super(); 
    this.businessType = businessType; 
    this.businessItem = businessItem; 
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
 
  // getter, setter 
  public int getCompanyCode() { 
    return companyCode; 
  } 
 
  public void setCompanyCode(int companyCode) { 
    this.companyCode = companyCode; 
  } 
 
  public BusinessType getBusinessType() { 
    return businessType; 
  } 
 
  public void setBusinessType(BusinessType businessType) { 
    this.businessType = businessType; 
  } 
 
  public BusinessItem getBusinessItem() { 
    return businessItem; 
  } 
 
  public void setBusinessItem(BusinessItem businessItem) { 
    this.businessItem = businessItem; 
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
 
  // 기존 비밀번호와 일치하는지 확인 
  public boolean matchPassword(String password) { 
    return this.password.equals(password); 
  } 
 
  // 기존 비밀번호를 새로운 비밀번호로 변경 
  public void changePassword(String newPassword) { 
    this.password = newPassword; 
  } 
} 
