package vn.co.cex.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.bo.BaseBO;
import vn.co.cex.dao.BillOfLadingDAO;
import vn.co.cex.dao.CarrierAuctionDAO;
import vn.co.cex.dao.CommentDAO;
import vn.co.cex.dao.CompanyDAO;
import vn.co.cex.dao.DistrictDAO;
import vn.co.cex.dao.GoodsTypeDAO;
import vn.co.cex.dao.OperationFeeDAO;
import vn.co.cex.dao.PackagedFormDAO;
import vn.co.cex.dao.PaymentDetailDAO;
import vn.co.cex.dao.ProvinceDAO;
import vn.co.cex.dao.ReportDAO;
import vn.co.cex.dao.UsersAccountDAO;
import vn.co.cex.dao.UsersDAO;
import vn.co.cex.utils.mail.MailerBean;

/**
 * @author QuyetVu
 *
 */
@Transactional
public class BaseBOImpl implements BaseBO {

	@Autowired
	protected MailerBean mailerBean;

	@Autowired
	protected BillOfLadingDAO billOfLadingDAO;

	@Autowired
	protected GoodsTypeDAO goodsTypeDAO;

	@Autowired
	protected PackagedFormDAO packagedFormDAO;

	@Autowired
	protected ProvinceDAO provinceDAO;

	@Autowired
	protected DistrictDAO districtDAO;

	@Autowired
	protected OperationFeeDAO operationFeeDAO;

	@Autowired
	protected CarrierAuctionDAO carrierAuctionDAO;

	@Autowired
	protected ReportDAO reportDAO;

	@Autowired
	protected UsersDAO usersDAO;

	@Autowired
	protected CommentDAO commentDAO;

	@Autowired
	protected UsersAccountDAO usersAccountDAO;
	
	@Autowired
	protected PaymentDetailDAO paymentDetailDAO;

	@Autowired
	protected CompanyDAO companyDAO;

	/**
	 * 
	 * @return
	 */
	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	/**
	 * 
	 * @param companyDAO
	 */
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	/**
	 * @return the mailerBean
	 */
	public MailerBean getMailerBean() {
		return mailerBean;
	}

	/**
	 * @param mailerBean
	 *            the mailerBean to set
	 */
	public void setMailerBean(MailerBean mailerBean) {
		this.mailerBean = mailerBean;
	}

	/**
	 * @return
	 */
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	/**
	 * @param usersDAO
	 */
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	/**
	 * @return the reportDAO
	 */
	public ReportDAO getReportDAO() {
		return reportDAO;
	}

	/**
	 * @param reportDAO
	 *            the reportDAO to set
	 */
	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	public BillOfLadingDAO getBillOfLadingDAO() {
		return billOfLadingDAO;
	}

	public void setBillOfLadingDAO(BillOfLadingDAO billOfLadingDAO) {
		this.billOfLadingDAO = billOfLadingDAO;
	}

	public GoodsTypeDAO getGoodsTypeDAO() {
		return goodsTypeDAO;
	}

	/**
	 * @param goodsTypeDAO
	 */
	public void setGoodsTypeDAO(GoodsTypeDAO goodsTypeDAO) {
		this.goodsTypeDAO = goodsTypeDAO;
	}

	/**
	 * @return
	 */
	public PackagedFormDAO getPackagedFormDAO() {
		return packagedFormDAO;
	}

	/**
	 * @param packagedFormDAO
	 */
	public void setPackagedFormDAO(PackagedFormDAO packagedFormDAO) {
		this.packagedFormDAO = packagedFormDAO;
	}

	/**
	 * @return
	 */
	public ProvinceDAO getProvinceDAO() {
		return provinceDAO;
	}

	/**
	 * @param provinceDAO
	 */
	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	/**
	 * @return
	 */
	public DistrictDAO getDistrictDAO() {
		return districtDAO;
	}

	/**
	 * @param districtDAO
	 */
	public void setDistrictDAO(DistrictDAO districtDAO) {
		this.districtDAO = districtDAO;
	}

	/**
	 * @return
	 */
	public OperationFeeDAO getOperationFeeDAO() {
		return operationFeeDAO;
	}

	/**
	 * @param operationFeeDAO
	 */
	public void setOperationFeeDAO(OperationFeeDAO operationFeeDAO) {
		this.operationFeeDAO = operationFeeDAO;
	}

	public CarrierAuctionDAO getCarrierAuctionDAO() {
		return carrierAuctionDAO;
	}

	public void setCarrierAuctionDAO(CarrierAuctionDAO carrierAuctionDAO) {
		this.carrierAuctionDAO = carrierAuctionDAO;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public UsersAccountDAO getUsersAccountDAO() {
		return usersAccountDAO;
	}

	public void setUsersAccountDAO(UsersAccountDAO usersAccountDAO) {
		this.usersAccountDAO = usersAccountDAO;
	}
	
	public PaymentDetailDAO getPaymentDetailDAO() {
		return paymentDetailDAO;
	}

	public void setPaymentDetailDAO(PaymentDetailDAO paymentDetailDAO) {
		this.paymentDetailDAO = paymentDetailDAO;
	}

	public BaseBOImpl() {
		// TODO Auto-generated constructor stub
	}
}
