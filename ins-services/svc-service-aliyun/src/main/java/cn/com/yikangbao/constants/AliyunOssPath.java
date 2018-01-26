package cn.com.yikangbao.constants;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统参数常量
 */
public class AliyunOssPath {

	private static Logger log = LoggerFactory.getLogger(AliyunOssPath.class);

	/*
	 * Spring 使用的Profile配置("dev"、"test"、"prod"取值,注意是数组)
	 */
	public static String[] PROFILE;

	/** 临时保存路径 **/
	public static final String TEMP_FILEPATH = "ykb_tmp_dir/";

	/** 推广二维码保存路径 **/
	public static final String CHANNEL_QRCODE_FILEPATH = "ykb_channel_qrcode/";


	public static void setPROFILE(String[] profile) {
		PROFILE = profile;
		log.info("当前系统profile配置为:{}", Arrays.asList(profile));
	}
}
