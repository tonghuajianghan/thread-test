package jh.struct.tree;

/**
 * 简单实现int类型的b-tree实现
 * Created by 17020751 on 2018/3/8.
 */
public class JHBTree {
    Node v;//根节点
    int h;//树高
    int m;//树阶

    /**
     *  查找
     * @param v 根节点
     * @param key 关键码
     * @return
     */
    public Integer find(Node v,int key){
        //若v是叶子节点则返回null
        if(v.appoints.length <= 0){
            return null;
        }
        for (int i = 0; i < m-1; i++) {
            if(v.keys[i] == key){
                return i;
            }else if(v.keys[i] < key && key < v.keys[i + 1]){//下层查找
                find(v.appoints[i+1],key);
            }else if(key < v.keys[0]){
                find(v.appoints[0],key);
            }
        }
        return null;
    }
}

class Node{
    int n;
    int keys[];//关键码,升序结构
    Node appoints[];//引用

    public Node(int m) {
        this.keys = new int[m-1];
        this.appoints = new Node[m];
    }
}