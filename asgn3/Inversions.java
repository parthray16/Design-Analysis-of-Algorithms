import java.util.Arrays;

public class Inversions{
    private static int z = 0; //where to put sorted item in arr

    public static int invCounter(int[] arr){
        if (arr.length == 1){
            return 0;
        }
        int invcount = 0;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);  
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        invcount += invCounter(left);   // divide in half
        invcount += invCounter(right);  //divide in half
        invcount += merge(arr, left, right, mid); //combine
        z = 0;
        return invcount;
    }

    private static int merge(int[] arr, int[] left, int[] right, int mid){
        int i = 0;
        int j = 0;
        int invcount = 0;
        while(i < left.length && j < right.length){
            if (left[i] <= right[j]){ //if left one is smaller than right
                arr[z] = left[i++];
                z++;
            }
            else{
                arr[z] = right[j++]; //if the left one is bigger than right
                z++;
                invcount += (mid - i); //since we know everything past the i index in the left array is sorted, right[j] must also be less all the elements in left array including and past i, therefore mid - 1 inversions.         
            }
        }
        while(i < left.length){ //put remaining elements back into list, left array
            arr[z++] = left[i++];
        }
        while(j < right.length){ //put remaining elements back into list, right array
            arr[z++] = right[j++];
        }
        return invcount;
    }
}