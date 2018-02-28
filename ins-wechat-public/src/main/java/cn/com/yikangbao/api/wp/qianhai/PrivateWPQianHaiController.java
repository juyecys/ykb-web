package cn.com.yikangbao.api.wp.qianhai;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.qianhai.CommonQianHai;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
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
@RequestMapping(value = { "/ykb/wp/private/qianhai" }, produces = "application/json")
public class PrivateWPQianHaiController {
    private static final Logger logger = LoggerFactory.getLogger(PrivateWPQianHaiController.class);

    @Autowired
    private QianhaiService qianhaiService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createInsure(@RequestBody QianHaiOrder insure) throws Exception {
        qianhaiService.sendOrder(insure);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> getOrderDetails(@RequestBody QianHaiOrder insure) throws Exception {
        qianhaiService.sendOrder(insure);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
