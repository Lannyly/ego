package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;

import java.util.List;

/**
 * @Auther: Lanny
 * @Date: 2019/9/13
 * @Description: com.ego.dubbo.service
 * @version: 1.0
 */
public interface TbItemDubboService {
    /**
     * 商品分页查询
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid show(int page,int rows);

    /**
     * 修改商品状态
     * @param tbItem
     * @return
     */
    int updItemStatus(TbItem tbItem);

}
