/**
 * 
 */
package vn.co.cex.utils.mail;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author
 *
 */
public class MailerBean {
	private static final Logger log = LogManager.getLogger(MailerBean.class);
	private static final String THIS = "MailerBean";
	/**
	 * 
	 */
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage notificationMessage;
	
	
	/**
	 * @return the notificationMessage
	 */
	public SimpleMailMessage getNotificationMessage() {
		return notificationMessage;
	}

	/**
	 * @param notificationMessage the notificationMessage to set
	 */
	public void setNotificationMessage(SimpleMailMessage notificationMessage) {
		this.notificationMessage = notificationMessage;
	}	

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public MailerBean() {
	}
	public void sendMail(TNMailMessage mail) {		  

	   try{
			MimeMessage message = mailSender.createMimeMessage();
			log.debug("Create Mine Message");
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			log.debug("After creating Mine Message");
	        if (mail.getFromPersonal() != null) {
	        	helper.setFrom(mail.getFrom(), mail.getFromPersonal());
	        } else {
	        	helper.setFrom(mail.getFrom());
	        }
	        log.debug("fromPersonal={}", mail.getFromPersonal());
	        // to list
	        if (mail.getToList() != null && mail.getToList().length > 0) {       
	            helper.setTo(mail.getToList());
	            log.debug("toList={}", mail.getToList().length);
	        }
	        
	        // cc list
	        if (mail.getCcList() != null && mail.getCcList().length > 0) {
	            helper.setCc(mail.getCcList());
	            log.debug("ccList={}", mail.getCcList().length);
	        }
	
	        // bcc list
	        if (mail.getBccList() != null && mail.getBccList().length > 0) {
	            helper.setBcc(mail.getBccList());
	            log.debug("bccList={}", mail.getBccList().length);
	        }
	
	        // set mail subject
	        helper.setSubject (mail.getSubject());
	
	        // create and fill the first message part
	        if (mail.getSignature() != null) {
	        	log.debug("hahaha {}", mail.getContent());
	        	mail.setContent(mail.getContent() + "\n\n" + mail.getSignature());
	        }
	        
	        helper.setText(mail.getContent(), mail.getContent());
	        if (mail.getAttachedFiles() != null) {
	            // set attach files to the message       
	        	log.debug("Start attaching file to message");
	            Set<String> keys = mail.getAttachedFiles().keySet();
	            for (String attachmentName : keys) {
	        		FileSystemResource file = new FileSystemResource(
	        				mail.getAttachedFiles().get (attachmentName));
	        		helper.addAttachment(file.getFilename(), file);
	            }
	            log.debug("attachedFiles={}", mail.getAttachedFiles().size());
	        }
	        // set the Date: header
	        helper.setSentDate (new Date ());
	     	mailSender.send(message);
	     	log.debug("Sent message successfully");
	     }catch (MessagingException e) {
	    	 log.error("", e);
	    	 throw new MailParseException(e);
	     } catch(Exception ex) {
	    	 log.error("", ex);
	    	 throw new RuntimeException(ex);
         }
	}
	public void autoMail(String from, String to,
			Object[] input, String folder, String key,
			Locale locale,
			HashMap<String, String> attachments) throws Exception {
		final String THIS = "MailerBean.autoMail()";
		try {
			TNMailMessage mail = new TNMailMessage();
			String[] toList = new String[] {to};
			mail.setToList(toList);
			mail.setFrom(from);
			mail.setSubject("subject");
			mail.setSignature("");
			String mainContent = MessageFormat.format(mail.getContent(), input);
			mail.setContent(mainContent);
			mail.setContentType("text/html; charset=utf-8");
			if (attachments != null) {
				mail.setAttachedFiles(attachments);
			}
			sendMail(mail);
		} catch (Exception ex) {
			throw ex;
		} catch (Throwable t) {
			throw new Exception(t);
		}	
	}
}
