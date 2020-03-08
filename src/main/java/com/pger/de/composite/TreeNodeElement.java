package com.pger.de.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 */
public class TreeNodeElement extends RootNode {

    private List<RootNode> nodeList;
    private Integer lv;

    public TreeNodeElement(String name, Integer lv) {
        super(name);
        this.lv = lv;
        this.nodeList = new ArrayList<RootNode>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (RootNode rootNode : this.nodeList) {
            if (this.lv != null) {
                for (int i = 0; i < this.lv; i++) {
                    System.out.print("   ");
                }

                for (int i = 0; i < this.lv; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }

            rootNode.show();
        }
    }

    public void removeNode(RootNode node) {
        nodeList.remove(node);
    }

    public RootNode getNode(int index) {
        return nodeList.get(index);
    }

    public void addSubNode(RootNode subNode) {
        if (nodeList == null || nodeList.isEmpty()) {
            nodeList = new ArrayList<RootNode>();
        }
        nodeList.add(subNode);
    }

}
