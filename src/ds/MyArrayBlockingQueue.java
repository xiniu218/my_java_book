package ds;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 阻塞队列
public class MyArrayBlockingQueue<E> {
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private  int takeIndex;
    private  int putIndex;
    private int count;
    private Object[] items;


    public MyArrayBlockingQueue(int size) {
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        takeIndex = 0;
        putIndex =0;
      count = 0;
      if (size<=0){
          throw new RuntimeException("size can not be empty!");
      }
       items=(E[])new Object[size];
    }
    public void put(E x){
        lock.lock();
        try{
            while (count==items.length){
                notFull.await();
                enqueue(x);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void enqueue(E x){
        this.items[putIndex]=x;
        if (++putIndex==items.length){
            putIndex=0;
        }
        count++;
        notEmpty.signal();
    }
    private boolean offer(E e){
        final ReentrantLock lock=this.lock;
        lock.lock();
        try{
            if (count==items.length){
                return false;
            }
            else {
                enqueue(e);
                return true;
            }
        }finally {
            lock.unlock();
        }
    }
    public E take() throws InterruptedException {
        lock.lock();
        try{
            while(count==0){
                notEmpty.await();
            }
            return dequeue();
        }finally {
            lock.unlock();
        }
    }
    private E dequeue(){
        final Object[] items=this.items;
        @SuppressWarnings("unchecked")
                E x=(E)items[takeIndex];
        items[takeIndex]=null;
        if(++takeIndex==items.length){
            takeIndex=0;
        }
        count--;
        notFull.signal();
        return x;
    }

    @Override
    public String toString() {
StringBuilder sb=new StringBuilder();
sb.append("[");
lock.lock();
try{
    if (count==0){
        sb.append("]");
    }else {
        int cur=0;
        while (cur!=count){
            sb.append(items[(cur+takeIndex)%items.length].toString()+",");
            cur+=1;
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
    }

}finally {
    lock.unlock();
}return sb.toString();

}}
