package cn.com.yikangbao.api.admin.insure;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.insure.InsureDTO;
import cn.com.yikangbao.service.insure.InsureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeysine on 2018/3/13.
 */
@RestController
@RequestMapping(value = {"/ykb/mg/private/insure", "/ykb/mg/public/insure"}, produces = "application/json")
public class PrivateAdminInsureController {
    @Autowired
    private InsureService insureService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> getPage(@RequestBody InsureDTO insure) {
        Page<InsureDTO> page = insureService.findByConditionPage(insure);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/source", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getAllSource() {
        List<String> list = insureService.getAllSource();
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
