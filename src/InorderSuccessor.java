import java.util.*;

class TreeNode {
    public int id;
    TreeNode parent, left, right;
    public TreeNode(int nodeId) {
        this.id = nodeId;
    }
}


public class InorderSuccessor
{ 
    
    public TreeNode findInorderSuccessor(TreeNode root) {
        if(root == null) return null;
        
        TreeNode temp = null;
        /*having right tree then retireve left most child of it.*/
        if(root.right != null) {
             temp= root.right;
            while(temp.left !=null)
                temp = temp.left;
        } else /*No right sub tree then retrieve top most parent being right child*/ {
            if(root.parent == null) 
                return root;
            temp = root;
            TreeNode tempParent = root.parent;
            while(tempParent != null && tempParent.right == temp) {
                temp = tempParent;
                tempParent = tempParent.parent;
            }
        }
        return temp;
    }
    
    
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.id);
        System.out.print( " "); 
        inorder(node.right);
    }
    public static void main(String args[]) { 
	  
	
	  InorderSuccessor bst = new InorderSuccessor();
	  TreeNode root = new TreeNode(20);
	  root.left = new TreeNode(10);
	  root.left.parent = root;
	  root.right = new TreeNode(30);
	  root.right.parent = root;
	  root.left.left = new TreeNode(5);
	  root.left.left.parent = root.left;
	  root.left.right = new TreeNode(15);
	  root.left.right.parent = root.left;
	  root.left.right.right = new TreeNode(17);
	  root.left.right.right.parent = root.left.right;
	  root.left.left.left = new TreeNode(3);
	  root.left.left.left.parent = root.left.left;
	  root.left.left.right = new TreeNode(7);
	  root.left.left.right.parent = root.left.left;
	  
	  root.right.left = new TreeNode(26);
	  root.right.left.parent = root.right;
	  root.right.left.left = new TreeNode(24);
	  root.right.left.left.parent = root.right.left;
	  root.right.left.left.left = new TreeNode(22);
	  root.right.left.left.left.parent =  root.right.left.left;
	  
	  bst.inorder(root);
	  //System.out.print("Is BST(Min-Max Approach): ");
	 // System.out.println(bst.checkBSTMinMax(root));
	 TreeNode inordersucc =  bst.findInorderSuccessor(root);
	 System.out.print("Inorder Successor of Root: ");
	 System.out.println(inordersucc.id);
	}
}