package com.pger.de.composite;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 *
 * 树操作工厂
 *
 */
public class OperateElementFactory {

    private OperateElementFactory() {
    }

    public static OperateElementFactory getInstance() {
        return OerateHolder.INSTANCE;
    }

    /**
     * 根据xpath生成树结构
     *
     * @return
     */
    public TreeNodeElement createNodeHandler() {
        SAXReader saxReader = new SAXReader();
        File file = new File(OperateElementFactory.class.getClassLoader().getResource("rootdoc.xml").getFile());
        TreeNodeElement parentNode = null;
        try {
            Document document = saxReader.read(file);
            Element rootElement = document.getRootElement();
            parentNode = new TreeNodeElement(rootElement.getName(), Constants.DEFAULT_LV);
            List<Element> elementsList = rootElement.elements();
            addSubNode(parentNode, elementsList, Constants.DEFAULT_LV + 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parentNode;
    }

    private static class OerateHolder {
        private static final OperateElementFactory INSTANCE = new OperateElementFactory();
    }

    /**
     * 内部常量类
     *
     */
    private static class Constants {
        public static final Integer DEFAULT_LV = 1;
    }

    /**
     * 递归xml元素生成子树
     *
     * @param parentNode
     * @param elementsList
     * @param lv
     */
    private static void addSubNode(TreeNodeElement parentNode, List<Element> elementsList, Integer lv) {
        int size = elementsList.size();
        for (int i = 0; i < size; i++) {
            Element element = elementsList.get(i);
            TreeNodeElement subNodeElement = new TreeNodeElement(element.getName(), lv);

            List<Element> subNodeElemList = element.elements();
            if (subNodeElemList != null && !subNodeElemList.isEmpty()) {
                lv ++;
                addSubNode(subNodeElement, subNodeElemList, lv);
            }
            parentNode.addSubNode(subNodeElement);
        }
    }

}
