
public class StringCompression
{  
    
   public int helperEstimateCompressedStringLength(String str) {
       int cLen=0, cCount=0;
       for (int i=0;i<str.length();i++) {
           cCount++;
           if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1)) {
               cLen += 1 + String.valueOf(cCount).length();
               cCount = 0;
           }
       }
       return cLen;
   }

   public String compressString(String str) {
       int compressSize = helperEstimateCompressedStringLength(str);
       if(str.length() < compressSize) return str;
       
       int cCount=0;
       StringBuffer buffer = new StringBuffer(compressSize);
       for (int i=0;i<str.length();i++) {
           cCount++;
           if(i+1>= str.length() || str.charAt(i) != str.charAt(i+1)) {
               buffer.append(str.charAt(i));
               buffer.append(cCount);
               cCount = 0;
           }
       }
       return buffer.toString();
   }
       
    
    //Main program
    public static void main(String args[]) {
        StringCompression compression = new StringCompression();
        System.out.println("Compressed String(Either compressed or original based on size): " + compression.compressString("prraaakaaashhhhhh"));
        System.out.println("Compressed String(Either compressed or original based on size): " + compression.compressString("prakash"));
    }
}

