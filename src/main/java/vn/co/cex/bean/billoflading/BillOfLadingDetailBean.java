package vn.co.cex.bean.billoflading;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.context.RequestContext;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.CarrierAuctionBO;
import vn.co.cex.bo.CommentBO;
import vn.co.cex.bo.OperationFeeBO;
import vn.co.cex.bo.PaymentDetailBO;
import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.dto.CarrierAuctionDTO;
import vn.co.cex.dto.CommentDTO;
import vn.co.cex.dto.BillOfLadingDTO;
import vn.co.cex.orm.CarrierAuction;
import vn.co.cex.orm.Comment;
import vn.co.cex.orm.OperationFee;
import vn.co.cex.orm.PaymentDetail;
import vn.co.cex.orm.AnswerComment;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.Users;
import vn.co.cex.orm.UsersAccount;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "billOfLadingDetailBean", eager = true)
@ViewScoped
public class BillOfLadingDetailBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(BillOfLadingDetailBean.class);

	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;

	@ManagedProperty(value = "#{carrierAuctionBO}")
	private CarrierAuctionBO carrierAuctionBO;

	@ManagedProperty(value = "#{operationFeeBO}")
	private OperationFeeBO operationFeeBO;

	@ManagedProperty(value = "#{usersAccountBO}")
	private UsersAccountBO usersAccountBO;

	@ManagedProperty(value = "#{paymentDetailBO}")
	private PaymentDetailBO paymentDetailBO;

	@ManagedProperty(value = "#{commentBO}")
	private CommentBO commentBO;

	private BillOfLadingDTO data;
	private CarrierAuction auctionData;
	private CarrierAuctionDTO auctionDataSuccess;
	private List<CarrierAuctionDTO> auctionDataList;
	private Users user;
	private Float auctionPrice;
	private boolean isCarrierAuction;
	private boolean isGoodsOwner;
	private boolean isViewShipment;
	private int carrierAuctionStatus;

	private String contentComment;
	private String contentAnswerComment;
	private List<CommentDTO> comments;

	@PostConstruct
	public void init() {
		try {
			// Authentication
			user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			// Get bill of lading
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String id = params.get("id");
			data = billOfLadingBO.getBillOfLadingDTOById(Integer.parseInt(id));
			// Validate data
			if (data == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
				return;
			}
			// Get comments of bill of lading
			comments = commentBO.getComments(Integer.parseInt(id));

			if (user.getRole() == ConstantUtils.USER_ADMIN) {
				isViewShipment = true;
				auctionDataList = carrierAuctionBO.getCarrierAuctionList(data.getId());
			} else if (user.getRole() == ConstantUtils.USER_GOODS_OWNER) {
				// When GoodsOwner view detail
				if (data.getCreatedUserId() != user.getId()) {
					// This bill of lading is not logged users
					isGoodsOwner = false;
				} else {
					if (data.getStatus() > 1) {
						// This bill of lading is not bidding
						auctionDataSuccess = carrierAuctionBO.getCarrierAuctionSuccess(data.getId());
					}
					// This bill of lading is logged users
					isGoodsOwner = true;
					isViewShipment = true;
				}
			} else if (user.getRole() == ConstantUtils.USER_CARRIER) {
				auctionData = carrierAuctionBO.getCarrierAuction(user.getId(), data.getId());
				if (auctionData != null && (auctionData.getStatus() == ConstantUtils.CARRIER_AUCTION_SUCCESS
						|| auctionData.getStatus() == ConstantUtils.CARRIER_AUCTION_COMPLETION)) {
					isViewShipment = true;
				}
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public BillOfLadingDTO getData() {
		return data;
	}

	public void setData(BillOfLadingDTO data) {
		this.data = data;
	}

	public BillOfLadingBO getBillOfLadingBO() {
		return billOfLadingBO;
	}

	public void setBillOfLadingBO(BillOfLadingBO billOfLadingBO) {
		this.billOfLadingBO = billOfLadingBO;
	}

	public CarrierAuctionBO getCarrierAuctionBO() {
		return carrierAuctionBO;
	}

	public void setCarrierAuctionBO(CarrierAuctionBO carrierAuctionBO) {
		this.carrierAuctionBO = carrierAuctionBO;
	}

	public Float getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(Float auctionPrice) {
		this.auctionPrice = auctionPrice;
	}

	public boolean getIsCarrierAuction() {
		return isCarrierAuction;
	}

	public void setIsCarrierAuction(boolean isCarrierAuction) {
		this.isCarrierAuction = isCarrierAuction;
	}

	public boolean getIsGoodsOwner() {
		return isGoodsOwner;
	}

	public void setIsGoodsOwner(boolean isGoodsOwner) {
		this.isGoodsOwner = isGoodsOwner;
	}

	public CarrierAuction getAuctionData() {
		return auctionData;
	}

	public void setAuctionData(CarrierAuction auctionData) {
		this.auctionData = auctionData;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public CarrierAuctionDTO getAuctionDataSuccess() {
		return auctionDataSuccess;
	}

	public void setAuctionDataSuccess(CarrierAuctionDTO auctionDataSuccess) {
		this.auctionDataSuccess = auctionDataSuccess;
	}

	public List<CarrierAuctionDTO> getAuctionDataList() {
		return auctionDataList;
	}

	public void setAuctionDataList(List<CarrierAuctionDTO> auctionDataList) {
		this.auctionDataList = auctionDataList;
	}

	public OperationFeeBO getOperationFeeBO() {
		return operationFeeBO;
	}

	public void setOperationFeeBO(OperationFeeBO operationFeeBO) {
		this.operationFeeBO = operationFeeBO;
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

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public CommentBO getCommentBO() {
		return commentBO;
	}

	public void setCommentBO(CommentBO commentBO) {
		this.commentBO = commentBO;
	}

	public String getContentComment() {
		return contentComment;
	}

	public boolean getIsViewShipment() {
		return isViewShipment;
	}

	public void setIsViewShipment(boolean isViewShipment) {
		this.isViewShipment = isViewShipment;
	}

	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}

	public String getContentAnswerComment() {
		return contentAnswerComment;
	}

	public void setContentAnswerComment(String contentAnswerComment) {
		this.contentAnswerComment = contentAnswerComment;
	}

	public int getCarrierAuctionStatus() {
		return carrierAuctionStatus;
	}

	public void setCarrierAuctionStatus(int carrierAuctionStatus) {
		this.carrierAuctionStatus = carrierAuctionStatus;
	}

	/**
	 * Carrier make auction
	 * 
	 * @param billOfLadingId
	 */
	public void auction(int billOfLadingId) {
		try {
			// Check user account
			OperationFee fee1 = operationFeeBO.getOperationFeeByCode(ConstantUtils.FEE_CODE_BID_BILLOFLADING);
			OperationFee fee2 = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_CARRIER);
			UsersAccount usersAccount = usersAccountBO.getAccountByUserId(user.getId());
			float amount = (fee2.getPercent() / 100) * auctionPrice;
			if (usersAccount.getBalance() < fee1.getFee() + amount) {
				carrierAuctionStatus = ConstantUtils.ACCOUNT_BALANCE_NOT_ENOUGH;
				RequestContext.getCurrentInstance().execute("PF('auction_message_dlg').show()");
				return;
			}

			CarrierAuction dataInsert = new CarrierAuction();
			// Set CarrierId of userLogin
			dataInsert.setCarrierId(user.getId());
			dataInsert.setBillOfLadingId(billOfLadingId);
			dataInsert.setAuctionPrice(auctionPrice);
			dataInsert.setAuctionDate(new Date());
			dataInsert.setStatus(ConstantUtils.CARRIER_AUCTION_BIDDING);
			boolean result = carrierAuctionBO.addNewCarrierAuction(dataInsert);
			if (result) {
				auctionData = carrierAuctionBO.getCarrierAuction(user.getId(), billOfLadingId);
				// Fee
				usersAccountBO.minusMoneyAccount(user.getId(), fee1.getFee());
				// Add payment detail
				PaymentDetail paymentDetail1 = new PaymentDetail();
				paymentDetail1.setAmounts(fee1.getFee());
				paymentDetail1.setType(ConstantUtils.PAYMENT_MINUS);
				paymentDetail1.setDescription("Phí đấu thầu.");
				paymentDetail1.setUserId(user.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail1);
				// EARNEST_MONEY
				usersAccountBO.minusMoneyAccount(user.getId(), amount);
				// Add payment detail
				PaymentDetail paymentDetail2 = new PaymentDetail();
				paymentDetail2.setAmounts(amount);
				paymentDetail2.setType(ConstantUtils.PAYMENT_MINUS);
				paymentDetail2.setDescription("Tiền đặt cọc đấu thầu.");
				paymentDetail2.setUserId(user.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail2);
			}
			carrierAuctionStatus = ConstantUtils.PROCESS_SUCCESS;
		} catch (Exception e) {
			log.debug(e);
			carrierAuctionStatus = ConstantUtils.PROCESS_FAILURE;
		}
	}

	/**
	 * Goods owner cancel auction
	 */
	public void goodsOwnerCancelAuction() {
		try {
			if (data.getStatus() == ConstantUtils.BILLOFLADING_BIDDING) {
				// Return earnest money
				OperationFee fee = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_GOODSOWNER);
				float amount = (fee.getPercent() / 100) * data.getPrice();
				usersAccountBO.plusMoneyAccount(user.getId(), amount);
				// Add payment detail
				PaymentDetail paymentDetail = new PaymentDetail();
				paymentDetail.setAmounts(amount);
				paymentDetail.setType(ConstantUtils.PAYMENT_PLUS);
				paymentDetail.setDescription("Hủy giao dịch");
				paymentDetail.setUserId(user.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail);
			}
			// Update status
			data.setStatus(ConstantUtils.BILLOFLADING_GOODSOWNER_CANCELED);
			data.setNotification(false);
			BillOfLading updated = data.toBillOfLading();
			billOfLadingBO.updateBillOfLading(updated);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Carrier cancel auction
	 * 
	 * @param auctionId
	 */
	public void carrierCancelAuction() {
		try {
			if (auctionData.getStatus() == ConstantUtils.CARRIER_AUCTION_BIDDING) {
				OperationFee fee = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_GOODSOWNER);
				float amount = (fee.getPercent() / 100) * auctionData.getAuctionPrice();
				usersAccountBO.plusMoneyAccount(user.getId(), amount);
				PaymentDetail paymentDetail = new PaymentDetail();
				paymentDetail.setAmounts(amount);
				paymentDetail.setType(ConstantUtils.PAYMENT_PLUS);
				paymentDetail.setDescription("Hủy đấu thầu trước khi khớp lệnh.");
				paymentDetail.setUserId(user.getId());
				paymentDetailBO.addPaymentDetail(paymentDetail);
				// Update auction data
				auctionData.setStatus(ConstantUtils.CARRIER_AUCTION_CARRIER_CANCELED_BEFORE);
				carrierAuctionBO.updateCarrierAuction(auctionData);
			} else if (auctionData.getStatus() == ConstantUtils.CARRIER_AUCTION_SUCCESS) {
				// Update transactions data
				data.setNotification(false);
				data.setStatus(ConstantUtils.BILLOFLADING_CARRIER_CANCELED);
				BillOfLading updated = data.toBillOfLading();
				billOfLadingBO.updateBillOfLading(updated);
				// Update auction data
				auctionData.setStatus(ConstantUtils.CARRIER_AUCTION_CARRIER_CANCELED);
				carrierAuctionBO.updateCarrierAuction(auctionData);
			}
			auctionData = null; // Update view
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Confirm completed
	 */
	public void confirmCompleted() {
		try {
			if (user.getRole() == ConstantUtils.USER_CARRIER) {
				auctionData.setStatus(ConstantUtils.CARRIER_AUCTION_COMPLETION);
				auctionData.setNotification(false);
				carrierAuctionBO.updateCarrierAuction(auctionData);
			} else if (user.getRole() == ConstantUtils.USER_GOODS_OWNER
					&& auctionDataSuccess.getStatus() == ConstantUtils.CARRIER_AUCTION_COMPLETION) {
				data.setStatus(ConstantUtils.BILLOFLADING_COMPLETION);
				data.setNotification(false);
				billOfLadingBO.updateBillOfLading(data.toBillOfLading());
				// Return earnest money
				OperationFee fee = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_GOODSOWNER);
				float amount = (fee.getPercent() / 100) * data.getPrice();
				usersAccountBO.plusMoneyAccount(data.getCreatedUserId(), amount);
				// Add payment detail for goods owner
				PaymentDetail paymentDetail = new PaymentDetail();
				paymentDetail.setAmounts(amount);
				paymentDetail.setType(ConstantUtils.PAYMENT_PLUS);
				paymentDetail.setDescription("Hoàn thành giao hàng.");
				paymentDetail.setUserId(data.getCreatedUserId());
				paymentDetailBO.addPaymentDetail(paymentDetail);

				OperationFee fee2 = operationFeeBO.getOperationFeeByCode(ConstantUtils.EARNEST_MONEY_OF_CARRIER);
				float amount2 = (fee2.getPercent() / 100) * auctionDataSuccess.getAuctionPrice();
				usersAccountBO.plusMoneyAccount(auctionDataSuccess.getCarrierId(), amount2);
				// Add payment detail for carrier
				PaymentDetail paymentDetail2 = new PaymentDetail();
				paymentDetail2.setAmounts(amount2);
				paymentDetail2.setType(ConstantUtils.PAYMENT_PLUS);
				paymentDetail2.setDescription("Hoàn thành nhận hàng.");
				paymentDetail2.setUserId(auctionDataSuccess.getCarrierId());
				paymentDetailBO.addPaymentDetail(paymentDetail2);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Add new comment
	 */
	public void writeComment() {
		try {
			if (contentComment == null || contentComment.equals(""))
				return;
			Comment dataComment = new Comment();
			dataComment.setCreatedUserId(user.getId());
			dataComment.setBillOfLadingId(data.getId());
			dataComment.setContent(contentComment);
			commentBO.addNewComment(dataComment);
			// Get comments
			comments = commentBO.getComments(data.getId());
			contentComment = null;
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Add new answer comment
	 */
	public void writeAnswerComment(int commentId) {
		try {
			if (contentAnswerComment == null || contentAnswerComment.equals(""))
				return;
			AnswerComment dataAnswerComment = new AnswerComment();
			dataAnswerComment.setCreatedUserId(user.getId());
			dataAnswerComment.setContent(contentAnswerComment);
			dataAnswerComment.setCommentId(commentId);
			commentBO.addNewAnswerComment(dataAnswerComment);
			// Get comments
			comments = commentBO.getComments(data.getId());
			contentAnswerComment = null;
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Update comment
	 */
	public void updateComment() {
		if (data != null) {
			comments = commentBO.getComments(data.getId());
		}
	}
}
