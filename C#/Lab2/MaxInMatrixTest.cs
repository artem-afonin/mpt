using System.Collections.Generic;
using NUnit.Framework;

namespace Lab2
{
    public class MaxInMatrixTest
    {
        [Test]
        public void DefaultMaxInMatrixTest()
        {
            var matrix = new[]
            {
                new double[] {2d, 1d, 42d},
                new double[] {1d, 3d, 2d},
                new double[] {8d, 255d, -2d}
            };
            var result = MathUtil.MaxInMatrix(matrix);
            Assert.AreEqual(255d, result);
        }

        [Test]
        public void MaxInMatrixOnSecondaryDiagonalOnTopTest()
        {
            var matrix = new[]
            {
                new double[] {2d, 1d, 42d},
                new double[] {1d, 3d, 2d},
                new double[] {8d, 255d, -2d}
            };
            var result = MathUtil.MaxInMatrixOnSecondaryDiagonal(matrix);
            Assert.AreEqual(42d, result);
        }

        [Test]
        public void MaxInMatrixOnSecondaryDiagonalOnDiagonalTest()
        {
            var matrix = new[]
            {
                new double[] {2d, 1d, 3d},
                new double[] {1d, 42d, 2d},
                new double[] {8d, 255d, -2d}
            };
            var result = MathUtil.MaxInMatrixOnSecondaryDiagonal(matrix);
            Assert.AreEqual(42d, result);
        }
    }
}