package vn.co.cex.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import vn.co.cex.bo.GoodsTypeBO;
import vn.co.cex.bo.impl.SpringContext;

public class UpdateReferencePriceProcessor implements Runnable {

	private static final Logger log = LogManager.getLogger(UpdateReferencePriceProcessor.class);
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
				System.out.println(sdf.format(new Date()) + ": Update Referenece Price");
				referencePriceProcess();
				Thread.sleep(60 * 1000 * 60 * 24 * 7);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
	}

	/**
	 * Reference price process
	 */
	public void referencePriceProcess() {
		try {
			GoodsTypeBO goodsTypeBO = (GoodsTypeBO) SpringContext.getApplicationContext().getBean("goodsTypeBO");
			goodsTypeBO.updateReferencePrice();

		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
	}
}
