import java.util.Arrays;
import java.util.Scanner;

public class TrafficProblem {
    static int[] countarr;
    
    //to count total no. of lane
    static int totalLaneWait(int[] a,int n){
        int total=0;
        for (int i=0;i<n;i++)   total+=a[i];
        return total;
    }

    //for sorting array 
    static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int tmp = 0;
                if (a[i] > a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    //to perform search operation on array.
    static int search(int[] a,int num){
        for (int i=0;i<a.length;i++){
            if(a[i]==num){
                if (countarr[i]==0){
                    countarr[i]++;
                    return i;
                }
            }
        }
        return -1;
    }

    // converting String to integer array.
    static int[] convert(String arr){
        String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        return results;
    }

    public static void main(String[] args) {

        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][];
        sc.nextLine();
        for (int i=0;i<n;i++){
            String temp = sc.nextLine();
            arr[i] = Arrays.stream(convert(temp)).distinct().toArray();
        }

        //finding total for each row from arr. 
        int[] total = new int[n];
        int[] tempTotal = new int[n];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                tempTotal[i] += arr[i][j];
                total[i] += arr[i][j];
            }
        }

        sort(total);

        int[] finalarray = new int[total.length*2];
        
        for (int i=0,count=0;i<total.length;i++,count++) {
            countarr = new int[total.length];
            int num = search(tempTotal,total[i]);
            finalarray[count]=num+1;
            count++;
            finalarray[count]=total[i];
        }

        System.out.print(Arrays.toString(finalarray));
    }
}
