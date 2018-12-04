import java.util.*;

class TreeNode {
    public int id;
    TreeNode left, right;
    public TreeNode(int nodeId) {
        this.id = nodeId;
    }
}


public class DepthListsOfTree
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
    
    public ArrayList<LinkedList<TreeNode>> createLevelLists(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        return createLevelLists(root, lists, 0);
    }
    
    public ArrayList<LinkedList<TreeNode>> createLevelLists(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level ) {
        
        if(root == null) return lists;
        LinkedList<TreeNode> list = null;
        if(lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLists(root.left, lists, level + 1);
        createLevelLists(root.right, lists, level + 1);
        return lists;
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
	  DepthListsOfTree bst = new DepthListsOfTree();
	  TreeNode root = bst.createBSTFromSortedArr(arr);
	  bst.inorder(root);
	  System.out.println();
	  ArrayList<LinkedList<TreeNode>> lists = bst.createLevelLists(root);
	  for(LinkedList<TreeNode> list : lists) {
	      for(TreeNode node : list) {
	          System.out.print(node.id);
	          System.out.print(" ");
	      }
	      System.out.println();
	  }
	}
} 






















