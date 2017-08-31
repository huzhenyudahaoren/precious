package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.content.service.ContentCategoryService;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	
	//回显树状图
@RequestMapping("/content/category/list")
@ResponseBody
public List<TreeNode> findAll(@RequestParam(defaultValue="0",value="id") Long parentId){
	List<TreeNode> list = contentCategoryService.findAll(parentId);
	return list;
}
	//增加广告位置
@RequestMapping("/content/category/create")
@ResponseBody
public E3mallResult addCategory(String name,Long parentId){
	E3mallResult result = contentCategoryService.insertCategory(name, parentId);
	return result;
}
}
