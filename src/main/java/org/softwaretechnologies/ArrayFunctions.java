package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }



    public static void reverse(int[] array) {
        int l = array.length;
        for( int i = 0; i < l / 2; i++)
        {
           int o = array[i];
           array[i] = array[l - 1 - i];
           array[l - 1 - i] = o;
        }

    }


    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(n != m)
        {
            System.out.println("You are stupid!!!!!!");
            return;
        }
        for(int i = 0; i < m; i++)
        {
            for (int j = i + 1; j < m; j++)
            {
                int o = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = o;
            }
        }


    }
}
