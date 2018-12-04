
public class NullifyMatrix
{  
    
    public void helperNullifyRow(int[][] mat, int rowNumber) {
        for(int i = 0; i<mat[0].length;i++)
            mat[rowNumber][i] = 0;
    }
    
    public void helperNullifyColumn(int[][] mat, int colNumber) {
        for(int i = 0; i<mat.length;i++)
            mat[i][colNumber] = 0;
    }
    
    //Approach one - using extra O(N + M) space for matrix size MxN
    public void nullifyMatrix(int[][] mat) {
        //extra space
        boolean rows[] = new boolean[mat[0].length];
        boolean columns[] = new boolean[mat.length];
        
        for (int i=0;i<mat.length ;i++ ) {
            for (int j=0; j<mat[0].length;j++ ) {
                if(mat[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            } 
        }
        
        //Nullify rows
        for(int i=0; i<rows.length; i++) {
            if(rows[i])
                helperNullifyRow(mat, i);
        }
        //Nullify columns
        for(int i=0; i<columns.length; i++) {
            if(columns[i])
                helperNullifyColumn(mat,i);
        }
        printMat(mat);
    }
    
     //Approach two - without using extra space for matrix size MxN, it uses first row & columns itself
    public void nullifyMatrixEfficient(int[][] mat) {
        boolean hasRow=false, hasCol=false;
        //checking first row and colmun about having any zero so later we can nullify it
        for (int i=0;i<mat[0].length;i++ ) {
            if(mat[0][i] == 0) {
                hasRow = true;
                break;
            }
        }
        for (int i=0;i<mat.length;i++ ) {
            if(mat[i][0] == 0) {
                hasCol = true;
                break;
            }
        }
        //checking zeros existance and marking their coresponding first row and col to zero
        for (int i=0;i<mat.length ;i++ ) {
            for (int j=0; j<mat[0].length;j++ ) {
                if(mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                }
            }
        }
        //nullify all columns with first element is zero
        for(int i=0; i<mat[0].length; i++) {
            if(mat[0][i] == 0)
                helperNullifyColumn(mat, i);
        }
        
        //nullify all rows with first element is zero
        for(int i=0; i<mat.length; i++) {
            if(mat[i][0] == 0)
                helperNullifyRow(mat, i);
        }
        printMat(mat);
    }
   
    public void printMat(int[][] image) {
         for (int i=0;i<image.length;i++ ) {
           for(int j=0; j<image.length;j++) {
               System.out.print(image[i][j]+ " ");
           }
           System.out.println();
         } 
    }   
  
       
    
    //Main program
    public static void main(String args[]) {
        NullifyMatrix matrix = new NullifyMatrix();
        int [][] mat = {{1,2,3,4}, {5,0,7,8}, {9,10,11,12},{13,14,15,16}};
        matrix.printMat(mat);
        System.out.println("Nullify Matrix: ");
        matrix.nullifyMatrix(mat);
        int [][] mat1 = {{1,2,3,4}, {5,0,7,8}, {9,10,11,12},{13,14,15,16}};
        matrix.nullifyMatrixEfficient(mat1);
    }
}