package striverDSA;

public class BasicMath {
	//extract all the digit
	public static void lastDigit(int n) {
		int lastDigit = 0;
		
		while(n>0) {
			lastDigit = n%10;
			System.out.println(lastDigit);
			break;
			
		}
	}
	
	//count of the digit
	public static void countDigit(int n) {
		String s = Long.toString(n);
        System.out.println(s.length());
        
        int count = 0;
        while(n>0) { 	
        	count+=1;
        	n = n/10;
        }
        System.out.println("\n" + count);
	}
	
	//reverse the order
	public static void reversDigit(int n) {
		
        int reversNum = 0;
        while(n>0) {
        	int lastDigit = n%10;
        	reversNum = (reversNum*10)+lastDigit ;
        	n = n/10;
        }
        System.out.println(reversNum);
	}
	
	//Is Palindrome number
	public static boolean isPalindrome(int n) {
			int dup = n;
	        int reversNum = 0;
	        while(n>0) {
	        	int lastDigit = n%10;
	        	reversNum = (reversNum*10)+lastDigit ;
	        	n = n/10;
	        	
	        }
	        System.out.println(reversNum);
	        if(dup == reversNum) {
	        	return true;
	        }
	        return false;
	        
		}
	
	//Is an Armstrong number
	public static boolean isArmStrong(int n) {
			int dup = n;
			String s= Integer.toString(n);
			int pow = s.length();
	        int armStrongNum = 0;
	        while(n > 0) {
	        	int l = n%10;
	        	armStrongNum += Math.pow(l, pow) ;
	        	n = n/10;
	        	
	        }
	        System.out.println(armStrongNum);
	        if(dup == armStrongNum) {
	        	return true;
	        }
	        return false;
	        
		}
	
	// All Divisor of number
	public static void allDivisors(int n) {
		for(int i=1; i<=n; i++) {
			if(n%i == 0) {
				System.out.print(i+" ");
			}
		}
	}
	
	// is PrimeNumber
	public static boolean isPrime(int n) {
		int count = 0; 
		for(int i=1; i*i<=n; i++) {
			if(n%i == 0) {
				count++;
				if(n/i != i) {
					count++;
				}
			
			}
			
		}
		if(count == 2) {
			return true;
		}
		return false;
	}
	
	//GCD / HCF of number
	public static void gCd(int a, int b) {
		int hCf = 0;
		int gcd = 1;
		for(int i=1; i<=Math.min(a, b); i++) {
			if(a%i==0 && b%i==0) {
				hCf = hCf*0 + i;
				gcd = i;
			}
		}
		System.out.println(hCf);
		System.out.println(gcd);
	}
	
	public static void gCdEuclidian(int a, int b) {
		
		while(a>0 && b>0) {
			if(a>b) {
				a = a%b;
			}else {
				b = b%a;
			}
		}
		if(a == 0) {
			System.out.println("gCd is: " + b);
		}else {
			System.out.println("gCd is: " + a);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//reversDigit(152364);
		
		//System.out.println(isPrime(41));
		
       //allDivisors(27);
		
		lastDigit(12564685);

	}

}
