import java.util.*;

public class MyHeap{	
    int[] heap;
    int capacity; 
    int size;
	
    public MyHeap(){
        capacity = 50;
        size = 0;
        heap = new int[capacity];
    }

    public MyHeap(int capacity){
        this.capacity = capacity;
        size = 0;
        heap = new int[capacity];
    }

    public int getHeapCap(){return capacity;}
    public int getHeapSize(){return size;}
    public boolean isEmpty(){return size == 0;}
    public boolean isFull(){return size == capacity;}

    public void swap(int idx1, int idx2){
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
        return;
    }

    public boolean buildHeap(int[] arr){
        if (arr.length > capacity){
            return false;
        }
        heap = Arrays.copyOf(arr, capacity);
        size = arr.length;
        int i = getParentIdx(size - 1);
        while (i >= 0){
            driftDown(i);
            i--;
        }
        return true;
    }

    public boolean insert(int n){
        if (isFull()){
            return false;
        }
        heap[size] = n;
        driftUp(size);
        size++;
        return true;
    }

    public int findMin(){
        return heap[0];
    }

    public int deleteMin(){
        int min = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;
        driftDown(0);
        return min;
        
    }

    public void driftDown(int idx){
        int minIdx = getMinChildIdx(idx);
        if (minIdx < 0 || heap[idx] < heap[minIdx]){
            return;
        }
        swap(idx, minIdx);
        driftDown(minIdx);
        return;
    }

    public void driftUp(int idx){
        int parentIdx = getParentIdx(idx);
        if (parentIdx < 0 || heap[parentIdx] < heap[idx]){
            return;
        }
        swap(idx, parentIdx);
        driftUp(parentIdx);
        return;
    }

    public static int getParentIdx(int idx){
        if (idx == 0){
            return -1;
        }
        return (idx - 1) / 2;}

    public int getMinChildIdx(int idx){
        int left = 2*(idx) + 1;
        int right = 2*(idx) + 2;
        if (left == (size - 1)){
            return left;
        }
        if ((left >= size) || (right >= size) || (idx < 0)){
            return -1;
        }
        if (heap[left] < heap[right]){
            return left;
        }
        return right;
    }

    public static int[] heapSortDecreasing(int[] arr){
        MyHeap minpq = new MyHeap(arr.length);
        minpq.buildHeap(arr);
        while (!(minpq.isEmpty())){
            minpq.swap(0, minpq.getHeapSize() - 1);
            minpq.size = minpq.size - 1;
            minpq.driftDown(0);
        }
        return minpq.heap;
    }
}