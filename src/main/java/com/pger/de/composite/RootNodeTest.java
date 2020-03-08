package com.pger.de.composite;

/**
 * 测试类
 */
public class RootNodeTest {
    public static void main(String[] args) {
        System.err.println("=========== 打印结果 ===========");
        TreeNodeElement parentNode = OperateElementFactory.getInstance().createNodeHandler();
        parentNode.show();

        System.err.println("========================");

        // 移除节点：
        RootNode nodeElement = parentNode.getNode(1);
        parentNode.removeNode(nodeElement);
        parentNode.show();
    }
}
