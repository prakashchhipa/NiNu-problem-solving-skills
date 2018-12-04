
public class ImageRotationImageRotation
{  
    
   public void rotateImageAnticlockwise(int[][] image) {
       if(image.length != image[0].length) return;
       int n = image.length;
       //for circle to approach
       for (int circle=0;circle<n/2 ;circle++ ) {
           int first = circle;
           int last = n - 1 - circle;
           //for movement
           for(int i=first;i<last;i++) {
               int offset = i - first;
               // keep top safe
               int top = image[first][i];
               //right to top
               image[first][i] = image[i][last];
               //down to right
               image[i][last] = image [last][last - offset];
               //left to down
               image[last][last - offset] = image[last - offset][first];
               //top to left
               image[last - offset][first] = top;
           }
       }
       printImage(image);
   }
   
   
   public void rotateImageClockwise(int[][] image) {
       if(image.length != image[0].length) return;
       int n = image.length;
       //for circle to approach
       for (int circle=0;circle<n/2 ;circle++ ) {
           int first = circle;
           int last = n - 1 - circle;
           //for movement
           for(int i=first;i<last;i++) {
               int offset = i - first;
               // keep top safe
               int top = image[first][i];
               //left to top
               image[first][i] = image[last - offset][first];
               //down to left
               image[last - offset][first] = image[last][last - offset];
               //right to down
               image[last][last - offset] = image[i][last];
               //top to left
               image[i][last] = top;
           }
       }
       printImage(image);
   }

   public void printImage(int[][] image) {
       for (int i=0;i<image.length;i++ ) {
           for(int j=0; j<image.length;j++) {
               System.out.print(image[i][j]+ " ");
           }
           System.out.println();
       } 
   }
   
       
    
    //Main program
    public static void main(String args[]) {
        ImageRotation image = new ImageRotation();
        int [][] img = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        image.printImage(img);
        System.out.println("Image Rotation Anti-clockwise: ");
        image.rotateImageAnticlockwise(img);
        System.out.println("Image Rotation Clockwise: ");
        int [][] img1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        image.rotateImageClockwise(img1);
    }
}

