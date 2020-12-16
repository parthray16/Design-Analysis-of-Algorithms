import java.util.Arrays;

public class WgtIntScheduler{
    public static int[] getOptSet(int[] stime, int[] ftime, int[] weight){
        int[] sortedF = sortFTimes(ftime); //idx of sorted ftimes in increasing order
        int[] maxW = new int[ftime.length]; //table to fill up with maxWeights for each jobs
        maxW[0] = weight[sortedF[0]];
        for(int j = 1; j < maxW.length; j++){
            //reccurence relation
            boolean anyCompatible = false;
            int i = j;
            while(i > 0){ //farthest right job compatible with j
                if (ftime[sortedF[i - 1]] <= stime[sortedF[j]]){
                    i--;
                    anyCompatible = true;
                    break;
                }
                i--;
            }
            if (anyCompatible){
                maxW[j] = Math.max(maxW[j - 1], maxW[i] + weight[sortedF[j]]);
            }
            else{
                maxW[j] = Math.max(maxW[j - 1], 0 + weight[sortedF[j]]);
            }
        }
        int[] optSet = new int[ftime.length];
        int count = 0;
        //traceBack
        int i = ftime.length - 1;
        while(i >= 0){
            if(i > 0 && maxW[i] == maxW[i - 1]){
                i--;
            }
            else{
                optSet[count++] = sortedF[i] + 1;
                int z = i;
                while(z > 0){ //farthest right job compatible with i
                    if (ftime[sortedF[z - 1]] <= stime[sortedF[i]] &&
                        weight[sortedF[i]] + maxW[z - 1] == maxW[i]){
                        i = z - 1;
                        break;
                    }
                    z--;
                }
                if (z == 0){
                    break;
                }
            }
        }
        int[] optmSet = new int[count];
        for (int k = 0; k < count; k++){ //truncate array
            optmSet[k] = optSet[k];
        }
        Arrays.sort(optmSet); //sort job ids
        return optmSet;
    }

    public static int[] sortFTimes(int[] ftime){
        int[] copyTimes = Arrays.copyOf(ftime, ftime.length);
        int[] sortedF = new int[ftime.length];
        for (int i=0; i<ftime.length; i++){
            int mini = 0;
            for (int j = 0; j < ftime.length; j++){
                if (copyTimes[mini] > copyTimes[j]){
                    mini = j;
                }
            }
            sortedF[i] = mini; //stores job numbers of increasing finish times
            copyTimes[mini] = Integer.MAX_VALUE;
        }
        return sortedF;
    }
}