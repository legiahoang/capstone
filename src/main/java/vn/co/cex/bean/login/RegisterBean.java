package vn.co.cex.bean.login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.ProvinceBO;
import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.bo.UsersBO;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.FileUtils;
import vn.co.cex.utils.mail.MailerBean;
import vn.co.cex.utils.mail.TNMailMessage;

@ManagedBean(name = "registerBean", eager = true)
@ViewScoped
public class RegisterBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(RegisterBean.class);

	@ManagedProperty(value = "#{mailerBean}")
	private MailerBean mailerBean;

	@ManagedProperty(value = "#{usersBO}")
	private UsersBO usersBO;

	@ManagedProperty(value = "#{usersAccountBO}")
	private UsersAccountBO usersAccountBO;

	@ManagedProperty(value = "#{provinceBO}")
	private ProvinceBO provinceBO;

	public ProvinceBO getProvinceBO() {
		return provinceBO;
	}

	public void setProvinceBO(ProvinceBO provinceBO) {
		this.provinceBO = provinceBO;
	}

	public UsersAccountBO getUsersAccountBO() {
		return usersAccountBO;
	}

	public void setUsersAccountBO(UsersAccountBO usersAccountBO) {
		this.usersAccountBO = usersAccountBO;
	}

	public UsersBO getUsersBO() {
		return usersBO;
	}

	public void setUsersBO(UsersBO usersBO) {
		this.usersBO = usersBO;
	}

	public MailerBean getMailerBean() {
		return mailerBean;
	}

	public void setMailerBean(MailerBean mailerBean) {
		this.mailerBean = mailerBean;
	}

	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String province;
	private String district;
	private String identityCard;
	private String identityCardPlace;
	private Date identityCardDate;
	private String identityCardImage;
	private int role;
	private int status;
	private Date created;
	private Integer companyId;
	private String userAvatar;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getIdentityCardImage() {
		return identityCardImage;
	}

	public void setIdentityCardImage(String identityCardImage) {
		this.identityCardImage = identityCardImage;
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

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	@PostConstruct
	public void init() {
	}

	/**
	 * Register user
	 * 
	 * @return
	 */
	public String registerUser() {
		try {
			// Check if the email not exited
			if (usersBO.checkEmail(email)) {
				// Check if the phone number not exited
				if (usersBO.checkPhoneNumber(phoneNumber)) {
					// Check if the identity card number not exited
					if (usersBO.checkIdentityCard(identityCard)) {
						// Hash password to MD5
						MessageDigest md5 = MessageDigest.getInstance("MD5");
						byte[] bufor = password.getBytes();
						md5.update(bufor, 0, bufor.length);
						BigInteger hash = new BigInteger(1, md5.digest());
						String passwordMD5 = String.format("%1$032X", hash);

						// String fileName = "";
						// // Update fileAvatar to C:\root\UserAvatar
						// if (file != null) {
						// fileName = System.currentTimeMillis() + "_" +
						// file.getFileName();
						// FacesMessage message = new FacesMessage("Succesful",
						// file.getFileName() + " is uploaded.");
						// FacesContext.getCurrentInstance().addMessage(null,
						// message);
						// byte[] bytes = file.getContents();
						// String filePath = "IdentityCardImage/" + fileName;
						// FileUtils.saveFile(filePath, bytes);
						// }

						Users user = new Users(fullName, email, passwordMD5, phoneNumber, address, district,
								identityCard, identityCardPlace, identityCardDate, fileName, role, status, new Date(),
								companyId, userAvatar);
						// Insert to database
						int resultRegister = usersBO.register(user);
						if (resultRegister > 0) {
							int userId = user.getId();
							usersAccountBO.createNewAccount(userId);
							sendMailRegister(user);
							return ConstantUtils.REGISTER_MESSAGE;
						}

					} else {
						FacesMessage facesMessage = new FacesMessage("Số chứng minh thư đã được đăng ký!");
						FacesContext.getCurrentInstance().addMessage(null, facesMessage);
					}
				} else {
					FacesMessage facesMessage = new FacesMessage("Số điện thoại bạn vừa nhập đã có người sử dụng!");
					FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				}

			} else {
				FacesMessage facesMessage = new FacesMessage("Địa chỉ email đã được đăng ký!");
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return ConstantUtils.REGISTER;
	}

	/**
	 * Upload file image
	 * 
	 * @param event
	 */
	public void uploadIdentityCardImg(FileUploadEvent event) {
		try {
			UploadedFile file = event.getFile();
			if (file != null) {
				fileName = System.currentTimeMillis() + "_" + file.getFileName();
				FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				byte[] contents = file.getContents();
				String filePath = "IdentityCardImage/" + fileName;
				FileUtils.saveFile(filePath, contents);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Send mail register
	 * 
	 * @param user
	 */
	public void sendMailRegister(Users user) {
		try {
			// Encrypt code
			final String salt = KeyGenerators.string().generateKey();

			TextEncryptor encryptor = Encryptors.text(ConstantUtils.PASSWORD_KEY, salt);
			String textToEncrypt = user.getEmail() + "\\" + new Date();
			String encryptedText = encryptor.encrypt(textToEncrypt);
			String typeAccount = "";
			if (user.getRole() == 2) {
				typeAccount = ConstantUtils.ROLE_GOODS_OWNER;
			} else if (user.getRole() == 3) {
				typeAccount = ConstantUtils.ROLE_CARRIER;
			} else if (user.getRole() == 1) {
				typeAccount = ConstantUtils.ROLE_ADMIN;
			}
			// send mail
			TNMailMessage mail = new TNMailMessage();
			mail.setFrom("carriertradingcenter@gmail.com");
			mail.setToList(new String[] { user.getEmail() });
			mail.setSubject("Chào mừng đến với Sàn Giao Dịch Vận Tải");
			mail.setSignature("Sàn Giao Dịch Vận Tải.");
			StringBuilder content = new StringBuilder();
			String linkConfirm = new StringBuilder(ConstantUtils.HOST_URL)
					.append("CEX/faces/xhtml/Users/Confirm.xhtml?code=").append(salt).append(encryptedText).toString();
			String linkWebsite = "http://carriertradingcenter.com/CEX/faces/xhtml/Home.xhtml";
			content.append("Chào bạn " + user.getFullName() + "!" + "<br/><br/>");
			content.append("<i> Đây là email tự động được gửi từ website: </i>" + "<a href=\"" + linkWebsite
					+ "\">http://carriertradingcenter.com</a>" + "<br/>");
			content.append("Bạn vừa sử dụng địa chỉ mail " + user.getEmail() + " để đăng ký trên " + "<a href=\""
					+ linkWebsite + "\">http://carriertradingcenter.com</a>," + "<br/>"
					+ " với thông tin đăng nhập như sau: " + "<br/>");
			content.append("Loại tài khoản: " + typeAccount + "<br/>");
			content.append("Địa chỉ email: " + user.getEmail() + "<br/>");
			content.append("Số điện thoại: " + user.getPhoneNumber() + "<br/>");
			content.append("Vui lòng click vào link dưới đây để kích hoạt tài khoản." + "<br/>");
			content.append("<h4><a href=\"" + linkConfirm + "\">KÍCH HOẠT TÀI KHOẢN</a></h4>");
			content.append(
					"<i>Sàn giao dịch vận tải trân trọng cảm ơn sự quan tâm của Quý khách tới hoạt động và dịch vụ của Sàn giao dịch vận tải.</i>"
							+ "<br/>");
			content.append("<i>Mọi ý kiến thắc mắc xin liên hệ </i>" + "<br/>");
			content.append("<i>Sàn giao dịch vận tải - " + "<a href=\"" + linkWebsite
					+ "\">http://carriertradingcenter.com</a></i>" + "<br/>");
			content.append("Hotline: " + "(+84)-1669-775-349" + "<br/><br/>");
			content.append("Trân trọng." + "<br/>");
			mail.setContent(content.toString());
			mailerBean.sendMail(mail);
		} catch (Exception e) {
			log.error(e);
		}
	}
}
