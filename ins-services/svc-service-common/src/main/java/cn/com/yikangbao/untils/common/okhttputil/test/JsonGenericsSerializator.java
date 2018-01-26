package cn.com.yikangbao.untils.common.okhttputil.test;

import cn.com.yikangbao.untils.common.okhttputil.callback.IGenericsSerializator;
import com.google.gson.Gson;

/**
 * Created by JimGong on 2016/6/23.
 */
public class JsonGenericsSerializator implements IGenericsSerializator {
    Gson mGson = new Gson();
    public <T> T transform(String response, Class<T> classOfT) {
        return mGson.fromJson(response, classOfT);
    }
}
