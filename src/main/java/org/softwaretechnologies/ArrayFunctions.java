package org.softwaretechnologies;

public final class ArrayFunctions {

    private ArrayFunctions() {
    }

    /**
     * Функция, меняющая порядок элементов в массиве array на обратный.
     * @param array массив, который будет перевернут.
     */

    public static void reverse(int[] array) {
        for( int i = 0; i <= array.length / 2; i++)
        {
           int o = array[i];
           array[i] = array[array.length - 1 - i];
           array[array.length - 1 - i] = o;
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
        if(matrix.length != matrix[0].length)
        {
            System.out.println("You are stupid!!!!!!");
        }
        int n = matrix.length;
        for(int i = 0; i <= n / 2; i++)
        {
            for (int j = 0; j <= n / 2; j++)
            {
                int o = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = o;
            }
        }
        // TODO: реализуйте вышеуказанную функцию

    }
}
