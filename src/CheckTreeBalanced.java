import java.util.*;

class TreeNode {
    public int id;
    TreeNode left, right;
    public TreeNode(int nodeId) {
        this.id = nodeId;
    }
}


public class CheckTreeBalanced
{ 
    public TreeNode createBSTFromSortedArr(int[] arr) {
        return createBSTFromSortedArr(arr, 0, arr.length-1);
    }
    
    public TreeNode createBSTFromSortedArr(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode contempraryRoot = new TreeNode(arr[mid]);
        contempraryRoot.left = createBSTFromSortedArr(arr, start, mid -1);
        contempraryRoot.right = createBSTFromSortedArr(arr, mid+1, end);
        
        return contempraryRoot;
    }
    
   public boolean isBalanced(TreeNode root) {
       return checkHeight(root) != Integer.MIN_VALUE;
   }
   
   public int checkHeight(TreeNode root) {
       if(root ==null) return -1;
       
       int leftHeight = checkHeight(root.left);
       if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
       
       int rightHeight = checkHeight(root.right);
       if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
       
       
       int diff = Math.abs(leftHeight - rightHeight);
       if(diff > 1) {
           return Integer.MIN_VALUE;
       } else {
           return Math.max(leftHeight, rightHeight) + 1;
       }
   }
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        System.out.print(node.id);
        System.out.print( " "); 
        inorder(node.left);
        inorder(node.right);
    }
    public static void main(String args[]) { 
	  
	  int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	  CheckTreeBalanced bst = new CheckTreeBalanced();
	  TreeNode root = bst.createBSTFromSortedArr(arr);
	  bst.inorder(root);
	  System.out.println(bst.isBalanced(root));
	}
} 






















