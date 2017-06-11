package vn.co.cex.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BillOfLading implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7972905636079427908L;

	private Integer id;
	private String code;

	private int goodsTypeId;
	private GoodsType goodsType;
	private int packagedFormId;
	private PackagedForm packagedForm;
	private String goodsImage;
	private float weight;
	private float volume;
	private Integer quantity;
	private float length;
	private float width;
	private float height;
	private String description;
	private boolean isFrozen;
	private boolean isFragile;

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

	private float distance;
	private float price;
	private Date auctionPeriod;

	private int status;
	private boolean notification;

	private int createdUserId;
	private Users user;
	private Date created;
	private Date modified;
	
	private Set<CarrierAuction> carrierAuction = new HashSet<CarrierAuction>();

	private Set<Comment> comment = new HashSet<Comment>();

	public BillOfLading() {

	}

	public BillOfLading(Integer id) {
		this.id = id;
	}

	public BillOfLading(String code, int goodsTypeId, int packagedFormId, String goodsImage, float weight, float volume,
			Integer quantity, float length, float width, float height, String description, boolean isFrozen,
			boolean isFragile, String sender, String senderPhoneNumber, String departureProvince,
			String departureDistrict, String departureAddress, String departureCharacteristicPlace, Date departureDate,
			String receiver, String receiverPhoneNumber, String arrivalProvince, String arrivalDistrict,
			String arrivalAddress, String arrivalCharacteristicPlace, Date arrivalDate, float distance, float price,
			Date auctionPeriod, int status, boolean notification, int createdUserId, Date created, Date modified) {
		super();
		this.code = code;
		this.goodsTypeId = goodsTypeId;
		this.packagedFormId = packagedFormId;
		this.goodsImage = goodsImage;
		this.weight = weight;
		this.volume = volume;
		this.quantity = quantity;
		this.length = length;
		this.width = width;
		this.height = height;
		this.description = description;
		this.isFrozen = isFrozen;
		this.isFragile = isFragile;
		this.sender = sender;
		this.senderPhoneNumber = senderPhoneNumber;
		this.departureProvince = departureProvince;
		this.departureDistrict = departureDistrict;
		this.departureAddress = departureAddress;
		this.departureCharacteristicPlace = departureCharacteristicPlace;
		this.departureDate = departureDate;
		this.receiver = receiver;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.arrivalProvince = arrivalProvince;
		this.arrivalDistrict = arrivalDistrict;
		this.arrivalAddress = arrivalAddress;
		this.arrivalCharacteristicPlace = arrivalCharacteristicPlace;
		this.arrivalDate = arrivalDate;
		this.distance = distance;
		this.price = price;
		this.auctionPeriod = auctionPeriod;
		this.status = status;
		this.notification = notification;
		this.createdUserId = createdUserId;
		this.created = created;
		this.modified = modified;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public int getPackagedFormId() {
		return packagedFormId;
	}

	public void setPackagedFormId(int packagedFormId) {
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public boolean getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(boolean isFragile) {
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

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getAuctionPeriod() {
		return auctionPeriod;
	}

	public void setAuctionPeriod(Date auctionPeriod) {
		this.auctionPeriod = auctionPeriod;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean getNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public int getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
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
}
