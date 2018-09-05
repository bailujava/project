package com.baizhi.action;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    public static Logger logger = LoggerFactory.getLogger(MenuController.class);


    @RequestMapping("/all.do")
    public Object queryAll() {

        List<Menu> menus = menuService.queryAll();

        System.out.println(menus.size());
        logger.debug(menus.toString());
        return menus;
    }
}
