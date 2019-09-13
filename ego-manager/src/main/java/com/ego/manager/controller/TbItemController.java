package com.ego.manager.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manager.service.TbItemService;
import com.ego.pojo.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Auther: Lanny
 * @Date: 2019/9/13
 * @Description: com.ego.manager.controller
 * @version: 1.0
 */
@Controller
public class TbItemController {

    @Resource
    private TbItemService tbItemServiceImpl;

    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDataGrid show(int page,int rows){
        return tbItemServiceImpl.show(page,rows);
    }

    @RequestMapping("rest/page/item-edit")
    public String  showItemEdit(){
        return "item-edit";
    }
    @RequestMapping("rest/item/delete")
    public EgoResult delete(String ids){
        EgoResult egoResult = new EgoResult();
        int index = tbItemServiceImpl.update(ids,(byte)3);
        if(index==1){
            egoResult.setStatus(200);
        }
        return egoResult;
    }

}
