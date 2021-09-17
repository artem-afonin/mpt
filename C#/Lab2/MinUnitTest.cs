using NUnit.Framework;

namespace Lab2
{
    public class MinUnitTest
    {
        // [SetUp]
        // public void Setup()
        // {
        // }

        [Test]
        public void ALowerThanBTest()
        {
            var a = 42;
            var b = 43;
            var result = MathUtil.Min(a, b);
            Assert.AreEqual(a, result);
        }
        
        [Test]
        public void AGreaterThanBTest()
        {
            var a = 45;
            var b = 43;
            var result = MathUtil.Min(a, b);
            Assert.AreEqual(b, result);
        }
    }
}