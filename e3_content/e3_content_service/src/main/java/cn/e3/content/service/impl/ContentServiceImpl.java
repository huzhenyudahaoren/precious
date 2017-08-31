package cn.e3.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.content.service.ContentService;
import cn.e3.mapper.TbContentMapper;
import cn.e3.pojo.TbContent;
import cn.e3.pojo.TbContentExample;
import cn.e3.pojo.TbContentExample.Criteria;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;
@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	private TbContentMapper contentMapper;
	/**
	 * 标题内容的查询
	 * 返回类型:DatagridPageBean 
	 * 传递参数:List<Content> rows,long total 
	 * url:
	 */
	@Override
	public DatagridPageBean findAll(Long categoryId,Integer page, Integer row) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, row);
		List<TbContent> list = contentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		DatagridPageBean bean=new DatagridPageBean();
		bean.setRows(list);
		bean.setTotal(pageInfo.getTotal());
		return bean;
	}
	@Override
	/**
	 * 广告内容的增加
	 * 返回类型:E3mallResult
	 * 传递参数:tbContent
	 * url:/content/save
	 */
	public E3mallResult save(TbContent content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		return E3mallResult.ok();
	}

}
