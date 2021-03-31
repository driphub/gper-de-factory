package com.pger.obj;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>Description: </b>
 * <p>
 * //
 * </p>
 *
 * @author song
 * @ClassName ObjectTest
 * @Date 3/31/21 11:03 AM song Exp $$
 * @since V1.0
 */
public class ObjectTest {

    public static void main(String[] args) {
        createObjNum();
    }

    private static void createObjNum() {
        String a = "人";
        String b = "比较";
        String c = "勤";
        String d = "奋";
        String s = a + b + c + d;
    }

    /**
     *
     * 注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2
     *
     *  有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
     *
     * @param nums 二位数组
     * @param x  目标数
     * @return boolean
     */
    private static boolean searchMatrix(int[][] nums, int x) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }

        int rows = nums.length, columns = nums[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >=0) {
            int num = nums[row][column];
            if (num == x) {
                return true;
            } else if (num > x) {
                column --;
            } else {
                row ++;
            }
        }

        return false;
    }

    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */

    private static Set<String> showMap(Map<String, Object> map) {
        int a = 0;
        HashSet<String> strings = new HashSet<>();
        for (String s : map.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);

            Object obj = map.get(s);
            if (obj instanceof String || obj instanceof Number) {
                stringBuilder.append("=").append(obj);
                strings.add(stringBuilder.toString());
            } else if (obj instanceof Object[]) {
                showArray(strings, stringBuilder, (Object[]) obj);
            }

            a++;
        }
        return strings;
    }

    private static void showArray(HashSet<String> strings, StringBuilder stringBuilder, Object[] obj) {
        Object[] objects = obj;
        String str = "";
        for (int i = 0; i < objects.length; i++) {
            str = stringBuilder.toString();
            stringBuilder.append("[").append(i).append("]");
            Object object = objects[i];
            if (object instanceof String || object instanceof Number || object == null) {
                stringBuilder.append("=").append(object);
                strings.add(stringBuilder.toString());
            } else if (object instanceof Map) {
                showMap(strings, stringBuilder, (Map<String, Object>) object);
            } else {
                showArray(strings, stringBuilder, (Object[]) object);
            }
            stringBuilder = new StringBuilder(str);
        }
    }

    private static void showMap(HashSet<String> strings, StringBuilder stringBuilder, Map<String, Object> hashMap) {
        for (String s : hashMap.keySet()) {
            stringBuilder.append(".").append(s);
            Object object = hashMap.get(s);
            if (object instanceof String || object instanceof Number) {
                stringBuilder.append("=").append(object);
                strings.add(stringBuilder.toString());
            } else if (object instanceof Object[]) {
                showArray(strings, stringBuilder, (Object[]) object);
            } else {
                showMap(strings, stringBuilder, (Map<String, Object>) object);
            }
        }
    }


    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     * 例如以下是镜像对称的
     *      1
     *     / \
     *    2   2
     *   / \ / \
     *  3  4 4  3
     *
     * 下面这个则不是镜像对称的
     *      1
     *     / \
     *    2   2
     *     \   \
     *      3   3
     *
     * TreeNode类的定义:
     *
     * @param  // TreeNode 一颗二叉树
     * @return boolean 是否是对称的
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    private static boolean isTreeSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private static boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

}
