import java.util.Scanner;
import java.util.Arrays;

class TelephoneGrid{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[][][] a = new int[n][][];
		int count3d=0;
		for (int k=0;k<n;k++) {
			int count=k;
			a[k]=new int[n][];
			for(int i=0;i<n;i++){
				a[k][i] = new int[n];
				for(int j=0;j<n;j++){
					a[k][i][j] = (count%n)+1;
					count++;
				}
				count=(k+i)%n+1;
			}
			count3d++;
		}
		
		for (int k=0;k<count3d;k++) {
			System.out.print("[");
			for(int i=0;i<n;i++){
				System.out.print("[");
				for(int j=0;j<n;j++){
					System.out.print(a[k][i][j]);
					if(!((n-1)==j))
						System.out.print(",");
				}
				System.out.print("]");
				if(!((n-1)==i))
						System.out.print(",");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}