package cn.e3.content.service;

import java.util.List;

import cn.e3.pojo.TbContent;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

public interface ContentService {
/**
 * 广告内容的查询
 * 返回类型:DatagridPageBean 
 * 传递参数:Integer page,Integer rows 当前页与一页总条数
 *  
 * url:
 */
	public DatagridPageBean findAll(Long categoryId,Integer page,Integer rows);
	
	/**
	 * 广告内容的增加
	 * 返回类型:E3mallResult
	 * 传递参数:tbContent
	 * url:/content/save
	 */
	public E3mallResult save(TbContent content);
}
