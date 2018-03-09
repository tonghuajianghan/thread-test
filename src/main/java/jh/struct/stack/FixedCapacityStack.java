package jh.struct.stack;

/**
 * 定容队列,数组实现
 *
 * Created by 17020751 on 2018/3/2.
 */
public class FixedCapacityStack<Item> {

    private Item[] a;//stack entries
    private int n;//stack size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){return n == 0;}

    public void push(Item item){
        if(n == a.length)resize(2*a.length);//调整容器大小
        a[n++] = item;
    }
    public Item pop(){
        Item item = a[n--];
        a[n] = null;
        if(n>0 && n < a.length/4)resize(a.length/2);//调整容器大小
        return item;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
