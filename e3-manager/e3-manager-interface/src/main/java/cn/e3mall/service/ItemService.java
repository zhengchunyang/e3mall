package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDatagridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	
	public TbItem findItemById(long id);
	
	public EasyUIDatagridResult getItemList(int page, int row);
}
