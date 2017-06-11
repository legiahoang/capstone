package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.GoodsTypeBO;
import vn.co.cex.orm.GoodsType;

public class GoodsTypeBOImpl extends BaseBOImpl implements GoodsTypeBO {

	/**
	 * Get all goods type
	 */
	public List<GoodsType> getAllGoodsType() {
		return goodsTypeDAO.getAllGoodsType();
	}

	/**
	 * Get goods type
	 */
	public GoodsType getGoodsType(int id) {
		return goodsTypeDAO.getGoodsType(id);
	}

	/**
	 * Update goods type
	 */
	public boolean updateGoodsType(GoodsType goodsType) {
		return goodsTypeDAO.updateGoodsType(goodsType);
	}

	/**
	 * Update reference price
	 */
	public void updateReferencePrice() {
		goodsTypeDAO.updateReferencePrice();
	}
}
