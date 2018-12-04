import java.util.Arrays;

public class UniqueCharactersInString // assume it has only ascii characters
{ 
    //method - O(n) but using O(asscii) extra space
    boolean checkUniqueness(String str) {
        //bigger than ascii set (note extended ascii)
        if(str.length() > 128) return false;
        boolean check [] = new boolean[128];
        for (int i=0; i<str.length();i++) {
            int val = str.charAt(i) - 'a';
            if (check[val])
                return false;
            check[val] = true;
        } 
        return true;
    }
    
     //Efficient method - O(n) but using O(int) extra space
    boolean checkUniquenessEfficient(String str) {
        //bigger than ascii set (note extended ascii)
        if(str.length() > 128) return false;
        
        int bitCheck =0;
        for (int i=0; i<str.length();i++) {
            int val = str.charAt(i) - 'a';
            if((bitCheck & (1 << val)) > 0)
                return false;
            bitCheck = bitCheck | (1 << val);
        } 
        return true;
    }
    
    
    //Main program
    public static void main(String args[]) {
        UniqueCharactersInString unique = new UniqueCharactersInString();
        System.out.println("Unique characters in string(ascii set space): " + unique.checkUniqueness("abcdefghijklmnopqrstuvwxyz"));
        System.out.println("Unique characters in string(int extra space): " + unique.checkUniquenessEfficient("abcdefghijklmnopqrastuvwxyz"));
    }
}