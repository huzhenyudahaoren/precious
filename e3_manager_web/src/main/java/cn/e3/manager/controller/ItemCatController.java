package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemCatService;
import cn.e3.utils.TreeNode;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<TreeNode> find(@RequestParam(defaultValue="0",value="id")Long parentId){
		List<TreeNode> list = itemCatService.find(parentId);
		return list;
	}
}
