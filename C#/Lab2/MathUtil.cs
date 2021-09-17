using System;

namespace Lab2
{
    public static class MathUtil
    {
        public static int Min(int a, int b)
        {
            // dumb slowpath for tests
            if (a - b < 0)
            {
                return a;
            }

            return b;
        }

        public static double MaxInMatrix(double[][] matrix)
        {
            ValidateMatrix(matrix);
            var max = double.MinValue;

            foreach (var row in matrix)
            {
                foreach (var element in row)
                {
                    if (element > max)
                    {
                        max = element;
                    }
                }
            }

            return max;
        }

        public static double MaxInMatrixOnSecondaryDiagonal(double[][] matrix)
        {
            ValidateMatrix(matrix);
            var max = double.MinValue;
            var size = matrix.Length;

            var rightBorder = size;
            for (var i = 0; i < size; i++)
            {
                for (var j = 0; j < rightBorder; j++)
                {
                    if (matrix[i][j] > max)
                    {
                        max = matrix[i][j];
                    }
                }

                rightBorder -= 1;
            }

            return max;
        }

        private static void ValidateMatrix(double[][] matrix)
        {
            if (matrix == null)
            {
                // throw new ArgumentNullException("array is null");
                throw new ArgumentNullException(nameof(matrix));
            }

            if (matrix.Length == 0)
            {
                throw new ArgumentException("no elements in array");
            }

            foreach (var row in matrix)
            {
                if (row == null)
                {
                    throw new ArgumentNullException("");
                }

                if (row.Length == 0)
                {
                    throw new ArgumentException("no elements in row");
                }
            }
        }
    }
}