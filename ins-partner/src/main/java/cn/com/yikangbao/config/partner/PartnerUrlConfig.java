package cn.com.yikangbao.config.partner;

public class PartnerUrlConfig {
    /**
     * 前海域名
     */
    private static String qianhaiServerUrl;

    /**
     * 前海查询订单状态接口
     */
    private static String qianhaiOrderUrl;

    public static String getQianhaiServerUrl() {
        return qianhaiServerUrl;
    }

    public static void setQianhaiServerUrl(String qianhaiServerUrl) {
        PartnerUrlConfig.qianhaiServerUrl = qianhaiServerUrl;
    }

    public static String getQianhaiOrderUrl() {
        return qianhaiOrderUrl;
    }

    public static void setQianhaiOrderUrl(String qianhaiOrderUrl) {
        PartnerUrlConfig.qianhaiOrderUrl = qianhaiOrderUrl;
    }

    public static String getFullUrl(String serverUrl, String interfaceUrl) {
        return serverUrl + interfaceUrl;
    }
}
