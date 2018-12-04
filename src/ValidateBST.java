import java.util.*;

class TreeNode {
    public int id;
    TreeNode left, right;
    public TreeNode(int nodeId) {
        this.id = nodeId;
    }
}


public class ValidateBST
{ 
    
    static Boolean flagship;  
    
    
    public boolean checkBSTMinMax(TreeNode root) {
        //return checkBSTMinMax(TreeNode root, min, max);
        return checkBSTMinMax(root, 0, 0);
        
    }
    
    public boolean checkBSTMinMax(TreeNode root, int min, int max) {
        if(root == null) return true;
        
        //root.id < min, root.id > max
        if((min !=0 && root.id <= min) || (max != 0 && root.id > max))
            return false;
        //recurse
        if(!(checkBSTMinMax(root.left, min, root.id)) || !(checkBSTMinMax(root.right, root.id, max)))
            return false;
        return true;
    }
    
    //This method has limitation of not able to handle for duplicates
    public int checkBST(TreeNode node) {
        
        if(node.left == null && node.right == null) return node.id;
        
        int left = Integer.MIN_VALUE;
        if(node.left != null)
            left = checkBST(node.left);
        
        int right = Integer.MAX_VALUE;
        if(node.right != null)
            right = checkBST(node.right);
        
        if(!(left <= node.id && node.id < right)) {
             ValidateBST.flagship = false;
        } 
        
        return node.id;
    }
    
    
    
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.id);
        System.out.print( " "); 
        inorder(node.right);
    }
    public static void main(String args[]) { 
	  
	 /* int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	  CheckTreeBalanced bst = new CheckTreeBalanced();
	  TreeNode root = bst.createBSTFromSortedArr(arr);
	  bst.inorder(root);
	  System.out.println(bst.isBalanced(root));*/
	  ValidateBST bst = new ValidateBST();
	  TreeNode root = new TreeNode(20);
	  root.left = new TreeNode(10);
	  root.right = new TreeNode(30);
	  root.left.left = new TreeNode(5);
	  root.left.right = new TreeNode(15);
	  root.left.right.right = new TreeNode(17);
	  root.left.left.left = new TreeNode(3);
	  root.left.left.right = new TreeNode(7);
	  
	  //bst.inorder(root);
	  
	  //ValidateBST.flagship = new Boolean(true);
	 // bst.checkBST(root);
//	  System.out.print("Is BST: ");
//	  System.out.println(ValidateBST.flagship);
	  
	  System.out.print("Is BST(Min-Max Approach): ");
	  System.out.println(bst.checkBSTMinMax(root));
	  
	}
} 






















