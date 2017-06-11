package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.orm.PackagedForm;

public interface PackagedFormBO extends BaseBO {
	public List<PackagedForm> getAllPackagedForm();
}
