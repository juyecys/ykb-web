package cn.com.yikangbao.untils.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jeysine on 2018/1/24.
 */
public class MapUtils {
    public static Object getObject(HashMap<String, String> dataMap, Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = clazz.newInstance();

        System.out.println(obj);

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if(fields != null){
                for (Field field:fields){
                    field.setAccessible(true);
                    Method m = obj.getClass().getMethod("set" + toUpperCaseFirstOne(field.getName()), field.getType());
                    switch (field.getType().getCanonicalName()) {
                        case "java.lang.Long":
                            Long longParam = new Long(dataMap.get(toUpperCaseFirstOne(field.getName())));
                            m.invoke(obj, longParam);
                            break;
                        case "java.lang.Integer":
                            Integer integerParam = new Integer(dataMap.get(toUpperCaseFirstOne(field.getName())));
                            m.invoke(obj, integerParam);
                            break;
                        case "java.lang.Boolean":
                            Boolean boolParam = new Boolean(dataMap.get(toUpperCaseFirstOne(field.getName())));
                            m.invoke(obj, boolParam);
                            break;
                        case "java.util.Date":
                            Date dateParam = new Date(dataMap.get(toUpperCaseFirstOne(field.getName())));
                            m.invoke(obj, dateParam);
                            break;
                        case "java.lang.String":
                            m.invoke(obj, dataMap.get(toUpperCaseFirstOne(field.getName())));
                            break;
                        default:
                            throw new IllegalAccessException("transfer param missing");
                    }
                }
            }
        }
        return obj;
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
