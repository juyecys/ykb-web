package cn.com.yikangbao.api.wp.qianhai;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.utils.partner.PartnerOrderUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by jeysine on 2018/2/28.
 */
@RestController
@RequestMapping(value = { "/ykb/wp/private/qianhai","/ykb/wp/public/qianhai" }, produces = "application/json")
public class PrivateWPQianHaiController {
    private static final Logger logger = LoggerFactory.getLogger(PrivateWPQianHaiController.class);

    @Autowired
    private QianhaiService qianhaiService;

    @RequestMapping(value = "/insure", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> createInsure(@RequestBody QianHaiOrder insure) throws Exception {
        qianhaiService.sendOrder(insure);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getOrderDetails", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> getOrderDetails(@RequestBody QianHaiOrder order) throws Exception {

        qianhaiService.getOrderDetail(order);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
