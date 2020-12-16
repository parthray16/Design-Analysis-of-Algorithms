import java.util.*;

public class TopSorterTest {

   public static void main(String[] args) {
      System.out.println("\n-------Test 1--------");
      ArrayList<Integer> list1 = TopSorter.srcRemTopSorter("test1.txt");
      System.out.println(list1);

      System.out.println("\n-------Test 2--------");
      ArrayList<Integer> list2 = TopSorter.dfsTopSorter("test1.txt");
      System.out.println(list2);

      System.out.println("\n-------Test 3--------");
      ArrayList<Integer> list3 = TopSorter.srcRemTopSorter("test2.txt");
      System.out.println(list3);

      System.out.println("\n-------Test 4--------");
      ArrayList<Integer> list4 = TopSorter.dfsTopSorter("test2.txt");
      System.out.println(list4);

      System.out.println("\n-------Test 5--------");
      ArrayList<Integer> list5 = TopSorter.srcRemTopSorter("test3.txt");
      System.out.println(list5);

      System.out.println("\n-------Test 6--------");
      ArrayList<Integer> list6 = TopSorter.dfsTopSorter("test3.txt");
      System.out.println(list6);

      System.out.println("\n-------Test 7--------");
      ArrayList<Integer> list7 = TopSorter.srcRemTopSorter("test4.txt");
      System.out.println(list7);

      System.out.println("\n-------Test 8--------");
      ArrayList<Integer> list8 = TopSorter.dfsTopSorter("test4.txt");
      System.out.println(list8);

      System.out.println("\n-------Test 9--------");
      ArrayList<Integer> list9 = TopSorter.srcRemTopSorter("test5.txt");
      System.out.println(list9);

      System.out.println("\n-------Test 10--------");
      ArrayList<Integer> list10 = TopSorter.dfsTopSorter("test5.txt");
      System.out.println(list10);

      System.out.println("\n-------Test 11--------");
      ArrayList<Integer> list11 = TopSorter.srcRemTopSorter("test6.txt");
      System.out.println(list11);

      System.out.println("\n-------Test 12--------");
      ArrayList<Integer> list12 = TopSorter.dfsTopSorter("test6.txt");
      System.out.println(list12);
   }
}
