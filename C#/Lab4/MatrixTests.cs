using System;
using System.Collections.Generic;
using NUnit.Framework;

namespace Lab4
{
    public class MatrixTests
    {
        private Matrix firstMatrix;
        private Matrix secondMatrix;
        private Matrix thirdMatrix;

        [SetUp]
        public void Setup()
        {
            firstMatrix = new Matrix(2, 3);
            secondMatrix = new Matrix(firstMatrix.Rows, firstMatrix.Columns);
            thirdMatrix = new Matrix(3, 1);

            for (var i = 0; i < firstMatrix.Rows; i++)
            for (var j = 0; j < firstMatrix.Columns; j++)
            {
                firstMatrix[i, j] = 3 * i + j;
                secondMatrix[i, j] = 2 * i * j;
            }

            for (var i = 0; i < thirdMatrix.Rows; i++)
            for (var j = 0; j < thirdMatrix.Columns; j++)
                thirdMatrix[i, j] = 4 * (i - j);
        }

        [Test]
        public void InitializerTest()
        {
            Assert.Throws<ArgumentOutOfRangeException>(delegate { new Matrix(-1, 4); });
            Assert.Throws<ArgumentOutOfRangeException>(delegate { new Matrix(4, -1); });
            Assert.DoesNotThrow(delegate { new Matrix(4, 4); });
        }

        [Test]
        public void AddTest()
        {
            Assert.Throws<ArgumentException>(delegate
            {
                var _ = firstMatrix + thirdMatrix;
            });

            Assert.Throws<ArgumentException>(delegate
            {
                var _ = thirdMatrix + secondMatrix;
            });

            var expected = new Matrix(2, 3)
            {
                [0, 0] = 0, [0, 1] = 1, [0, 2] = 2,
                [1, 0] = 3, [1, 1] = 6, [1, 2] = 9
            };

            Assert.AreEqual(expected, firstMatrix + secondMatrix);
            Assert.AreEqual(expected, secondMatrix + firstMatrix);
        }

        [Test]
        public void SubtractTest()
        {
            Assert.Throws<ArgumentException>(delegate
            {
                var _ = firstMatrix - thirdMatrix;
            });

            Assert.Throws<ArgumentException>(delegate
            {
                var _ = thirdMatrix - secondMatrix;
            });

            var expected = new Matrix(2, 3)
            {
                [0, 0] = 0, [0, 1] = 1, [0, 2] = 2,
                [1, 0] = 3, [1, 1] = 2, [1, 2] = 1
            };
            Assert.AreEqual(expected, firstMatrix - secondMatrix);

            expected = new Matrix(2, 3)
            {
                [0, 0] = 0, [0, 1] = -1, [0, 2] = -2,
                [1, 0] = -3, [1, 1] = -2, [1, 2] = -1
            };
            Assert.AreEqual(expected, secondMatrix - firstMatrix);
        }

        [Test]
        public void MultiplyTest()
        {
            Assert.Throws<ArgumentException>(delegate
            {
                var _ = firstMatrix * secondMatrix;
            });

            Assert.Throws<ArgumentException>(delegate
            {
                var _ = secondMatrix * firstMatrix;
            });

            var expected = new Matrix(2, 1)
            {
                [0, 0] = 20,
                [1, 0] = 56
            };
            Assert.AreEqual(expected, firstMatrix * thirdMatrix);
        }

        [Test]
        public void TransposeTest()
        {
            var expected = new Matrix(3, 2)
            {
                [0, 0] = 0, [0, 1] = 3,
                [1, 0] = 1, [1, 1] = 4,
                [2, 0] = 2, [2, 1] = 5
            };
            Assert.AreEqual(expected, firstMatrix.Transpose());

            expected = new Matrix(3, 2)
            {
                [0, 0] = 0, [0, 1] = 0,
                [1, 0] = 0, [1, 1] = 2,
                [2, 0] = 0, [2, 1] = 4
            };
            Assert.AreEqual(expected, secondMatrix.Transpose());

            expected = new Matrix(1, 3)
            {
                [0, 0] = 0, [0, 1] = 4, [0, 2] = 8
            };
            Assert.AreEqual(expected, thirdMatrix.Transpose());
        }

        [Test]
        public void MinTest()
        {
            var expected = 0;
            Assert.AreEqual(expected, firstMatrix.Min());
            Assert.AreEqual(expected, secondMatrix.Min());
            Assert.AreEqual(expected, thirdMatrix.Min());
        }

        [Test]
        public void ToStringTest()
        {
            var expected = "[ 0, 1, 2 ]\n" +
                           "[ 3, 4, 5 ]\n";
            Assert.AreEqual(expected, firstMatrix.ToString());
        }
    }

    internal class MatricesComparer : IEqualityComparer<Matrix>
    {
        public bool Equals(Matrix? self, Matrix? other)
        {
            return self == other;
        }

        public int GetHashCode(Matrix obj)
        {
            throw new NotImplementedException();
        }
    }
}