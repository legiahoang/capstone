package vn.co.cex.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseBean {

	public BaseBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return <code>HttpServletRequest</code>
	 */
	public HttpServletRequest getHTTPRequest() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return request;
	}

	/**
	 * 
	 * @return <code>HttpServletResponse</code>
	 */
	public HttpServletResponse getHTTPResponse() {
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		return response;
	}
}
