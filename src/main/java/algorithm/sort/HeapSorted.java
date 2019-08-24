package algorithm.sort;

/**
 * 堆只是一种概念,具体的存储体是数组,
 * 堆只是提供操作这个数组符合堆的概念的.
 *
 *
 *  i 为当前数组下标
 *  m 为树的 阶
 *
 *  最大堆
 *  a[i] > a[m*i + 1] && a[k] > a[m*i + 2]
 *
 *  最小堆
 *  a[i] < a[m*i + 1] && a[k] < a[m*i + 2]
 *
 *  i为数组下标
 *  通常堆是通过一维数组来实现的。在数组起始位置为0的情形中：
 *      父节点i的左子节点在位置 2i+1;
 *      父节点i的右子节点在位置 2i+2;
 *      子节点i的父节点在位置 floor((i-1)/2);
 *
 * Created by 17020751 on 2018/3/19.
 */
public class HeapSorted extends Sorted{

    Integer[] pq;
    int n;//存储位置,存储于pq[0,n]中, n为下标

    //构建最小堆
    public HeapSorted(int length) {
        this.pq = new Integer[length];
        this.n = length - 1;
    }

    public void exch(int a, int b){
       int temp = pq[a];
       pq[a] = pq[b];
       pq[b] = temp;
    }

    //1,2,3,4,5,6,7,8,9
    //上浮
    public void swim(int i,int endPoint){
        int p = (i-1)/2;//父节点
        if(i>endPoint && !less(pq[p],pq[i])){
            exch(p,i);
            swim(p,endPoint);
        }
    }

    //下沉
    public void sink(int i,int endPoint){
        while (i*2+1 <= endPoint){
            int j = i*2 + 1;//左子节点
            if(j+1 <= endPoint && pq[j] > pq[j+1]){
                j++;
            }
            if(less(pq[i],pq[j])) break;
            exch(i,j);
            i=j;
        }
    }

    //数组最后插入
    public void insert(int val){
        pq[++n] = val;
        swim(n,0);//重构堆
    }

    public int delMax(){
        int max = pq[1];
        //重构堆
        exch(1,n--);
        pq[n + 1] = null;
        sink(1,n);
        return max;
    }

    public void sorted(Integer[] a){
        this.pq = a;
        this.n = a.length - 1;
        //1.构建堆,下沉
//        for (int i = (n-1)/2; i >= 0; i--) {
//            sink(i);
//        }
        //1.构建,上浮
        for (int i = n; i >= n/2; i--) {
            swim(i,0);
        }

         /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for(int i = n; i > 0; i--){
            exch(0, i);
            sink(0,i-1);
        }
    }

    public static void main(String[] args) {
        HeapSorted h = new HeapSorted(10);
        Integer[] array = { 5,18,67,23,13,4,3};
        h.sorted(array);
        h.show(array);
    }

    public void show(Integer [] a){
        String show = "";
        for(int i:a){
            show += i + ",";
        }
        System.out.println(show);
    }
}
