/**
 * 
 */
package vn.co.cex.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.StreamedContent;

/**
 * @author
 * 
 */
@ManagedBean(name = "getImageBean", eager = true)
@SessionScoped
public class GetImageBean extends BaseBean {
	/**
	 * 
	 */
	public static String IMAGE_PATH_KEY = "ImagePath";
	public static String IMAGE_PATH_KEY2 = "ImagePath2";
	private final String DEFAULT_AVATAR = "../../resources/images/profile_default2.jpeg";
	private final String DEFAULT_LOGO = "../../resources/images/logo_default.png";
	private static final Logger log = LogManager.getLogger(GetImageBean.class);
	private StreamedContent avatar;
	private StreamedContent avatar2;

	public StreamedContent getImageFile() {
		try {
			String pathFromDB = (String) getHTTPRequest().getSession().getAttribute(IMAGE_PATH_KEY);
			avatar = vn.co.cex.utils.FileUtils.downloadFileImg(pathFromDB);
			return avatar;
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	public StreamedContent getImageFile2() {
		try {
			String pathFromDB = (String) getHTTPRequest().getSession().getAttribute(IMAGE_PATH_KEY2);
			avatar2 = vn.co.cex.utils.FileUtils.downloadFileImg(pathFromDB);
			return avatar2;
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	public String getDEFAULT_AVATAR() {
		return DEFAULT_AVATAR;
	}

	public String getDEFAULT_LOGO() {
		return DEFAULT_LOGO;
	}

}
