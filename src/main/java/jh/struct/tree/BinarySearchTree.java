package jh.struct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单实现 二杈查找树
 *
 * Created by 17020751 on 2018/3/9.
 */
public class BinarySearchTree extends Tree{

    Node root;

    //节点
    public class Node{
        int key;
        Node left;
        Node right;
        Node parent;//用于删除
        boolean isRed = false;//用于红黑树
    }

    public BinarySearchTree(int key) {
        root = new Node();
        root.key = key;
    }

    public Node get(int key){
        Node n = search(root,key);
        if(n == null || n.key == 0 || n.key != key){
            return null;
        }else {
            return n;
        }
    }

    //  返回查找到的节点,  或没有找到节点返回找寻过程中最后一个节点
    public Node search(Node root,int key){
        Node u = root;
        if(root.key == key){//查找到--返回
            return u;
        }else{//未查到--子树查找
            if(root.key > key){
                if(root.left == null){//比子树最小节点小
                    return u;
                }
                u = u.left;
            }else if(root.key < key) {
                if(root.right == null){//比子树最大节点大
                    return u;
                }
                u = u.right;
            }
            return search(u,key);
        }
    }

    public void put(int key){
        insert(root,key);
    }

    public void insert(Node root, int key){
        Node u = search(root,key);//此时u已经是root子树中-查找线路-最高节点
        if (u.key != key){//没有--添加
            Node n = new Node();
            n.parent = u;
            n.key = key;
            if(key < u.key){
                u.left = n;
            }else{
                u.right = n;
            }
        }else{//已有覆盖
            u.key = key;
        }
    }

    public Node findMax(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public Node findMin(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public void remove(int key){
        delete(root,key);
    }

    public void delete(Node node,int key){
        Node u = search(node,key);
        Node p = u.parent;
        if (u.key != key){//没有 不做处理
            return;
        }else{//已有--remove
            if(u.left == null && u.right == null){//叶子节点,或左子树为空,右子树为空
               if(u.key > p.key){
                   p.right = null;
               }else {
                   p.left = null;
               }
            }else if(u.left == null){
                if(u.key > p.key){
                    p.right = u.right;
                }else {
                    p.left = u.left;
                }
            }else if (u.right == null){
                if(u.key > p.key){
                    p.right = u.left;
                }else {
                    p.left = u.left;
                }
            }
            else {//有左右子树,有两种方式: 方式1,左端节点最大值替换,方式2:右端节点最小值替换
               Node leftMax = findMax(u.left);
               u.key = leftMax.key;
               delete(leftMax,leftMax.key);
            }
        }
    }

    // 递归中序遍历
    public void inOrder(Node current,List list) {
        if (current != null) {
            inOrder(current.left,list);
            list.add(current.key);
            System.out.print(current.key + ",");
            inOrder(current.right,list);
        }
    }
    // 递归前序遍历
    public void preOrder(Node current,List list) {
        if (current != null) {
            list.add(current.key);
            System.out.print(current.key + ",");
            preOrder(current.left,list);
            preOrder(current.right,list);
        }
    }
    // 递归后序遍历
    public void postOrder(Node current,List list) {
        if (current != null) {
            postOrder(current.left,list);
            postOrder(current.right,list);
            list.add(current.key);
            System.out.print(current.key + ",");
        }
    }

    public int maxDepth(Node node) {
        if(null == node){
           return 0;
        }else{

           /* compute the depth of each subtree */
           int leftDepth = maxDepth(node.left);
           int reghtDepth = maxDepth(node.right);
           if(leftDepth>reghtDepth){
               return leftDepth + 1;
           }else {
               return  reghtDepth + 1;
           }
        }
    }

    public static void main(String[] args) {

        BinarySearchTree b = new BinarySearchTree(36);
        b.put(27);
        b.put(93);
        b.put(6);
        b.put(58);
        b.put(65);
        b.put(63);
        b.put(67);
        b.put(95);
        b.put(94);
        b.put(46);
        b.put(37);
        b.put(93);
        b.put(50);
        System.out.println("----");
        b.remove(58);
        System.out.println("----");
        List list = new ArrayList();
        b.inOrder(b.root, list);
        System.out.println();
        b.preOrder(b.root, list);
        System.out.println();
        b.postOrder(b.root, list);
        System.out.println("\n" + b.maxDepth(b.root));

    }
}


