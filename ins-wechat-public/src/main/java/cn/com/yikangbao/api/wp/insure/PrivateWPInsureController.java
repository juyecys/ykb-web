package cn.com.yikangbao.api.wp.insure;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.insure.Insure;
import cn.com.yikangbao.service.insure.InsureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/2/28.
 */
@RestController
@RequestMapping(value = { "/ykb/wp/private/insure" }, produces = "application/json")
public class PrivateWPInsureController {
    private static final Logger logger = LoggerFactory.getLogger(PrivateWPInsureController.class);

    @Autowired
    private InsureService insureService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createInsure(@RequestBody Insure insure) throws Exception {
        insureService.createOrUpdate(insure);
        return new ResponseEntity<>(ApiResult.success(insure), HttpStatus.OK);
    }
}
