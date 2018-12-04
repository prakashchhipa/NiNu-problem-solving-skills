import java.util.*;

class TreeNode {
    public int id;
    public TreeNode left, right, parent;
    public TreeNode(int id) {
        this.id = id;
    }
}

public class CheckSubTree {

    public static TreeNode root, subroot = null;
    
    public boolean containsTree(TreeNode root, TreeNode child) {
        if(child == null) return true;
        return checkSubTree(root, child);
    }
    
    public boolean checkSubTree(TreeNode root, TreeNode child) {
        if(root == null) return false;
        
        if(root.id == child.id && matchTree(root, child))
            return true;
        
        return (checkSubTree(root.left, child) || checkSubTree(root.right, child));
    }
    
    public boolean matchTree(TreeNode root, TreeNode child) {
        if(root == null && child == null) return true;
        else if(root == null || child == null) return false;
        else if(root.id != child.id) return false;
        else return matchTree(root.left, child.left) && matchTree(root.right, child.right);
    }
    
    
    public boolean isSubTree(TreeNode node, TreeNode sub) {
        if(node == null) return false;
        if(sub == null) return true;
        ArrayList<Integer> nodeList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        preorderStore(node, nodeList);
        preorderStore(sub, subList);
        for(Integer id : nodeList) {
            System.out.print(id);
            System.out.print(" ");
        }
        System.out.println(" ");
        for(Integer id : subList) {
            System.out.print(id);
            System.out.print(" ");
        }
        System.out.println(" ");
        return isSubList(nodeList, subList);
    }
    
    public void preorderStore(TreeNode root, ArrayList<Integer> list) {
        if(root == null)  {
            list.add(0);
            return;
        }
        list.add(root.id);
     //   System.out.print(root.id);
       // System.out.print(" ");
        preorderStore(root.left, list);
        preorderStore(root.right, list);
    }

    public boolean isSubList(ArrayList<Integer> parent, ArrayList<Integer> child) {
        if(parent.size() == 0) return false;
        if(child.size() == 0 ) return true;

        int[] arr = new int[parent.size()];
        int len=0;
        for(int i=0; i < parent.size() - child.size() + 1;i++) {
           if (child.get(0) == parent.get(i))
                arr[len++] = i;
        }
        
        for(int i = 0; i < len; i++) {
            int k = arr[i];
            boolean flag = false;
            for(int j =0; j< child.size();j++) {
                if(parent.get(k++).intValue() != child.get(j).intValue()) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return true;
        }
        
        return false;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.id);
        System.out.print(" ");
        inorder(root.right);
    }
    
    
    public static void main(String[] args) {
            
            root = new TreeNode(20);
            
            /*Left substree*/
            root.left = new TreeNode(10);
            root.left.parent = root;
            
            root.left.left = new TreeNode(5);
            root.left.left.parent = root.left;
            
            root.left.right = new TreeNode(15);
            root.left.right.parent  = root.left;
            
            root.left.left.left = new TreeNode(3);
            root.left.left.left.parent =  root.left.left;
            
            root.left.left.right = new TreeNode(7);
            root.left.left.right.parent = root.left.left;
            
            root.left.right.right = new TreeNode(17);
            root.left.right.right.parent = root.left.right;
            
            /*Right subtree*/
            root.right = new TreeNode(30);
            root.right.parent = root;
            
            root.right.left = new TreeNode(28);
            root.right.left.parent = root.right;
            
            root.right.left.left = new TreeNode(26);
            root.right.left.left.parent = root.right.left;
            
            root.right.left.left.left = new TreeNode(22);
            root.right.left.left.left.parent = root.right.left.left;
            
            root.right.right = new TreeNode(40);
            root.right.right.parent = root.right;
            
            root.right.right.right = new TreeNode(50);
            root.right.right.right.parent = root.right.right;


            subroot = new TreeNode(20);
            
            /*Left substree*/
            subroot.left = new TreeNode(10);
            subroot.left.parent = root;
            
            subroot.left.left = new TreeNode(5);
            subroot.left.left.parent = root.left;
            
            subroot.left.right = new TreeNode(15);
            subroot.left.right.parent = root.left;
            
            subroot.left.left.left = new TreeNode(3);
            subroot.left.left.left.parent =  root.left.left;
            
            subroot.left.left.right = new TreeNode(7);
            subroot.left.left.right.parent = root.left.left;
            
            subroot.left.right.right = new TreeNode(17);
            subroot.left.right.right.parent = root.left.right;
            
            
            /*Right subtree*/
            subroot.right = new TreeNode(30);
            subroot.right.parent = root;
            
            subroot.right.left = new TreeNode(28);
            subroot.right.left.parent = root.right;
            
            subroot.right.left.left = new TreeNode(26);
            subroot.right.left.left.parent = root.right.left;
            
            subroot.right.left.left.left = new TreeNode(22);
            subroot.right.left.left.left.parent = root.right.left.left;
            
            subroot.right.right = new TreeNode(40);
            subroot.right.right.parent = root.right;
            
            subroot.right.right.right = new TreeNode(50);
            subroot.right.right.right.parent = root.right.right;

            CheckSubTree bst = new CheckSubTree();
            
           
            System.out.println(bst.isSubTree(root, subroot));
            System.out.println(bst.containsTree(root, subroot));
            
    }
}