public class InversionsTest {
    public static void main(String[] args) {
        System.out.println("\n-------Test 1--------");
        int[] arr1 = {6, 4, 3, 1}; // 6 
        System.out.println(Inversions.invCounter(arr1));
  
        System.out.println("\n-------Test 2--------");
        int[] arr2 = {2, 3, 8, 6, 1}; // 5
        System.out.println(Inversions.invCounter(arr2));

        System.out.println("\n-------Test 3--------");
        int[] arr3 = {3, 2}; // 1
        System.out.println(Inversions.invCounter(arr3));

        System.out.println("\n-------Test 4--------");
        int[] arr4 = {1, 20, 6, 4, 5}; // 5
        System.out.println(Inversions.invCounter(arr4));

        System.out.println("\n-------Test 5--------");
        int[] arr5 = {8, 4, 2, 1}; // 6
        System.out.println(Inversions.invCounter(arr5));

        System.out.println("\n-------Test 6--------");
        int[] arr6 = {3, 1, 2}; // 2
        System.out.println(Inversions.invCounter(arr6));

        System.out.println("\n-------Test 7--------");
        int[] arr7 = {1, 3, 5, 2, 4, 6}; // 3
        System.out.println(Inversions.invCounter(arr7));
    }
}
