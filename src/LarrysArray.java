import java.util.Scanner;

public class LarrysArray {
	
	  static String larrysArray(int[] A) {
		  
		  boolean flag = false;
		  int rot;
		  for (int i=0; i<=A.length-3; i++){
			  rot = rotateAndCheck(A[i],A[i+1], A[i+2]);
			  if (rot==0){
				  flag = false;
			  }
			  if(rot == 2){
				int t = A[i];
				int t1 = A[i+2];
				A[i] = A[i+1];
				A[i+1] = t1;
				A[i+2] = t;
				flag = true;
			  }
			  else if(rot == 3){
				  int t = A[i];
				  int t1 = A[i+2];
				  A[i] = t1;
				  A[i+2] = A[i+1];
				  A[i+1] = t;
				  flag = true;
				  
			  }
		  }
		  if(flag )
			  return "YES";
		  else 
			  return "NO";
		}
	  
	   static boolean isSorted(int a, int b, int c){
		   if(a<b && b< c){
			   return true;
		   }
		   return false;
	   }
	  static int rotateAndCheck(int a, int b, int c) {
		  
		  int rotType = 0;
		  int tmpA;
		   int tmpB;
		   int tmpC;
				  
		  if(isSorted(a,b, c)) {
			  rotType= 1;
		  }	  		 
		   tmpA = b;
		   tmpB = c;
		   tmpC = a;
		 	   
		   if(isSorted(tmpA,tmpB, tmpC)) {
			   rotType = 2;
		   }
		   tmpA = c;
		   tmpB = a;
		   tmpC = b;
		  
		   if(isSorted(tmpA,tmpB, tmpC)) {
			   rotType = 3;
		   }
		 
		  return rotType;
	  }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] A = new int[n];
	            for(int A_i = 0; A_i < n; A_i++){
	                A[A_i] = in.nextInt();
	            }
	            System.out.println(larrysArray(A));
	        }
	        in.close();
	    }

}
