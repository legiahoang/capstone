package vn.co.cex.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.bo.CarrierAuctionBO;
import vn.co.cex.bo.impl.SpringContext;
import vn.co.cex.dto.BillOfLadingNotificationDTO;
import vn.co.cex.dto.CarrierAuctionNotificationDTO;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.CarrierAuction;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.mail.MailerBean;
import vn.co.cex.utils.mail.TNMailMessage;

public class SendMailProcessor implements Runnable {

	private static final Logger log = LogManager.getLogger(SendMailProcessor.class);

	@Autowired
	private SpringContext springContext;

	public SpringContext getSpringContext() {
		return springContext;
	}

	public void setSpringContext(SpringContext springContext) {
		this.springContext = springContext;
	}

	public void run() {
		try {
			while (true) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
				System.out.println(sdf.format(new Date()) + ": SendMail Notification");
				sendMailNotification();
				Thread.sleep(5 * 60 * 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}

	}

	/**
	 * Send mail notification
	 * 
	 * @param user
	 */
	public void sendMailNotification() {
		try {
			BillOfLadingBO billOfLadingBO = (BillOfLadingBO) SpringContext.getApplicationContext()
					.getBean("billOfLadingBO");
			CarrierAuctionBO carrierAuctionBO = (CarrierAuctionBO) SpringContext.getApplicationContext()
					.getBean("carrierAuctionBO");
			// Get information
			List<BillOfLadingNotificationDTO> billOfLadingNotification = billOfLadingBO.getBillOfLadingNotification();
			List<CarrierAuctionNotificationDTO> carrierAuctionNotification = carrierAuctionBO
					.getCarrierAuctionNotification();

			MailerBean mailerBean = (MailerBean) SpringContext.getApplicationContext().getBean("mailerBean");
			// send mail
			for (BillOfLadingNotificationDTO item : billOfLadingNotification) {
				// Update notification flag if carrier auction
				BillOfLading tmpBOL = billOfLadingBO.getBillOfLadingById(item.getBillOfLadingId());
				if (tmpBOL != null) {
					tmpBOL.setNotification(true);
					billOfLadingBO.updateBillOfLading(tmpBOL);
				}
				// Send mail to goods owner
				TNMailMessage mail = new TNMailMessage();
				mail.setFrom("carriertradingcenter@gmail.com");
				mail.setToList(new String[] { item.getEmail() });
				mail.setSubject("[CTC] Vận đơn của bạn thay đổi trạng thái");
				StringBuilder content = new StringBuilder();
				String link = ConstantUtils.HOST_URL + "CEX/faces/xhtml/BillOfLading/BillOfLadingDetail.xhtml?id="
						+ item.getBillOfLadingId();
				content.append("Xin chào " + item.getUsername() + ", <br/>");
				content.append("Vận đơn của bạn đã thay đổi trạng thái, ");
				content.append("xin hãy đăng nhập hệ thống CTC để xem chi tiết.<br/>");
				content.append("Nếu email này là nhầm lẫn hoặc bạn không mong đợi, ");
				content.append("xin hãy bỏ qua email này.<br/>");
				content.append("<h1 style=\"text-align: center;\"><a href=\"" + link
						+ "\">ĐĂNG NHẬP ĐỂ XEM CHI TIẾT</a></h1>");
				mail.setContent(content.toString());
				mailerBean.sendMail(mail);
			}

			for (CarrierAuctionNotificationDTO item : carrierAuctionNotification) {
				CarrierAuction tmpCA = carrierAuctionBO.getCarrierAuction(item.getUserId(), item.getBillOfLadingId());
				// Update notification flag of bill of lading
				if (tmpCA != null) {
					tmpCA.setNotification(true);
					carrierAuctionBO.updateCarrierAuction(tmpCA);
				}
				// Send mail to carrier
				TNMailMessage mail = new TNMailMessage();
				mail.setFrom("carriertradingcenter@gmail.com");
				mail.setToList(new String[] { item.getEmail() });
				mail.setSubject("[CTC] Đơn đấu thầu vận đơn của bạn thay đổi trạng thái");
				StringBuilder content = new StringBuilder();
				String link = ConstantUtils.HOST_URL + "CEX/faces/xhtml/BillOfLading/BillOfLadingDetail.xhtml?id="
						+ item.getBillOfLadingId();
				content.append("Xin chào " + item.getUsername() + ", <br/>");
				content.append("Đơn đấu thầu vận đơn của bạn đã thay đổi trạng thái , ");
				content.append("xin hãy đăng nhập hệ thống CTC để xem chi tiết.<br/>");
				content.append("Nếu email này là nhầm lẫn hoặc bạn không mong đợi, ");
				content.append("xin hãy bỏ qua email này.<br/>");
				content.append("<h1 style=\"text-align: center;\"><a href=\"" + link
						+ "\">ĐĂNG NHẬP ĐỂ XEM CHI TIẾT</a></h1>");
				mail.setContent(content.toString());
				mailerBean.sendMail(mail);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
