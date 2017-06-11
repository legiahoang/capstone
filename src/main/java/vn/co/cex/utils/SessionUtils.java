package vn.co.cex.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vn.co.cex.orm.Users;

public class SessionUtils {
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(ConstantUtils.USER_NAME).toString();
	}

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute(ConstantUtils.USER_ID);
		else
			return null;
	}

	public static Users getUser() {
		HttpSession session = getSession();
		if (session != null)
			return (Users) session.getAttribute(ConstantUtils.USER_LOGIN);
		else
			return null;

	}
}
