package cn.com.yikangbao.api.admin.menu;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.menu.Menu;
import cn.com.yikangbao.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/3/5.
 */
@RestController
@RequestMapping(value = "/ykb/mg/private/menu", produces = "application/json")
public class PrivateAdminMenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> addMenu(@RequestBody Menu menu) throws Exception {
        menu = menuService.createOrUpdate(menu);
        return new ResponseEntity<>(ApiResult.success(menu), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> findPage(Menu menu) throws Exception {
        Page<Menu> page = menuService.findByConditionPage(menu);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }
}
