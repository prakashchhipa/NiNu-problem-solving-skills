import java.util.*;

class TreeNode {
    public int id, size = 1;
    public TreeNode left, right, parent;
    public TreeNode(int id) {
        this.id = id;
        this.size = 1;
    }
    
    
    public void insert(int data) {
        if (data <= this.id) {
            if(left == null) {
                left = new TreeNode(data);
            } else {
                left.insert(data);
            }
        } else {
            if(right == null) {
                right = new TreeNode(data);
            } else {
                right.insert(data);
            }
        }
        this.size = this.size + 1;
    }
    
    public TreeNode find(int data) {
        if(data == this.id) return this;
        else if (data <= this.id)
            return this.left != null ? left.find(data): null;
        else if(data > this.id)
            return this.right != null ? right.find(data): null;
        return null;
    }
    
    /*Specialized method for which Tree class has been written fro scratch*/
    public TreeNode getRandomTreeNode() {
        int rightSize = this.right != null ? this.right.size : 0;
        Random random = new Random();
        int idx = random.nextInt(this.size);
        if(idx > rightSize) {
            return right.getRandomTreeNode();
        }
        else if(idx == rightSize) {
            return this;
        } else {
            return left.getRandomTreeNode();
        }
    }
    
    public void inorder (TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.id);
        System.out.print(" ");
        inorder(root.right);
    }
}

public class CustomTree {

    

    public static void main (String[] args) {
        
        CustomTree tree = new CustomTree();
        
        TreeNode root = new TreeNode(10);
        root.insert(5);
        root.insert(15);  
        root.insert(2);
        root.insert(7);
        root.insert(13);
        root.insert(17);
        
        root.inorder(root);
        System.out.println();
        root.insert(40);
        root.inorder(root);
        System.out.println();
        System.out.println(root.getRandomTreeNode().id);
        System.out.println(root.getRandomTreeNode().id);
    }
    
}