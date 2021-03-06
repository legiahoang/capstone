package vn.co.cex.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import vn.co.cex.utils.FileUtils;

@ManagedBean(name = "getIdentityCardImageBean")
public class GetIdentityCardImageBean extends BaseBean {

	public StreamedContent getIdentityCardImage() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String imageFile = context.getExternalContext().getRequestParameterMap().get("IdentityCardImageId");
			String filePath = "/home/root/IdentityCardImage/";
			if (imageFile != null && !imageFile.equals("")) {
				filePath += imageFile;
			} else {
				filePath += "1490276934729_download.PNG";
			}
			return FileUtils.downloadFileImg(filePath);
		}
	}
}
