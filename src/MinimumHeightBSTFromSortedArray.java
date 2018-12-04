import java.util.*;

class TreeNode {
    public int id;
    TreeNode left, right;
    public TreeNode(int nodeId) {
        this.id = nodeId;
    }
}


public class MinimumHeightBSTFromSortedArray
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
    
    public void preorder(TreeNode node) {
        if(node == null) return;
        preorder(node.left);
        System.out.print(node.id);
        System.out.print( " "); 
        preorder(node.right);
    }
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        System.out.print(node.id);
        System.out.print( " "); 
        inorder(node.left);
        inorder(node.right);
    }
    
    public void postorder(TreeNode node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.id);
        System.out.print( " "); 
    }
    public static void main(String args[]) { 
	  
	  int arr[] = {1,2,3,4,5,6,7,8,9};
	  MinimumHeightBSTFromSortedArray bst = new MinimumHeightBSTFromSortedArray();
	  TreeNode root = bst.createBSTFromSortedArr(arr);
	  bst.preorder(root);
	  System.out.println(); 
	  bst.inorder(root);
	  System.out.println();
	  bst.postorder(root);
	}
} 






















