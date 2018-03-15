package cn.com.yikangbao.api.admin.province;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.province.Province;
import cn.com.yikangbao.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeysine on 2018/3/14.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/private/province", "/ykb/mg/public/province" }, produces = "application/json")
public class PrivateAdminProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getList(Province province) {
        List<Province> list = provinceService.findByCondition(province);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
