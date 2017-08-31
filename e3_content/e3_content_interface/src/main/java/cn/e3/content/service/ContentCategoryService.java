package cn.e3.content.service;

import java.util.List;

import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

public interface ContentCategoryService {
/**
 * 传递参数:long parentId
 * 返回参数:treenode
 */
	public List<TreeNode> findAll(Long parentId);
	
	/**
	 *  增加广告位
	 *  传递参数,String name ,Long parentId
	 * 	返回值,返回 E3mallResult
	 */
	public E3mallResult insertCategory(String name,Long parentId);
}
