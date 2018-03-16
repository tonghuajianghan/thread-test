package jh.struct.tree;

/**
 * 自平衡二叉树
 *
 * 平衡因子 = 左子树高度 - 右子树高度
 *
 * 在二分查找树T中，若所有节点的平衡因子的绝对值均不超过 1，则称T为一棵AVL树
 */
public class AVLTree extends BinarySearchTree{
    public AVLTree(int key) {
        super(key);
    }

    public Node reBalance(Node node){
        if(!isBalance(node)){
           node = rotate(node);
        }

        if(node.parent != null){
            return reBalance(node.parent);
        }else {
            return node;
        }
    }

    public boolean isBalance(Node node){
        if(node == null){
            return true;
        }else {
            if (Math.abs(this.maxDepth(node.left) - this.maxDepth(node.right)) <= 1 &&
                    isBalance(node.left) && isBalance(node.right)){
                return true;
            }else {
                return false;
            }
        }
    }

    /**
     *           b
     *         /  \
     *        a    c
     *       / \  / \
     *    t1  t2 t3 t4
     *
     * @param z
     */

    public Node rotate(Node z){
        Node parent = z.parent;

        Node a,b,c;//自左向右,3个节点 a<b<c
        Node t0,t1,t2,t3;//自左向右,4个树 t1<t2<t3<t3;

        //== 4种情况==
        Node l = z.left;Node r = z.right;
        if(maxDepth(l) - maxDepth(r) >= 2){
            Node ll = z.left.left;Node lr = z.left.right;
            c = z;
            t3=z.right;
            if(maxDepth(ll) - maxDepth(lr) >= 1){//l 单旋
                b = l;
                a = ll;
                t0 = ll==null?null:ll.left;
                t1 = ll==null?null:ll.right;
                t2 = l==null?null:l.right;
            }else{//rl 双旋 下层先旋转,上层在旋转
                b = lr;
                a = l;
                t0 = l==null?null:ll;
                t1 = lr==null?null:lr.left;
                t2 = lr==null?null:lr.right;
            }
        }else{
            Node rl = z.right.left;Node rr = z.right.right;
            a = z;
            t0 = z.left;
            if(maxDepth(rl) - maxDepth(rr) <= -1){//r 单旋
                b = r;
                c = rr;
                t1 = r==null?null:rl;
                t2 = rr==null?null:rr.left;
                t3 = rr==null?null:rr.right;
            }else{//lr 双旋
                b = rl;
                c = r;
                t1 = rl==null?null:rl.left;
                t2 = rl==null?null:rl.right;
                t3 = r==null?null:rr;
            }
        }

        // 勾选完全二杈树,可以使用clone,这样就不会影响z的结构
        if(b != null){
            b.left = a;b.right = c;
        }
        if(a != null){
            a.left = t0;a.right=t1;
        }
        if(c != null){
            c.left=t2;c.right=t3;
        }

        if(parent != null){
            if(parent.key > b.key){
                parent.left = b;
            }else {
                parent.right = b;
            }
            b.parent = parent;
        }else {
            b.parent = null;
        }
        return b;
    }

    @Override
    public void put(int key) {
       Node node = search(root,key);
       super.insert(root,key);
       reBalance(node);
    }

    @Override
    public void remove(int key) {
        Node node = search(root,key);
        super.delete(root, key);
        if(node.parent != null){
            reBalance(node.parent);
        }

    }

    public static void main(String[] args) {
        AVLTree b = new AVLTree(36);
        b.put(27);
        b.put(93);
        b.put(95);
        b.put( 91);
        b.put(90);
        b.put(92);
        //b.put(103);
        //b.put(109);
        //b.put(119);

        Node n = b.reBalance(b.root.right.left);
        System.out.println("---");
    }
}
