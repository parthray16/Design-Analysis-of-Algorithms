public class test {
    public static void main(String[] args) {
        System.out.println("\n-------Test 1--------"); // 1, 4, 5
        int[] stime1 = {4, 3, 2, 10, 7};
        int[] ftime1 = {7, 10, 6, 13, 9};
        int[] weight1 = {6, 6, 5, 2, 8};
        int[] soln1 = WgtIntScheduler.getOptSet(stime1, ftime1, weight1);
        System.out.println(soln1[0]);
        System.out.println(soln1[1]);
        System.out.println(soln1[2]);

        System.out.println("\n-------Test 2--------"); //2, 4
        int[] stime2 = {3, 3, 1, 10, 8};
        int[] ftime2 = {7, 10, 4, 13, 11};
        int[] weight2 = {6, 9, 5, 8, 10};
        int[] soln2 = WgtIntScheduler.getOptSet(stime2, ftime2, weight2);
        System.out.println(soln2[0]);
        System.out.println(soln2[1]);
        
        System.out.println("\n-------Test 3--------"); //1, 2
        int[] stime3 = {3, 2};
        int[] ftime3 = {7, 3};
        int[] weight3 = {6, 10};
        int[] soln3 = WgtIntScheduler.getOptSet(stime3, ftime3, weight3);
        System.out.println(soln3[0]);
        System.out.println(soln3[1]);

        System.out.println("\n-------Test 4--------"); //1
        int[] stime4 = {3, 2};
        int[] ftime4 = {7, 4};
        int[] weight4 = {10, 4};
        int[] soln4 = WgtIntScheduler.getOptSet(stime4, ftime4, weight4);
        System.out.println(soln4[0]);
    }
}
