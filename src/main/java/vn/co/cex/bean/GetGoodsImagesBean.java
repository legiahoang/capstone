package vn.co.cex.bean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import vn.co.cex.utils.FileUtils;

@ManagedBean(name = "getGoodsImagesBean")
public class GetGoodsImagesBean extends BaseBean {

	public StreamedContent getGoodsImage() throws IOException {

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String imageFile = context.getExternalContext().getRequestParameterMap().get("goodsImageId");
			String filePath = "/home/root/goodsimages/";
			System.out.println("GetGoodsImagesBean.getUserAvar.iamgefile:" + imageFile);
			if (imageFile != null && !imageFile.equals("")) {
				System.out.println("GetGoodsImagesBean.getUserAvar.filepath1:" + filePath);
				filePath += imageFile;				
			} else {
				filePath += "no-goods-image.jpg";
			}
			System.out.println("GetGoodsImagesBean.getUserAvar.filepath2:" + filePath);
			return FileUtils.downloadFileImg(filePath);
		}
	}
}
