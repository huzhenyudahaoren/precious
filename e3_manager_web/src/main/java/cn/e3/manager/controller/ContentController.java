package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.content.service.ContentService;
import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;


@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public DatagridPageBean findAll(Long categoryId,
									@RequestParam(defaultValue=("1"))Integer page,
									@RequestParam(defaultValue="30")Integer rows){
		DatagridPageBean pageBean = contentService.findAll(categoryId, page, rows);
		return pageBean;
	}
	/**
	 * 广告内容的增加
	 * 返回类型:E3mallResult
	 * 传递参数:tbContent
	 * url:/content/save
	 */
	@RequestMapping("/content/save")
	@ResponseBody	
	public E3mallResult save(TbContent content){
		E3mallResult save = contentService.save(content);
		return save;
	}
}
