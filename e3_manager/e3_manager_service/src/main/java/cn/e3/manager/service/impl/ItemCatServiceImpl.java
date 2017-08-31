package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.TreeNode;

public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<TreeNode> find(Long parentId) {
	//创建集合用于封装数据
		List<TreeNode>treeList=new ArrayList<>();
		//new一个example
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		//设置参数
		criteria.andParentIdEqualTo(parentId);
		//查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
				TreeNode tree=new TreeNode();
				tree.setId(tbItemCat.getId().intValue());
				tree.setText(tbItemCat.getName());
				tree.setState(tbItemCat.getIsParent()?"closed":"open");
				treeList.add(tree);
		}
		return treeList;
	}

}
