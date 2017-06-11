package vn.co.cex.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import vn.co.cex.utils.FileUtils;

@ManagedBean(name = "getUserAvatarBean")
public class GetUserAvatarBean extends BaseBean {

	public StreamedContent getUserAvatar() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String imageFile = context.getExternalContext().getRequestParameterMap().get("userAvatarId");
			String filePath = "/home/root/UserAvatar/";
			System.out.println("GetUserAvatarBean.getUserAvar.iamgefile:" + imageFile);
			if (imageFile != null && !imageFile.equals("")) {
				System.out.println("GetUserAvatarBean.getUserAvar.filepath1:" + filePath);
				filePath += imageFile;
			} else {
				filePath += "avatarDefault.jpg";
			}
			System.out.println("GetUserAvatarBean.getUserAvar.filepath2:" + filePath);
			return FileUtils.downloadFileImg(filePath);
		}
	}
}
