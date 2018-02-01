package cn.com.yikangbao.untils.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jeysine on 2018/1/24.
 */
public class MapUtils {

    /**
     * map 转Object
     * @param dataMap
     * @param clazz
     * @param firstOneCase
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Object getObject(HashMap<String, Object> dataMap, Class<?> clazz, FirstOneCaseEnum firstOneCase) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = clazz.newInstance();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if(fields != null){
                for (Field field:fields){
                    if (dataMap.get(field.getName()) == null) {
                        continue;
                    }

                    field.setAccessible(true);
                    Method m = obj.getClass().getMethod("set" + toUpperCaseFirstOne(field.getName()), field.getType());

                    Object param ;
                    if (firstOneCase.equals(FirstOneCaseEnum.UPPER)) {
                        param = dataMap.get(toUpperCaseFirstOne(field.getName()));
                    } else {
                        param = dataMap.get(toLowerCaseFirstOne(field.getName()));
                    }

                    switch (field.getType().getCanonicalName()) {
                        case "java.lang.Long":
                            Long longParam = new Long((String)param);
                            m.invoke(obj, longParam);
                            break;
                        case "java.lang.Integer":
                            Integer integerParam = new Integer((String)param);
                            m.invoke(obj, integerParam);
                            break;
                        case "java.lang.Boolean":
                            Boolean boolParam = Boolean.valueOf((String)param);
                            m.invoke(obj, boolParam);
                            break;
                        case "java.util.Date":
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            ParsePosition pos = new ParsePosition(0);
                            Date dateParam = formatter.parse((String)param, pos);
                            m.invoke(obj, dateParam);
                            break;
                        case "java.lang.String":
                            m.invoke(obj, (String)param);
                            break;
                        case "java.util.List":
                            List list =  (List)param;
                            m.invoke(obj, list);
                            break;
                        default:
                            throw new IllegalAccessException("transfer param missing");
                    }
                }
            }
        }
        return obj;
    }

    public static HashMap<String, Object> getMap(Object obj, Class<?> clazz) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if(fields != null){
                for (Field field:fields){
                    field.setAccessible(true);
                    Object param = field.get(obj);
                    if (param == null) {
                        continue;
                    }
                    hashMap.put(field.getName(), param);
                }
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> filterPageForMap(HashMap<String, Object> map) {
        map.remove("page");
        return map;
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    private static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public enum FirstOneCaseEnum {
        UPPER // 类字段首字母大写
        ,LOWER //类字段首字母小写
    }
}
