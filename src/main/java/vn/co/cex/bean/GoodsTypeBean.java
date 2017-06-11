package vn.co.cex.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import vn.co.cex.bo.GoodsTypeBO;
import vn.co.cex.orm.GoodsType;

@ManagedBean(name = "goodsTypeBean", eager = true)
@SuppressWarnings("restriction")
public class GoodsTypeBean extends BaseBean {
	
	@ManagedProperty(value = "#{goodsTypeBO}")
	private GoodsTypeBO goodsTypeBO;
	
	private List<GoodsType> goodsTypeList;
	
	/**
	 * Init data goodsTypeList
	 */
	@PostConstruct
	public void init(){
		try{
			goodsTypeList = goodsTypeBO.getAllGoodsType();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GoodsTypeBO getGoodsTypeBO() {
		return goodsTypeBO;
	}

	public void setGoodsTypeBO(GoodsTypeBO goodsTypeBO) {
		this.goodsTypeBO = goodsTypeBO;
	}

	public List<GoodsType> getGoodsTypeList() {
		return goodsTypeList;
	}

	public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
		this.goodsTypeList = goodsTypeList;
	}
	
}
