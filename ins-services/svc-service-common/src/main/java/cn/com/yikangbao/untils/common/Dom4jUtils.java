package cn.com.yikangbao.untils.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jeysine on 2018/1/24.
 */
public class Dom4jUtils {


    public static HashMap<String, String> readXml(InputStream inputStream) throws DocumentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        Element node = document.getRootElement();

        return listNodes(node);
    }

    /**
     * 遍历节点
     * @param node
     */
    private static HashMap<String, String> listNodes(Element node) {
        HashMap<String, String> dataMap = new HashMap<>();
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            dataMap.put(e.getName(), e.getText());
        }
        return dataMap;
    }

}
