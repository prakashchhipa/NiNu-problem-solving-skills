import java.util.ArrayList;
import java.util.List;

public class PowerSet
{ 
    
    void helper(int[] arr, Integer[] subset, int index) {
        if(arr.length == index) {
            System.out.print(subset[0]);
            for (int i=1;i<subset.length ;i++ ) {
                System.out.print(",");
                System.out.print(subset[i]);
            } 
            System.out.println();
            return;
        }
        
        subset[index] = null;
        helper(arr, subset, index + 1);
        subset[index] = arr[index];
        helper(arr, subset, index + 1);
    }
    
    public static void main(String[] args) 
	{ 
		int arr[]= {1,2};
		Integer[] subset = new Integer[arr.length];
		PowerSet set = new PowerSet();
		set.helper(arr, subset,0);
	} 
} 
