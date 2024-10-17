package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }

    /**
     * Функция, меняющая порядок элементов в массиве array на обратный.
     * @param array массив, который будет перевернут.
     */

    public static void reverse(int[] array) {
        int l = array.length;
        for( int i = 0; i < l / 2; i++)
        {
           int o = array[i];
           array[i] = array[l - 1 - i];
           array[l - 1 - i] = o;
        }
        // TODO: реализуйте вышеуказанную функцию

    }

    /**
     * Функция, заменяющая строки матрицы на столбцы матрицы. Пример:
       1  2  3     1  4  7
       4  5  6     2  5  8
       7  8  9     3  6  9
     * Функция работает только с квадратными матрицами.
     * Если матрица не квадратная, то выведете на экран сообщение:
       Матрица не квадратная
     * @param matrix матрица, в которой столбцы будут заменены на строки.
     */
    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(n != m)
        {
            System.out.println("You are stupid!!!!!!");
        }
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int o = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = o;
            }
        }
        // TODO: реализуйте вышеуказанную функцию

    }
}
