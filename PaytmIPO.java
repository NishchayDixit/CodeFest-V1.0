import java.util.Scanner;

class PaytmIPO{

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

    public static int getMaxValue(int[] numbers){
	  int maxValue = numbers[0];
	  for(int i=1;i < numbers.length;i++){
	    if(numbers[i] > maxValue){
	      maxValue = numbers[i];
	    }
	  }
	  return maxValue;
	}

	public static int getMaxIndex(int[] numbers){
	  int maxValue = numbers[0];
	  int maxIndex = 0;
	  for(int i=1;i < numbers.length;i++){
	    if(numbers[i] > maxValue){
	      maxValue = numbers[i];
	      maxIndex = i;
	    }
	  }
	  return maxIndex;
	}

	public static int getMinValue(int[] numbers){
	  int minValue = numbers[0];
	  for(int i=1;i<numbers.length;i++){
	    if(numbers[i] < minValue){
	      minValue = numbers[i];
	    }
  		}	
	  return minValue;
	}

	static class Time{
		int hr;
		int min;

		Time(int hr,int min){
			this.hr=hr;
			this.min=min;
		}

		void add(int hr,int min){
			this.hr += hr;
			this.min += min;
			this.hr += this.min/60;
			this.min %= 60;

		}

		String getTime(){
			return (((this.hr%12)==0?12:this.hr%12)+"."+this.min);
		}
	}

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];
        sc.nextLine();
        for (int i=0;i<n;i++){
            String temp = sc.nextLine();
            arr[i] = convert(temp);
        }
       	PaytmIPO.Time t; 
        for (int i=0;i<n;i++) {
        	t = new PaytmIPO.Time(9,30);
        	int ans = getMaxValue(arr[i]) - getMinValue(arr[i]);
        	int min = getMaxIndex(arr[i])*10;
        	t.add(min/60,min%60);
        	System.out.print("[");
        	System.out.print(ans+",");
        	System.out.print(t.getTime());
        	System.out.println("]");
        }
	}
}