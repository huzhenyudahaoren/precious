package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

public interface ItemService {
	
	/**
	 * 需求:根据id查询商品信息
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	public TbItem findItemByID(Long itemId);
	/**
	 * 需求:分页查询商品列表
	 * 参数:Integer page,Integer rows
	 * 返回值:DatagridPageBean
	 */
	public DatagridPageBean findItemList(Integer page,Integer rows);
	
	//需求:插入数据,两张表的
	//参数:
	public E3mallResult insert(TbItem item,TbItemDesc desc);

}
