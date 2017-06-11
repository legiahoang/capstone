/**
 * 
 */
package vn.co.cex.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.bo.impl.SpringContext;

/**
 * @author DUONGLV
 *
 */
public class BillOfLadingProcessor implements Runnable {

	private static final Logger log = LogManager.getLogger(BillOfLadingProcessor.class);
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
				System.out.println(sdf.format(new Date()) + ": Khop lenh dau gia tu dong");
				billOfLadingProcess();
				Thread.sleep(60 * 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
	}

	/**
	 * Bill of lading process
	 */
	public void billOfLadingProcess() {
		try {
			BillOfLadingBO billOfLadingBO = (BillOfLadingBO) SpringContext.getApplicationContext()
					.getBean("billOfLadingBO");
			billOfLadingBO.billOfLadingProcess();
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
