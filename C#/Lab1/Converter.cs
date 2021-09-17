using System;

namespace Lab1
{
    public static class Converter
    {
        private static readonly char[] NumberCharacters =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        public static double ConvertStringFromBase(int numBase, string numString)
        {
            if (numBase is < 2 or > 16)
            {
                // throw new ArgumentOutOfRangeException("number base should be in range [2, 16]");
                throw new ArgumentOutOfRangeException(nameof(numBase));
            }

            numString = numString.ToUpper();
            var numStrings = numString.Split(".");
            if (numStrings.Length is < 1 or > 2)
            {
                throw new ArgumentException("Invalid number format");
            }

            string fractionNumberPartString = null;
            var intNumberPartString = StringUtil.Reverse(numStrings[0]);
            if (numStrings.Length == 2)
            {
                fractionNumberPartString = numStrings[1];
            }

            // Main algorithm starts here
            double intNumberPart = 0d, fractionNumberPart = 0d;
            char tempChar;
            int charIndex;

            for (var i = 0; i < intNumberPartString.Length; i++)
            {
                tempChar = intNumberPartString[i];
                charIndex = Array.IndexOf(NumberCharacters, tempChar);
                if (charIndex >= numBase)
                {
                    throw new ArgumentException("string contains invalid sign for current number base");
                }

                intNumberPart += Math.Pow(numBase, i) * charIndex;
            }

            if (fractionNumberPartString != null)
            {
                for (var i = 0; i < fractionNumberPartString.Length; i++)
                {
                    tempChar = fractionNumberPartString[i];
                    charIndex = Array.IndexOf(NumberCharacters, tempChar);
                    if (charIndex >= numBase)
                    {
                        throw new ArgumentException("string contains invalid sign for current number base");
                    }

                    fractionNumberPart += Math.Pow(numBase, -i - 1) * charIndex;
                }
            }

            return intNumberPart + fractionNumberPart;
        }
    }
}