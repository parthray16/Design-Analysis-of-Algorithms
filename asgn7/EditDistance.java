import java.util.ArrayList;

public class EditDistance {
    private char c1;
    private char c2;
    private int points;

    public EditDistance(char c1, char c2, int points){
        this.c1 = c1;
        this.c2 = c2;
        this.points = points;
    }
    public static void DPEditDistance(String str1, String str2, boolean printAlgn){
        //Create table of size m+1 x n+1
        int ED[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++){
            for (int j = 0; j <= str2.length(); j++){
                if (i == 0){ //set base cases
                    ED[i][j] = j * 2;
                }
                else if (j == 0){ //set base cases
                    ED[i][j] = i * 2;
                }
                else if (str1.charAt(i - 1) != str2.charAt(j - 1)){ //last chars different and...
                    int min = Math.min(ED[i][j - 1], 
                                        Math.min(ED[i - 1][j],
                                        ED[i -1][j - 1]));
                    if (ED[i - 1][j - 1] == min){ //min of surrounding 3 is diagonal, then add 1
                        ED[i][j] = 1 + min;
                    }
                    else{ //we added a gap
                        ED[i][j] = 2 + min; 
                    }
                }
                else{ //if last chars are same, take diagonal
                    ED[i][j] = ED[i - 1][j - 1];
                }
            }
        }
        System.out.println("Edit distance = " + ED[str1.length()][str2.length()]);
        //trace back
        if (printAlgn){
            ArrayList<EditDistance> alignment = new ArrayList<EditDistance>();
            int i = str1.length();
            int j = str2.length();
            while(i > 0 && j > 0){
                if (str1.charAt(i - 1) != str2.charAt(j - 1)){
                    if (ED[i - 1][j - 1] + 1 == ED[i][j]){ //if diagonal value + 1 equals the curr value, then go there
                        EditDistance entry = new EditDistance(str1.charAt(i - 1), str2.charAt(j - 1), 1);
                        alignment.add(0, entry);
                        i--;
                        j--;
                    }
                    else if(ED[i - 1][j] + 2 == ED[i][j]){ //if left value + 2 equals the curr value, then gap
                        EditDistance entry = new EditDistance(str1.charAt(i - 1), '-', 2);
                        alignment.add(0, entry);
                        i--;
                    }
                    else{ //else came from up
                        EditDistance entry = new EditDistance('-', str2.charAt(j - 1), 2);
                        alignment.add(0, entry);
                        j--;
                    }
                }
                else{ //chars same so came from diagonal
                    EditDistance entry = new EditDistance(str1.charAt(i - 1), str2.charAt(j - 1), 0);
                    alignment.add(0, entry);
                    i--;
                    j--;
                }   
            }
            while (i > 0){ //add rest of str1 gaps if needed
                EditDistance entry = new EditDistance(str1.charAt(i - 1), '-', 2);
                alignment.add(0, entry);
                i--;
            }
            while (j > 0){ //add rest of str2 gaps if needed
                EditDistance entry = new EditDistance('-', str2.charAt(j - 1), 2);
                alignment.add(0, entry);
                j--;
            }
            for(int k = 0; k < alignment.size(); k++){ //print output
                System.out.println(alignment.get(k).c1 + " " + alignment.get(k).c2 + " " + alignment.get(k).points);
            }
        }
        return;
    }
}