package cn.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.content.service.ContentCategoryService;
import cn.e3.mapper.TbContentCategoryMapper;
import cn.e3.pojo.TbContentCategory;
import cn.e3.pojo.TbContentCategoryExample;
import cn.e3.pojo.TbContentCategoryExample.Criteria;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	/**
	 * 回显树状图
	 * 传递参数:long parentId 返回参数:treenode
	 */
	@Override
	public List<TreeNode> findAll(Long parentId) {
		List<TreeNode> treeList = new ArrayList<>();
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		for (TbContentCategory tbContentCategory : list) {
			TreeNode tree = new TreeNode();
			tree.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			tree.setText(tbContentCategory.getName());
			tree.setId(tbContentCategory.getId().intValue());
			treeList.add(tree);
		}

		return treeList;
	}
	
	/**
	 *  增加广告位
	 *  传递参数,String name ,Long parentId
	 * 	返回值,返回 E3mallResult
	 */
	@Override
	public E3mallResult insertCategory(String name, Long parentId) {
		TbContentCategory tbContentCategory = new TbContentCategory();
		Date date = new Date();
		tbContentCategory.setCreated(date);
		tbContentCategory.setUpdated(date);
		tbContentCategory.setName(name);
		tbContentCategory.setParentId(parentId);
		tbContentCategory.setSortOrder(1);
		tbContentCategory.setStatus(1);
		tbContentCategory.setIsParent(false);
		//注意 修改接口方法,返回int id类型 
		contentCategoryMapper.insert(tbContentCategory);
		//is_parent 为0. ,再根据parentId 查询出id为他,判断 设置is_parent
		TbContentCategory parentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
		//如果为0 false,则!false进判断
		if(!parentCategory.getIsParent()){
			parentCategory.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentCategory);
		}
		return E3mallResult.ok(tbContentCategory);
	}

	/**
	 *  删除广告位
	 *  传递参数,Long id
	 *  根据id查询出parentId
	 *  ,再查询哈有没有parentId 是 parentId的
	 *  如果
	 * 	返回值,返回 E3mallResult
	 * 	
	 */
}
