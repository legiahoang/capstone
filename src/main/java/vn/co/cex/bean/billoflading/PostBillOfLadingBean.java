package vn.co.cex.bean.billoflading;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.ProvinceBO;
import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.bo.OperationFeeBO;
import vn.co.cex.bo.PaymentDetailBO;
import vn.co.cex.orm.GoodsType;
import vn.co.cex.orm.OperationFee;
import vn.co.cex.orm.PackagedForm;
import vn.co.cex.orm.PaymentDetail;
import vn.co.cex.orm.Province;
import vn.co.cex.orm.UsersAccount;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.FileUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "postBillOfLadingBean", eager = true)
@ViewScoped
public class PostBillOfLadingBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(PostBillOfLadingBean.class);
	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;

	@ManagedProperty(value = "#{provinceBO}")
	private ProvinceBO provinceBO;

	@ManagedProperty(value = "#{usersAccountBO}")
	private UsersAccountBO usersAccountBO;

	@ManagedProperty(value = "#{paymentDetailBO}")
	private PaymentDetailBO paymentDetailBO;

	@ManagedProperty(value = "#{operationFeeBO}")
	private OperationFeeBO operationFeeBO;

	private BillOfLading billOfLading;

	public BillOfLading getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(BillOfLading billOfLading) {
		this.billOfLading = billOfLading;
	}

	public int postStatus;

	public int getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(int postStatus) {
		this.postStatus = postStatus;
	}

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UsersAccountBO getUsersAccountBO() {
		return usersAccountBO;
	}

	public void setUsersAccountBO(UsersAccountBO usersAccountBO) {
		this.usersAccountBO = usersAccountBO;
	}

	public PaymentDetailBO getPaymentDetailBO() {
		return paymentDetailBO;
	}

	public void setPaymentDetailBO(PaymentDetailBO paymentDetailBO) {
		this.paymentDetailBO = paymentDetailBO;
	}

	public OperationFeeBO getOperationFeeBO() {
		return operationFeeBO;
	}

	public void setOperationFeeBO(OperationFeeBO operationFeeBO) {
		this.operationFeeBO = operationFeeBO;
	}

	public Date getCurrentDate() {
		return new Date();
	}

	/**
	 * Init data and authentication
	 */
	@PostConstruct
	public void init() {
		try {
			Users user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (user == null || (user.getRole() == ConstantUtils.USER_CARRIER)) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			billOfLading = new BillOfLading();
		} catch (Exception e) {
			log.debug(e);
		}
	}

	private String code;
	private Integer goodsTypeId;
	private GoodsType goodsType;
	private Integer packagedFormId;
	private PackagedForm packagedForm;
	private String goodsImage;
	private Float weight;
	private Integer quantity;
	private Float length;
	private Float width;
	private Float height;
	private String description;
	private Boolean isFrozen;
	private Boolean isFragile;

	private String sender;
	private String senderPhoneNumber;
	private String departureProvince;
	private String departureDistrict;
	private String departureAddress;
	private String departureCharacteristicPlace;
	private Date departureDate;

	private String receiver;
	private String receiverPhoneNumber;
	private String arrivalProvince;
	private String arrivalDistrict;
	private String arrivalAddress;
	private String arrivalCharacteristicPlace;
	private Date arrivalDate;

	private Float distance;
	private Float price;
	private Date auctionPeriod;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getPackagedFormId() {
		return packagedFormId;
	}

	public void setPackagedFormId(Integer packagedFormId) {
		this.packagedFormId = packagedFormId;
	}

	public PackagedForm getPackagedForm() {
		return packagedForm;
	}

	public void setPackagedForm(PackagedForm packagedForm) {
		this.packagedForm = packagedForm;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(Boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public Boolean getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(Boolean isFragile) {
		this.isFragile = isFragile;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}

	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber = senderPhoneNumber;
	}

	public String getDepartureProvince() {
		return departureProvince;
	}

	public void setDepartureProvince(String departureProvince) {
		this.departureProvince = departureProvince;
	}

	public String getDepartureDistrict() {
		return departureDistrict;
	}

	public void setDepartureDistrict(String departureDistrict) {
		this.departureDistrict = departureDistrict;
	}

	public String getDepartureAddress() {
		return departureAddress;
	}

	public void setDepartureAddress(String departureAddress) {
		this.departureAddress = departureAddress;
	}

	public String getDepartureCharacteristicPlace() {
		return departureCharacteristicPlace;
	}

	public void setDepartureCharacteristicPlace(String departureCharacteristicPlace) {
		this.departureCharacteristicPlace = departureCharacteristicPlace;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}

	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}

	public String getArrivalProvince() {
		return arrivalProvince;
	}

	public void setArrivalProvince(String arrivalProvince) {
		this.arrivalProvince = arrivalProvince;
	}

	public String getArrivalDistrict() {
		return arrivalDistrict;
	}

	public void setArrivalDistrict(String arrivalDistrict) {
		this.arrivalDistrict = arrivalDistrict;
	}

	public String getArrivalAddress() {
		return arrivalAddress;
	}

	public void setArrivalAddress(String arrivalAddress) {
		this.arrivalAddress = arrivalAddress;
	}

	public String getArrivalCharacteristicPlace() {
		return arrivalCharacteristicPlace;
	}

	public void setArrivalCharacteristicPlace(String arrivalCharacteristicPlace) {
		this.arrivalCharacteristicPlace = arrivalCharacteristicPlace;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getAuctionPeriod() {
		return auctionPeriod;
	}

	public void setAuctionPeriod(Date auctionPeriod) {
		this.auctionPeriod = auctionPeriod;
	}

	public BillOfLadingBO getBillOfLadingBO() {
		return billOfLadingBO;
	}

	public void setBillOfLadingBO(BillOfLadingBO billOfLadingBO) {
		this.billOfLadingBO = billOfLadingBO;
	}

	public ProvinceBO getProvinceBO() {
		return provinceBO;
	}

	public void setProvinceBO(ProvinceBO provinceBO) {
		this.provinceBO = provinceBO;
	}

	/**
	 * Add new bill of lading to action
	 */
	public void postBillOfLading() {
		try {
			Users user = SessionUtils.getUser();
			UsersAccount usersAccount = usersAccountBO.getAccountByUserId(user.getId());
			OperationFee fee1 = operationFeeBO.getOperationFeeByCode(ConstantUtils.FEE_CODE_POST_BILLOFLADING);
			OperationFee fee2 = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_GOODSOWNER);
			float amount = (fee2.getPercent() / 100) * price;
			if (usersAccount.getBalance() < fee1.getFee() + amount) {
				postStatus = ConstantUtils.ACCOUNT_BALANCE_NOT_ENOUGH;
				return;
			}
			float volume = length * width * height;
			Province departureProvinceParam = provinceBO.getProcinveByCode(departureProvince);
			String departureProvinceName = "";
			String arrivalProvinceName = "";
			if (departureProvinceParam != null) {
				departureProvinceName = departureProvinceParam.getName();
			}
			Province arrivalProvinceParam = provinceBO.getProcinveByCode(arrivalProvince);
			if (arrivalProvinceParam != null) {
				arrivalProvinceName = arrivalProvinceParam.getName();
			}
			// Save bill of lading to database
			BillOfLading data = new BillOfLading(code, goodsTypeId, packagedFormId, fileName, weight, volume,
					quantity, length, width, height, description, isFrozen, isFragile, sender, senderPhoneNumber,
					departureProvinceName, departureDistrict, departureAddress, departureCharacteristicPlace,
					departureDate, receiver, receiverPhoneNumber, arrivalProvinceName, arrivalDistrict, arrivalAddress,
					arrivalCharacteristicPlace, arrivalDate, distance, price, auctionPeriod,
					ConstantUtils.BILLOFLADING_BIDDING, false, user.getId(), new Date(), new Date());

			boolean result = billOfLadingBO.addNewBillOfLading(data);
			// Payment
			if (result) {
				usersAccountBO.minusMoneyAccount(user.getId(), fee1.getFee());
				// Add payment detail
				PaymentDetail paymentDetail1 = new PaymentDetail();
				paymentDetail1.setAmounts(fee1.getFee());
				paymentDetail1.setPaymentDate(new Date());
				paymentDetail1.setType(ConstantUtils.PAYMENT_MINUS);
				paymentDetail1.setDescription("Phí đăng vận đơn.");
				paymentDetail1.setUserId(user.getId());
				paymentDetail1.setBillOfLadingId(data.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail1);

				// EARNEST MONEY
				usersAccountBO.minusMoneyAccount(user.getId(), amount);
				PaymentDetail paymentDetail2 = new PaymentDetail();
				paymentDetail2.setAmounts(amount);
				paymentDetail2.setPaymentDate(new Date());
				paymentDetail2.setType(ConstantUtils.PAYMENT_MINUS);
				paymentDetail2.setDescription("Tiền đặt cọc đăng vận đơn.");
				paymentDetail2.setUserId(user.getId());
				paymentDetail1.setBillOfLadingId(data.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail2);
			}
			postStatus = ConstantUtils.PROCESS_SUCCESS;
		} catch (Exception e) {
			log.debug(e);
			postStatus = ConstantUtils.PROCESS_FAILURE;
		}
	}

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Upload file image
	 * 
	 * @param event
	 */
	public void uploadGoodsImage(FileUploadEvent event) {
		try {
			UploadedFile file = event.getFile();
			if (file != null) {
				fileName = System.currentTimeMillis() + "_" + file.getFileName();
				FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
				byte[] contents = file.getContents();
				String filePath = "goodsimages/" + fileName;
				FileUtils.saveFile(filePath, contents);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Redirect to list operation fee page
	 * 
	 * @return
	 */
	public String gotoListBillOfLading() {
		return "listBillOfLading";
	}
}
