package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

@Controller
public class ItemController {
	
	//注入service服务对象
	@Autowired
	private ItemService itemService;
	
	/**
	 * 需求:根据id查询商品信息
	 * 请求:/item/{11111}
	 * 参数:Long itemId
	 * 返回值:Tbitem
	 * 方法:findItemByID
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem findItemByID(@PathVariable Long itemId){
		//调用service服务,根据id查询
		TbItem item = itemService.findItemByID(itemId);
			
		return item;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public DatagridPageBean findlist(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		DatagridPageBean pagebean = itemService.findItemList(page, rows);
		return pagebean;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult insert(TbItem item,TbItemDesc desc){
		
		return itemService.insert(item, desc);
	}

}
