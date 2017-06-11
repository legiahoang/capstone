package vn.co.cex.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -774134132019326906L;

	private Integer id;
	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String identityCard;
	private String identityCardPlace;
	private Date identityCardDate;
	private String identityCardImage;
	private int role;
	private int status;
	private Date created;
	private Integer companyId;
	private Company company;
	private String userAvatar;

	private Set<BillOfLading> billOfLading = new HashSet<BillOfLading>();

	private Set<CarrierAuction> carrierAuction = new HashSet<CarrierAuction>();

	private Set<Comment> comment = new HashSet<Comment>();

	private Set<AnswerComment> answerComment = new HashSet<AnswerComment>();

	private Set<Report> report = new HashSet<Report>();

	private UsersAccount usersAccount;

	private String districtCode;
	private District district;

	public Users() {

	}

	public Users(Integer id) {
		this.id = id;
	}

	public Users(String fullName, String email, String password, String phoneNumber, String address,
			String districtCode, String identityCard, String identityCardPlace, Date identityCardDate,
			String identityCardImage, int role, int status, Date created, Integer companyId, String userAvatar) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.districtCode = districtCode;
		this.identityCard = identityCard;
		this.identityCardPlace = identityCardPlace;
		this.identityCardDate = identityCardDate;
		this.identityCardImage = identityCardImage;
		this.role = role;
		this.status = status;
		this.created = created;
		this.companyId = companyId;
		this.userAvatar = userAvatar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getIdentityCardPlace() {
		return identityCardPlace;
	}

	public void setIdentityCardPlace(String identityCardPlace) {
		this.identityCardPlace = identityCardPlace;
	}

	public Date getIdentityCardDate() {
		return identityCardDate;
	}

	public void setIdentityCardDate(Date identityCardDate) {
		this.identityCardDate = identityCardDate;
	}

	public String getIdentityCardImage() {
		return identityCardImage;
	}

	public void setIdentityCardImage(String identityCardImage) {
		this.identityCardImage = identityCardImage;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Set<BillOfLading> getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(Set<BillOfLading> billOfLading) {
		this.billOfLading = billOfLading;
	}

	public Set<CarrierAuction> getCarrierAuction() {
		return carrierAuction;
	}

	public void setCarrierAuction(Set<CarrierAuction> carrierAuction) {
		this.carrierAuction = carrierAuction;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Set<AnswerComment> getAnswerComment() {
		return answerComment;
	}

	public void setAnswerComment(Set<AnswerComment> answerComment) {
		this.answerComment = answerComment;
	}

	public Set<Report> getReport() {
		return report;
	}

	public void setReport(Set<Report> report) {
		this.report = report;
	}

	public UsersAccount getUsersAccount() {
		return usersAccount;
	}

	public void setUsersAccount(UsersAccount usersAccount) {
		this.usersAccount = usersAccount;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
