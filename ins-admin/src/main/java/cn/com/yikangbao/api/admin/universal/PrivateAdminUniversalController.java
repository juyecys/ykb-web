package cn.com.yikangbao.api.admin.universal;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.constants.AliyunOssPath;
import cn.com.yikangbao.exception.aliyun.oss.AliyunContentStorageException;
import cn.com.yikangbao.service.aliyun.oss.AliyunContentStorageService;
import cn.com.yikangbao.untils.common.AliyunContentStorageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = { "/ykb/mg/public/file" }, produces = "application/json")
public class PrivateAdminUniversalController {

    @Autowired
    private AliyunContentStorageService aliyunContentStorageService;

    private Logger logger = LoggerFactory.getLogger(PrivateAdminUniversalController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, AliyunContentStorageException {
        String url = AliyunOssPath.MESSAGE_FILEPATH;
        try {
            InputStream inputStream = file.getInputStream();
            url = url + file.getOriginalFilename() + "_" + System.currentTimeMillis() + ".jpg";
            aliyunContentStorageService.store(url, inputStream, file.getContentType());


        } catch (IOException | AliyunContentStorageException e) {
            logger.error("error: {}", e);
            throw e;
        }
        url = AliyunContentStorageUtils.getFullAccessUrlForKey(url);
        return new ResponseEntity<>(ApiResult.success(url), HttpStatus.OK);
    }
}
