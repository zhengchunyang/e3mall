package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EasyUIDatagridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public EasyUIDatagridResult getItemList(int page, int row) {
		//1、设置分页
		PageHelper.startPage(page, row);
		//2、执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//3、获取结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();
		//4、返回结果
		EasyUIDatagridResult easyUIDatagridResult = new EasyUIDatagridResult();
		easyUIDatagridResult.setRows(list);
		easyUIDatagridResult.setTotal(total);
		return easyUIDatagridResult;
	}
	
	

}
