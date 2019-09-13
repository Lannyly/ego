package com.ego.manager.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;

/**
 * @Auther: Lanny
 * @Date: 2019/9/13
 * @Description: com.ego.manager.service
 * @version: 1.0
 */
public interface TbItemService {
    /**
     * 显示商品
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid show(int page,int rows);

    /**
     * 批量修改商品状态
     * @param ids
     * @param status
     * @return
     */
    int update(String ids,byte status);
}
