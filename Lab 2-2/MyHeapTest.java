import java.util.Arrays;

public class MyHeapTest {

   public static void main(String[] args) {
       int[] arr = {10, 43, 1, 4};
       MyHeap minpq = new MyHeap();
       minpq.buildHeap(arr);
       System.out.println(Arrays.toString(minpq.heap));
       minpq.deleteMin();
       System.out.println(Arrays.toString(minpq.heap));
       minpq.deleteMin();
       System.out.println(Arrays.toString(minpq.heap));
       minpq.deleteMin();
       System.out.println(Arrays.toString(minpq.heap));
       minpq.deleteMin();
       System.out.println(Arrays.toString(minpq.heap));

       int[] arr1 = {55,32,93,65,56,65,57,50,36,22,82,76,11,44,43,86,28,75,38,69};
       System.out.println(Arrays.toString(MyHeap.heapSortDecreasing(arr1)));

       int[] arr3 = {3, 4, 2, 1, 7, 10};
       System.out.println(Arrays.toString(MyHeap.heapSortDecreasing(arr3)));

       int[] arr2 = {10, 43, 1};
       MyHeap minpq2 = new MyHeap(5);
       minpq2.buildHeap(arr2);
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.insert(3);
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.insert(0);
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.deleteMin();
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.deleteMin();
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.insert(17);
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
       minpq2.deleteMin();
       System.out.println(Arrays.toString(minpq2.heap));
       System.out.println(minpq2.size);
   }
}