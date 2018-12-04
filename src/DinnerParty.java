import java.util.ArrayList;
import java.util.List;

public class DinnerParty
{ 
    static int[][] groups = new int[100][3];
    
	public void find_friends(int[] arr, int data[], int n, int index, int pos, int r) {
        
        //recursion ending
        if(index == r) {
            for (int i=0 ; i<r ;i++ ) {
                System.out.print(data[i]);
            }
            System.out.println();
            return;
        }
        
        if(pos >= n) {
            return;
        }
        
        //include
        data[index] = arr[pos];
        find_friends(arr, data, n, index + 1, pos + 1, r);
        //exclude
        find_friends(arr, data, n, index, pos + 1, r);
    }
    	
    public void printGroups(int []arr, int n, int r) {
        find_friends(arr, new int[r],  arr.length, 0, 0, r);
    }
    
    public static void main(String[] args) 
	{ 
		int arr[]= {1,2,3,4,5};
		int n = arr.length;
		int r = 3;
		DinnerParty party= new DinnerParty();
		
		party.printGroups(arr, arr.length,3); 
	} 
} 
