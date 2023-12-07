package striverDSA;
import java.util.*;
public class sortingTechniques {
	
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void bubbleSort(int arr[], int n) {
		for(int i=0; i<n; i++) {
			int didswap = 0;
			for(int j=0; j<n-1;j++) {
				if(arr[j]>arr[j+1]) {
					
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					didswap = 1;
				}
			}
			if(didswap==0) {
				break;
			}
			
		}
	}
	
	public static void insertionSort(int arr[], int n) {
		for(int i=0; i<n; i++) {
			int j = i;
			while(j>0 && arr[j-1] > arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
			
		}
	}
	public static void display(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//merge sort
	public static void merge(int arr[], int low, int mid, int high) {
		ArrayList<Integer> list = new ArrayList<>();
		
		int left = low;
		int right = mid+1;
		
		while(left <= mid && right <=high) {
			if(arr[left] <= arr[right]) {
				list.add(arr[left]);
				left++;
			}
			else {
				list.add(arr[right]);
				right++;
			}
		}
		
		while(left <= mid) {
 			list.add(arr[left]);
			left++;
		}
		
		while(right<=high) {
			list.add(arr[right]);
			right++;
		}
		
		for(int i=low; i<=high; i++) {
			arr[i] = list.get(i-low);
		}
	}
	
	public static void mergeSort(int arr[], int low, int high) {
		if(low >= high) {
			return;
		}
		int mid = (low + high)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		
		merge(arr, low, mid, high);
	}
	
	//quickSort
	public static int sort(int arr[], int low, int high) {
		int mid = (low+high)/2;
		int pivot = arr[mid];
		
		int i = low;
		int j = high;
		
		while(i < j) {
			while(arr[i] <= pivot && i<= high-1) {
				i++;
			}
			while(arr[j] > pivot && j>=low+1) {
				j--;
			}
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}	
		}
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		
		return j;
	}
	public static void quickSort(int arr[], int low, int high) {
		if(low<high) {
		
			int pIndex = sort(arr, low, high); 
			
			quickSort(arr, low, pIndex-1);
			quickSort(arr, pIndex+1, high);
			
			
		}
		
	}
	public int[] qs(int arr[]) {
		sort(arr, 0, arr.length-1);
		return arr;
	}
	
	public static void recursionBubbleSort(int arr[], int n) {
		if(n==1) {
			return;
		}
		for(int i=0; i<n-1; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
		}
		recursionBubbleSort(arr,n-1);
		
	}
	public static void recursionInsertionSort(int arr[],int i, int n) {
		if(i==n) {
			return;
		}
		int j = i;
		while(j>0 && arr[j-1] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[j-1];
			arr[j-1] = temp;
			j--;
		}
		recursionInsertionSort(arr,i+1,n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,13,4,1,3,28,6,13};
		int n = arr.length;
		//selectionSort(arr);
		
		recursionInsertionSort(arr,0,n);
		display(arr);
	}

}
