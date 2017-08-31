package cn.e3.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;
@Service
public class ItemServiceImpl implements ItemService {
	
	//注入商品Mapper接口代理对象
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;

	/**
	 * 需求:根据id查询商品信息
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	public TbItem findItemByID(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	/**
	 * 需求:分页查询商品列表
	 * 参数:Integer page,Integer rows
	 * 返回值:DatagridPageBean
	 * 业务:
	 * 1,分页查询商品列表
	 * 2,使用pagehelper分页查询进行分页查询
	 */
	public DatagridPageBean findItemList(Integer page, Integer rows) {
		//创建example对象
		TbItemExample example = new TbItemExample();
		//在执行之前,设置分页查询
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建分页插件提供PageInfo包装类对象,获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//把分页数据封装分页包装类对象DatagridPageBean
		DatagridPageBean pageBean = new DatagridPageBean();
		//设置总记录数
		pageBean.setTotal(pageInfo.getTotal());
		//设置分页列表数据
		pageBean.setRows(list);
		
		
		return pageBean;
	}

	@Override
	public E3mallResult insert(TbItem item, TbItemDesc desc) {
		//需要给item设置id, 商品添加时间
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态
		item.setStatus((byte)1);
		//商品增加时间
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		desc.setItemId(itemId);
		desc.setCreated(date);
		desc.setUpdated(date);
		itemDescMapper.insert(desc);
		return E3mallResult.ok();
	}

}
