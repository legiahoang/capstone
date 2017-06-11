package vn.co.cex.bean.operationfee;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.GoodsTypeBO;
import vn.co.cex.orm.GoodsType;

@ManagedBean(name = "referencePriceBean", eager = true)
public class ReferencePriceBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(ReferencePriceBean.class);

	@ManagedProperty(value = "#{goodsTypeBO}")
	private GoodsTypeBO goodsTypeBO;

	private List<GoodsType> goodsTypeList;

	public GoodsTypeBO getGoodsTypeBO() {
		return goodsTypeBO;
	}

	public List<GoodsType> getGoodsTypeList() {
		return goodsTypeList;
	}

	public void setGoodsTypeBO(GoodsTypeBO goodsTypeBO) {
		this.goodsTypeBO = goodsTypeBO;
	}

	public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
		this.goodsTypeList = goodsTypeList;
	}

	@PostConstruct
	public void init() {
		try {
			goodsTypeList = goodsTypeBO.getAllGoodsType();
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
