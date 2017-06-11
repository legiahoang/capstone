package vn.co.cex.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import vn.co.cex.bo.PackagedFormBO;
import vn.co.cex.orm.PackagedForm;

@SuppressWarnings("restriction")
@ManagedBean(name = "packagedFormBean", eager = true)
public class PackagedFormBean extends BaseBean {

	@ManagedProperty(value = "#{packagedFormBO}")
	private PackagedFormBO packagedFormBO;

	private List<PackagedForm> packagedFormList;

	/**
	 * Init data packagedFormList
	 */
	@PostConstruct
	public void init() {
		try {
			packagedFormList = packagedFormBO.getAllPackagedForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PackagedFormBO getPackagedFormBO() {
		return packagedFormBO;
	}

	public void setPackagedFormBO(PackagedFormBO packagedFormBO) {
		this.packagedFormBO = packagedFormBO;
	}

	public List<PackagedForm> getPackagedFormList() {
		return packagedFormList;
	}

	public void setPackagedFormList(List<PackagedForm> packagedFormList) {
		this.packagedFormList = packagedFormList;
	}
}
