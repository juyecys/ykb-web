package cn.com.yikangbao.api.wechatpublic.hospital;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import cn.com.yikangbao.service.hospital.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/wp/public/hospital" }, produces = "application/json")
public class PublicHospitalController {

    private static final Logger logger = LoggerFactory.getLogger(PublicHospitalController.class);

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getHospital(HospitalDTO hospitalDTO) {
        List<HospitalDTO> hospitalList = hospitalService.findByCondition(hospitalDTO);
        logger.info("{}", hospitalList);
        return new ResponseEntity<>(ApiResult.success(hospitalList), HttpStatus.OK);
    }
}
