package com.ego.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.manager.service.TbItemService;
import com.ego.pojo.TbItem;

/**
 * @Auther: Lanny
 * @Date: 2019/9/13
 * @Description: com.ego.manager.service.impl
 * @version: 1.0
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Reference
    private TbItemDubboService tbItemDubboServiceImpl;

    @Override
    public EasyUIDataGrid show(int page, int rows) {
        return tbItemDubboServiceImpl.show(page,rows);
    }

    @Override
    public int update(String ids, byte status) {
        int index = 0;
        TbItem tbItem = new TbItem();
        String[] idsStr = ids.split(",");
        for (String id:idsStr){
            tbItem.setId(Long.parseLong(id));
            tbItem.setStatus(status);
            index += tbItemDubboServiceImpl.updItemStatus(tbItem);
        }
        if (index==idsStr.length){
            return 1;
        }
        return 0;
    }
}
