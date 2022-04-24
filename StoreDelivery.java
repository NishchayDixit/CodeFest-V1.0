import java.util.Scanner;
import java.util.Arrays;

class StoreDelivery{

	private static final int CONST_N = 3;

	// converting String to integer array.
    static int[] convert(String arr){
        String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++){
            try {
                results[i] = Integer.parseInt(items[i]);
            }
           	catch (NumberFormatException ignored){}
        }
        return results;
    }

    static boolean isValid(int[][] arr)
    {
		int a_count=0;
		int b_count=0;
		for ( int k = 0 ; k < arr[2].length ; k++ ){
			if((a_count!=arr[0].length) && (arr[0][a_count] == arr[2][k]))
				a_count++;
			else if((b_count!=arr[1].length) && (arr[1][b_count] == arr[2][k]))
				b_count++;
			else
				return false;
		}
			
		return true; 
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		int[][][] a = new int[n][][];

		for (int i=0;i<n;i++) {
			a[i]= new int[CONST_N][];
			for (int j=0;j<CONST_N;j++) {
				String temp = sc.nextLine();
            	a[i][j] = convert(temp);
			}
		}

		for (int i=0;i<n;i++){
			if(isValid(a[i]))
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
	}
}