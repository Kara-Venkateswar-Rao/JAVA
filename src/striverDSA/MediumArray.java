package striverDSA;
import java.util.*;
public class MediumArray {
	
/**1._________Two sum______**/
	//brute force//
	public static String twoSum(int arr[], int k) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<i; j++) {
				
				int sum = arr[i]+arr[j];
				
				if(sum == k && arr[i]!=arr[j]) {
					
					return "yes";
					
				}				
			}
			
		}
		
		return "No";
		
	}
	//returning index
	public static int[] twoSUm(int arr[], int k) {
		int n=arr.length;
		int ans[] = new int[2];
		ans[0] = ans[1] = -1;
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<n; j++) {
				
				int sum = arr[i]+arr[j];
				
				if(sum == k && arr[i]!=arr[j]) {
					ans[0] = j;
					ans[1] = i;
				}
				
			}
		}
		return ans;
		
	}
	
	//Using hash map
	
	
	//using optimized approach
	public static String twoSUM(int arr[], int k) {
		int n=arr.length;
		Arrays.sort(arr);
		int left=0, right = n-1;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(sum == k) {
				return "YES";
			}
			else if(sum < k) {
				left++;
			}
			else right--;
			}
		return "NO";
		}
/**2. 0's 1's and 2's**/	
	//brute force//
	public static void sequancesort(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i]< arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//better
	public static void sequanceSort(int arr[]) {
		int n = arr.length;
		
		int cnt0 = 0,cnt1 = 0, cnt2 = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i] == 0) {
				cnt0++;
			}else if(arr[i] == 1) {
				cnt1++;
			}else if(arr[i] == 2) {
				cnt2++;
			}
		}
		
		for(int i=0; i<cnt0; i++) {
			arr[i] = 0;
		}
		for(int i=cnt0; i<cnt0+cnt1; i++) {
			arr[i] = 1;
		}
		for(int i=cnt0+cnt1; i<n; i++ ) {
			arr[i] = 2;
		}
		
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//optimal approach
	//swap function
	public static int[] sort(int arr[], int left, int right) {
		
		while(left <= right) {
			if(arr[left] > arr[right]) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
			}
		}
		return arr;
	}
	public static void sequanceSortt(int arr[]) {
		int n = arr.length;
		int low = 0, mid = 0, high =n-1;
		
		while(mid <= high) {
			
			if(arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
			}else if(arr[mid] == 1) {
				mid++;
			}else{
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}

		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
/**3.__________occurs more than N/2 times__________**/	
	public static int moreThanNby2(int arr[], int n) {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			
		for(int j=0; j<01; j++){
			if(arr[i] == arr[j]) {
				cnt++;
				
			}
			
			if(cnt > n/2) {
				return arr[j];
			}
		}
	}
		return -1;
}
	
	//better approach//
	public static void morethenNBy2(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i],i);
		}
	}
	//Optimal approach//
	public static int moreThanNBy2(int arr[], int n) {
		int cnt = 0;
		int el = 0;
		for(int i=0; i<n; i++) {
			if(cnt == 0) {
			cnt=1;
			el = arr[i];
			}if(arr[i] == el) {
				cnt++;
			}else {
				cnt--;
			}
		}
		int cnt1 = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == el) 
				cnt1++;
		}	
			if(cnt1 > (n/2)) {
				return el;
			}
		return -1;
	}
/**4.____________maxSubarraySum____________**/
	//better approach//
	public static int maxSubarraySum(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum+=arr[j];
				
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	public static int maxSubArraySum(int arr[], int n) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
			
			if(sum > max) {
				max = sum;
			}
			
			if(sum<0) {
				sum = 0;
				
			}
		}
		return max;
	}
	
	public static int maximumProfit(ArrayList<Integer> prices){
      

        int buy = Integer.MAX_VALUE;
        int sell = 0;

        for(int i=0; i<prices.size(); i++){
            buy = Math.min(buy, prices.get(i));
            sell = Math.max(sell, prices.get(i) - buy);
        }

        return sell;
        
    }
	public static void ElementsbySign(int arr[]) {
		int n = arr.length;
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(arr[i]>0) {
				pos.add(arr[i]);
			}
			else {
				neg.add(arr[i]);
			}
		}
		for(int i=0; i<n/2; i++) {
			arr[2*i] = pos.get(i);
			arr[2*i+1] = neg.get(i);
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
//		System.out.println(pos);
//		System.out.println(neg);	
	}
	public static ArrayList<Integer> ElementsBySign(ArrayList<Integer> list){
		int n = list.size();
		
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
		 int posIndex = 0, negIndex = 1;
	        for (int i = 0; i < n; i++) {
	        	if(list.get(i) < 0) {
	        		ans.set(negIndex, list.get(i));
	        		negIndex += 2;
	        	}
	        	else {
	        		ans.set(posIndex, list.get(i));
	        		posIndex += 2;
	        	}
	        }
		
	        return ans;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7,1,2,4,5,6,8));
		
//		System.out.println(what);
		
//		int arr[] = {1,2,3,-3,-2,-1};
//		
//		ElementsbySign(arr);
		
		
		
		
	}

}
