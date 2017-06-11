package vn.co.cex.schedule;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class InitScheduler
 */
public class InitScheduler extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1853239765960633884L;
	
	private static final Logger log = LogManager.getLogger(InitScheduler.class);

	public void init() throws ServletException {
		super.init();
		initialize();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void initialize() {
		try {
			// BillOfLading processor
			Thread processor = new Thread(new BillOfLadingProcessor());
			processor.start();
			// SendMail processor
			Thread sendMailProccessor = new Thread(new SendMailProcessor());
			sendMailProccessor.start();
			// Update reference price processor
			Thread updateReferencePriceProcessor = new Thread(new UpdateReferencePriceProcessor());
			updateReferencePriceProcessor.start();
		} catch (Exception e) {
			log.debug(e);
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

	}
}