package striverDSA;
import java.util.*;
import java.util.Arrays;
import java.util.*;
public class BacisArrays {
	
/**1.__________Find the largest element in the array__________*/
	//brute force approach [ TC- O(N*log n) ] 
	public static void largeElement(int arr[]) {
		int n = arr.length;
		Arrays.sort(arr);
		System.out.println(arr[n-1]);
	}
	//optimal recursive approach [ TC- O(n) ]...
	public static int largestElement(int arr[], int n) {
		int max = arr[0];
		for(int i=0; i<n; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
			
		}
		return max;
	}

/**2.______Find the second largest/second smallest element______*/	
	//brute force approach 
	public static void secondLargest(int arr[]) {
		Arrays.sort(arr);
		System.out.println(arr[arr.length-2]);
	}
	//brute force approach 
	public static void secondlargest(int arr[]) {
		int max = arr[0];
		int secondmax = 0;
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max ) {
				max = arr[i];
			}
		}
		System.out.println(max);
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] != max) {
				secondmax = arr[i];
				break;
			}
		}
		System.out.println(secondmax);
		
	}
	//better approach
	public static void secondLarge(int arr[]) {
		int largest = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>largest) {
				largest = arr[i];
			}
		}
		System.out.println(largest);
		int slarge = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]> slarge && arr[i] != largest) {
				slarge = arr[i];
			}
		}
		System.out.println(slarge);
		
	}
	//optimal approach
	public static void secLargest(int arr[]) {
		int largest = arr[0];
		int slargest = -1;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > largest) {
				slargest=largest;
				largest = arr[i];
			}
			else if(arr[i] > slargest && arr[i] < slargest) {
				slargest = arr[i];
				
			}
		}
		System.out.println(slargest);
	}

/**3________Second Smallest________**/
	public static void secondSmallest(int arr[]) {
		int smallest = arr[0];
		int ssmallest = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < smallest) {
				ssmallest = smallest;
				smallest = arr[i];
			}
			else if(arr[i] > smallest && arr[i] <ssmallest) {
				ssmallest = arr[i];
			}
		}
		System.out.println(ssmallest);
	}
	
/**4.____________is array sorted____________*/
	public static boolean isSorted(int arr[]) {
		for(int i=1; i<arr.length; i++) {
			if(arr[i] >= arr[i-1]) {
			
			}
			else {
				return false;
			}
		}
		return true;
		
	}

/**5.____________remove duplicate_____________*/
	//brute force approach
	public static void removeDuplicate(int arr[]) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		System.out.println(set);
	}
	//optimal approach
	public static int removeduplicate(int arr[]) {

		int i=0;
		for(int j=0; j<arr.length; j++) {
			if(arr[j] != arr[i]) {
				arr[i+1] = arr[j];
				i++;
			}
		}
		return i+1;
	}

/**6.____________Rotate array by one place____________**/	
	//brute force approach
	public static void rotateByone(int arr[], int n) {
		int temp[] = new int[n];
		for(int i=1; i<n; i++) {
			
			temp[i-1] = arr[i];
		}
		temp[n-1] = arr[0];
		
		for(int i=0; i<n; i++) {
			System.out.print(temp[i]+" ");
		}
	}
	//Optimal approach
	public static void rotateByOne(int arr[], int n) {
		int temp = arr[0];
		for(int i=1; i<n; i++) {
			
			arr[i-1] = arr[i];
		}
		arr[n-1] = temp;
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
/**7.________left rotate the array by D places_________**/
	//brute approach
	public static void leftrotateByDplaces(int arr[], int n) {
		
		int temp[] = new int [n];
		
		for(int i=2; i<n; i++) {
			temp[i-2] = arr[i];
		}
		temp[n-1] = arr[1];
		temp[n-2] = arr[0];
		
		for(int i=0; i<n; i++) {
			System.out.println(temp[i]);
		}
	}
	//better approach//
	public static void leftrotatebyDplaces(int arr[], int n, int k) {
		if(n==0) 
		return;
		
		k= k%n;
		if(k>n)
		return;
		
		//create temporary array//
		int temp[] = new int[n];
		for(int i=0; i<k; i++) {
			temp[i] = arr[i];
		}
		//left shift by k places//
		for(int i=k; i<n; i++) {
			arr[i-k] = arr[i];
		}
		//copy the temporary array in the final array//
		
		for(int i=n-k; i<n; i++) {
			arr[i] = temp[i-(n-k)];
		}
		//print the array//
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//Optimal approach//
	/*function to reverse the array*/
	public static void reverse(int arr[], int start, int end) {
		while(start <= end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}
	/*function to left by k places*/
	public static void leftRotateDplaces(int arr[], int n, int k) {
		//reverse the array from 0 to n-k-1
		reverse(arr,0,k-1);
		//reverse the array from n-k to n-1
		reverse(arr, k, n-1);
		
		//reverse the whole array from 0 to n-1
		
		reverse(arr, 0, n-1);
		
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+"   ");
		}
	}

/**8._________Places all the zeros at the end of the array_________**/	
	//brute force approach
	public static void zerosAtTheEnd(int arr[], int n) {
		ArrayList<Integer> temp = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			if(arr[i]!= 0) {
				temp.add(arr[i]);
			}
		}
		int nz = temp.size();
		
		for(int i=0; i<nz; i++) {
			arr[i] = temp.get(i);
		}
		
		for(int i=nz; i<n; i++) {
			arr[i] = 0;
		}
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//Optimal approach
	public static void zeroatEnd(int arr[], int n) {
		int j=-1;
		//place the pointer j as 0
		for(int i=0; i<n; i++) {
			if(arr[i] == 0) {
				j=i;
				break;
			}
		}
		//check if there is a 0 or not
		if(j == -1) {
			System.out.println("array has no zeros");
			return;
		}
		//compare i with j and swap
		for(int i=j+1; i<n; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		//print array with zeros at the end
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
/**9.________linear search__________**/
	public static int linearSearch(int arr[], int n, int k) {
		for(int i=0; i<n; i++) {
			if(arr[i]==k) 
				return i;
			
			
		}
		return -1;
	}
	
/**10.________union of two arrays________**/
	//brute force approach
	public static void unionOfTwoArray(int arr1[], int arr2[]) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr1.length-1; i++) {
			if(arr1[i] != arr1[i+1]) {
				set.add(arr1[i]);
			}
		}	
		for(int i=1; i<arr2.length; i++) {
			if(arr2[i] != arr2[i-1]) {
				set.add(arr2[i]);
			}
		}
		System.out.println(set);
	}
	//Optimal approach
	public static ArrayList<Integer> unionOfArray(int arr1[], int arr2[], int n, int m) {
		int i=0, j=0; //pointers
		ArrayList<Integer> union = new ArrayList<>();
		while(i<n && j<m) {
			 if(arr1[i] <= arr2[j]) {
				 if(union.size() == 0 || union.get(union.size()-1) != arr1[i])
					 union.add(arr1[i]);
				 	 i++;
			 }
			else {
				if(union.size() == 0 || union.get(union.size()-1) != arr2[j])
					 union.add(arr2[j]);
				 	 j++;
			}	 	
		}
		
		while(i<n) {
			if(union.get(union.size()-1) != arr1[i])
				union.add(arr1[i]);
			i++;
		}
		
		while(j<m) {
			if(union.get(union.size()-1) != arr2[j])
				union.add(arr2[j]);
			j++;
		}
		
		return union;
	}

/**11.___________Missing Numbers___________**/
	//brute force approach
	public static void missingNumbers(int arr[], int n) {
	
		for(int i=1; i<=n; i++) {
			int flag = 0;
			for(int j=0; j<arr.length; j++) {
				
				if(arr[j] == i) {
				flag=1;
				break;
				}
			}
		if(flag == 0)
			System.out.println(i);
		}
		
	}
	//Optimal approach sum rule
	public static void missingNum(int arr[], int n) {
		int sum = (n*(n+1))/2;
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			num += arr[i];
		}
		System.out.println(sum-num);
	}
	//Optimal approach XOR rule
	public static int missingNumb(int arr[], int n) {
		int xor1=0, xor2=0;
		
		for(int i=0; i<=n-1; i++) {
			xor2 = xor2 ^arr[i];
			xor1 = xor1 ^ (i);
		}
		xor1 = xor1 ^ n;
		
		return (xor1^xor2);
	}

/**12.________max consecutive one________**/
	public static void maxOne(int arr[]) {
		int max = 0;
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				count++;
				max = Math.max(max, count);
			}else {
				count=0;
			}
		}
		System.out.println(max);
	}

/**13.___________find the number appears only once___________**/
	public static void findNumApearsOnce(int arr[], int n) {
		int single = 0;
		
		for(int i=0; i<n; i++) {
			single = single ^ arr[i];
		}
		
		System.out.println(single);
		
	}
/**________sub array of sum is equal to k__________**/
	//brute force approach// approx (O(n^3)
	public static void subarray(int arr[], long k) {
		
		int n = arr.length;
		
		int maxLen = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				
				
				long s = 0;
				for(int l=i; l<=j; l++) {
					s += arr[l];
				}
				
				if( s == k) {
					maxLen = Math.max(maxLen, j-i+1);
				}
			}
		}
		System.out.println(maxLen);	
	}
	//brute force approach// aprox O(n^2)
	public static int subArrays(int arr[], long k) {
		int n = arr.length;
		
		int len = 0;
		
		for(int i=0; i<n; i++) {
			
			long s = 0;
			for(int j=i; j<n; j++) {
				
				s += arr[j];
			
			if( s == k ) {
				len = Math.max(len, j-i+1);
			}
			
			}
		
		}
		return len;
	}
	//optimal approach//
	public static void subArray(int arr[], long k) {
		int n= arr.length;
		
		int left = 0, right = 0;
		
		long sum = arr[0];
		int maxLen = 0;
		
		while(right < n) {
			
			while(left <= right && sum > k) {
				sum -= arr[left];
				left++;
			}
			
			if(sum == k) {
				maxLen = Math.max(maxLen, right - left +1);
			}
		right++;
		if(right < n) {
			sum += arr[right];
		}
	}
		System.out.println(maxLen);
}
/**________sub array of sum is equal to k__________**/
	public static void SubArray(int arr[], int k) {
		int n = arr.length;
		
		HashMap<Long, Integer> preSumMap = new HashMap<>();
		long sum = 0;
		long maxlen = 0;
		
		for(int i=0; i<n; i++) {
			sum += arr[i];
				if(sum == k) {
				maxlen = Math.max(maxlen, i+1);
			}
			
			long rem = sum-k;
			
			if(preSumMap.containsKey(rem)) {
				long len = i - preSumMap.get(rem);
				maxlen = Math.max(maxlen, len);
			}
			
			if(!preSumMap.containsKey(sum)) {
				preSumMap.put(sum, i);
			}
		}
		System.out.println(maxlen);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr1[] = {1,1,2,1,1,1,4,2,3};
		int arr2[] = {1,1,2,3,3,4,4};
		int n = 3;
		int m = arr2.length;
//		int k=sc.nextInt();
		SubArray(arr1, n);
				
		
	sc.close();
	}

}
