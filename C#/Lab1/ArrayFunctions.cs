using System;

namespace Lab1
{
    public static class ArrayFunctions
    {
        public static double MultiplyOdd(double[] array)
        {
            ValidateArray(array);

            double accum = 1;
            for (var i = 0; i < array.Length; i += 2)
            {
                accum *= array[i];
            }

            return accum;
        }

        public static double[] ShiftArrayRight(int shiftValue, double[] array)
        {
            ValidateArray(array);

            if (shiftValue < 0)
            {
                throw new ArgumentException("can`t evaluate shift lower than zero");
            }

            if (shiftValue > array.Length)
            {
                // while (shiftValue > array.Length)
                // {
                //     shiftValue -= array.Length;
                // }
                shiftValue %= array.Length;
            }
            
            if (shiftValue == 0 || shiftValue == array.Length)
            {
                return array;
            }

            var newArray = new double[array.Length];
            for (var i = 0; i < array.Length; i++)
            {
                var index = (i + shiftValue) % array.Length;
                newArray[index] = array[i];
            }

            return newArray;
        }

        private static void ValidateArray(double[] array)
        {
            if (array == null)
            {
                // throw new ArgumentNullException("array is null");
                throw new ArgumentNullException(nameof(array));
            }

            if (array.Length == 0)
            {
                throw new ArgumentException("no elements in array");
            }
        }
    }
}