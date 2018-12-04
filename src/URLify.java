import java.lang.*;
public class URLify // replace white space by 20%
{ 
    //string manulupation always approach from backwards iteration
    public String createURL(String str) {
        char [] charr = str.toCharArray();
        //count whitesdpace
        int wsCount =0;
        for (int i=0;i<str.length() ;i++ ) {
            if(charr[i] == ' ') wsCount = wsCount + 1;
        } 
        int index = str.length() + 2*wsCount - 1;
        char [] arr = new char[index + 1];
        for(int i = str.length() - 1; i>=0;i--) {
            if(charr[i] == ' ') {
                arr[index] = '%';
                arr[index -1] = '0';
                arr[index -2] = '2';
                index -= 3;
            } else {
                arr[index] = charr[i];
                index -= 1;
            }
        }
        return new String(arr);
    }
    
    
    
    //Main program
    public static void main(String args[]) {
        URLify url = new URLify();
        System.out.println("URL: " + url.createURL("aa bb b  c v g "));
        
    }
}