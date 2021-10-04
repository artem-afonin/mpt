using System;
using System.IO;

namespace Lab4
{
    public class Matrix
    {
        private readonly int[,] _matrix;
        public int Rows { get; }
        public int Columns { get; }

        public Matrix(int rows, int columns)
        {
            if (rows <= 0)
                throw new ArgumentOutOfRangeException($"{rows} is incorrect rows count");

            if (columns <= 0)
                throw new ArgumentOutOfRangeException($"{columns} is incorrect columns count");

            Rows = rows;
            Columns = columns;
            _matrix = new int[rows, columns];
        }

        public Matrix Transpose()
        {
            var result = new Matrix(Columns, Rows);

            for (var i = 0; i < Rows; i++)
            for (var j = 0; j < Columns; j++)
                result[j, i] = _matrix[i, j];

            return result;
        }

        public int Min()
        {
            var min = int.MaxValue;

            for (var i = 0; i < Rows; i++)
            for (var j = 0; j < Columns; j++)
                if (_matrix[i, j] < min)
                    min = _matrix[i, j];

            return min;
        }

        public int this[int row, int column]
        {
            get
            {
                if (row < 0 || row >= Rows)
                    throw new ArgumentOutOfRangeException($"first index {row} is out of range");

                if (column < 0 || column >= Columns)
                    throw new ArgumentOutOfRangeException($"second index {row} is out of range");

                return _matrix[row, column];
            }
            set
            {
                if (row < 0 || row >= Rows)
                    throw new ArgumentOutOfRangeException($"first index {row} is out of range");

                if (column < 0 || column >= Columns)
                    throw new ArgumentOutOfRangeException($"second index {row} is out of range");

                _matrix[row, column] = value;
            }
        }

        public static Matrix operator +(Matrix self, Matrix other)
        {
            if (self.Rows != other.Rows || self.Columns != other.Columns)
                throw new ArgumentException("Matrices should have same rows and columns count");

            var result = new Matrix(self.Rows, self.Columns);
            for (var i = 0; i < self.Rows; i++)
            for (var j = 0; j < self.Columns; j++)
                result[i, j] = self._matrix[i, j] + other._matrix[i, j];
            return result;
        }

        public static Matrix operator -(Matrix self, Matrix other)
        {
            if (self.Rows != other.Rows || self.Columns != other.Columns)
                throw new ArgumentException("Matrices should have same rows and columns count");

            var result = new Matrix(self.Rows, self.Columns);
            for (var i = 0; i < self.Rows; i++)
            for (var j = 0; j < self.Columns; j++)
                result[i, j] = self._matrix[i, j] - other._matrix[i, j];
            return result;
        }

        public static Matrix operator *(Matrix self, Matrix other)
        {
            if (self.Columns != other.Rows)
                throw new ArgumentException("Can not multiple matrices of such sizes");

            var result = new Matrix(self.Rows, other.Columns);

            for (var i = 0; i < self.Rows; i++)
            for (var j = 0; j < other.Columns; j++)
            for (var k = 0; k < other.Rows; k++)
                result[i, j] += self[i, k] * other[k, j];

            return result;
        }

        public static bool operator ==(Matrix? self, Matrix? other)
        {
            if (self is null || other is null)
                throw new ArgumentNullException();

            if (self.Rows != other.Rows || self.Columns != other.Columns)
                throw new ArgumentException("Matrices should have same rows and columns count");

            for (var i = 0; i < self.Rows; i++)
            for (var j = 0; j < self.Columns; j++)
                if (self[i, j] != other[i, j])
                    return false;
            return true;
        }

        public static bool operator !=(Matrix self, Matrix other)
        {
            return !(self == other);
        }

        public override bool Equals(object? other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            if (other.GetType() != typeof(Matrix)) return false;
            return this == (Matrix) other;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(_matrix, Rows, Columns);
        }

        public override string ToString()
        {
            using (var stringWriter = new StringWriter())
            {
                var oldWriter = Console.Out;
                Console.SetOut(stringWriter);

                for (var i = 0; i < Rows; i++)
                {
                    Console.Write("[ ");
                    Console.Write(_matrix[i, 0]);
                    for (var j = 1; j < Columns; j++)
                    {
                        Console.Write(", ");
                        Console.Write(_matrix[i, j]);
                    }

                    Console.WriteLine(" ]");
                }

                oldWriter.Flush();
                var resultString = stringWriter.ToString();
                Console.SetOut(oldWriter);

                return resultString;
            }
        }
    }
}