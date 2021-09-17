using System.Collections.Generic;
using NUnit.Framework;

namespace Lab1
{
    public class ApplicationUnitTest
    {
        private List<ConverterTestData> _numberForConverting;

        [SetUp]
        public void Setup()
        {
            _numberForConverting = new List<ConverterTestData>
            {
                new("2d3A213.1ca", 16, 47424019.11181640625d),
                new("11011.1001", 2, 27.5625),
                new("3321.4", 5, 461.8),
                new("3321", 5, 461)
            };
        }

        [Test]
        public void ConverterTest()
        {
            foreach (var testData in _numberForConverting)
            {
                var result = Converter.ConvertStringFromBase(testData.strBase, testData.str);
                Assert.AreEqual(testData.expectedResult, result);
            }
        }

        [Test]
        public void MultiplyOddTest()
        {
            double[] array = {1.13, 32.31, 5.96, 42.42, -22.12, 72.53, 93.29};
            var result = ArrayFunctions.MultiplyOdd(array);
            Assert.AreEqual(-13897.76356304, result);
        }

        [Test]
        public void ShiftArrayRightTest()
        {
            double[] array = {1d, 2d, 3d, 4d, 5d};
            double[] expected = {3d, 4d, 5d, 1d, 2d};
            var result = ArrayFunctions.ShiftArrayRight(3, array);
            Assert.AreEqual(expected, result);
        }
    }

    public struct ConverterTestData
    {
        public string str;
        public int strBase;
        public double expectedResult;

        public ConverterTestData(string str, int strBase, double expectedResult)
        {
            this.str = str;
            this.strBase = strBase;
            this.expectedResult = expectedResult;
        }
    }
}