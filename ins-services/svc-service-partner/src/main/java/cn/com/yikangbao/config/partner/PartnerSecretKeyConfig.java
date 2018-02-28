package cn.com.yikangbao.config.partner;

public class PartnerSecretKeyConfig {

    /**
     * 给前海的SecretKey
     */
    private static String qianhaiSecretKey;

    /**
     * 前海给的secretKey
     */
    private static String qianhaiSecretKeyFor;

    public static String getQianhaiSecretKey() {
        return qianhaiSecretKey;
    }

    public static void setQianhaiSecretKey(String qianhaiSecretKey) {
        PartnerSecretKeyConfig.qianhaiSecretKey = qianhaiSecretKey;
    }

    public static String getQianhaiSecretKeyFor() {
        return qianhaiSecretKeyFor;
    }

    public static void setQianhaiSecretKeyFor(String qianhaiSecretKeyFor) {
        PartnerSecretKeyConfig.qianhaiSecretKeyFor = qianhaiSecretKeyFor;
    }
}
