package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: Lanny
 * @Date: 2019/9/13
 * @Description: com.ego.dubbo.service.impl
 * @version: 1.0
 */
public class TbItemDubboServiceImpl implements TbItemDubboService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGrid show(int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询全部
        List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());

        //分页代码
        //设置分页条件

        PageInfo<TbItem> pi =new PageInfo<>(list);
        //放入到实体类
        EasyUIDataGrid dataGrid = new EasyUIDataGrid();
        dataGrid.setRows(pi.getList());
        dataGrid.setTotal(pi.getTotal());
        return dataGrid;
    }

    @Override
    public int updItemStatus(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }
}
