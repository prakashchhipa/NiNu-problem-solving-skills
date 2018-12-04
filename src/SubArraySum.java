import java.util.ArrayList;
import java.util.List;
 
public class SubArraySum { 
    
    public int subArrSum(int[] arr, int target) {
        int start =0, end =0, n = arr.length,maxlen = n + 1, curr_sum = 0;
        
        while (end < n) {
            //add up till sum exceeds
            while(curr_sum <= target && end < n) {
                //negetive Number handling
                if(curr_sum < 0 && target > 0) {
                    start = end;
                    curr_sum = 0;
                }
                curr_sum = curr_sum + arr[end++];
            }
            
            while (curr_sum > target && start < n) {
                if(maxlen > end -start) {
                    maxlen = end - start;
                }
                curr_sum = curr_sum - arr[start++];
               
            }
            
        }
        return maxlen;
    
    }
   
    
    
    public static void main(String[] args) 
	{ 
		int arr[]= {1,2,3,5,7};
		int target = 10;
	    SubArraySum sum = new SubArraySum();
	    System.out.print(sum.subArrSum(arr, target));
	
	
	} 
} 
