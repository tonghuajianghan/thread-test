package jh.struct.tree;

/**
 * Created by 17020751 on 2018/3/13.
 */
public class RBTree{

    Node root;

    //节点
    public class Node{
        int key;
        Node left;
        Node right;
        Node parent;//用于删除
        boolean isRed = false;//用于红黑树
    }

    public RBTree(int key) {
        root = new Node();
        root.key = key;
    }

    public Node insert(Node root, int key) {
        Node u = search(root,key);
        if (u.key != key){//没有--添加
            Node n = new Node();
            n.key = key;
            n.isRed = true;//默认插入节点为红节点
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
        return u;
    }

    public void put(int key){
        Node x = insert(root,key);

    }

    public void delete(Node node, int key) {
    }

    public void rotateLeft(Node node){

    }

    public void rotateRight(Node node){

    }

    //由节点逐层向上遍历
    // 操作: 1.改变节点颜色,2.旋转
    public void reBalance(Node x){
        if(x.key == root.key){
            return;
        }
        if(x.parent.isRed == true){//只有父节点为红色的需要旋转
            if(x.parent.parent.left== x.parent){//x在左节点下插入


            }else {

            }
        }



    }

    //  返回查找到的节点,  或没有找到节点返回找寻过程中最后一个节点
    public Node search(Node root, int key){
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
}
