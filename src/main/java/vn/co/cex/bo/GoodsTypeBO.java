package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.orm.GoodsType;

public interface GoodsTypeBO extends BaseBO {

	/**
	 * Get all goods type
	 * 
	 * @return
	 */
	public List<GoodsType> getAllGoodsType();

	/**
	 * Get goods type by id
	 * 
	 * @param id
	 * @return
	 */
	public GoodsType getGoodsType(int id);

	/**
	 * Update goods type
	 * 
	 * @param goodsType
	 * @return
	 */
	public boolean updateGoodsType(GoodsType goodsType);
	
	/**
	 * Update reference price
	 */
	public void updateReferencePrice();
}
