using System;

namespace Lab1
{
    public static class StringUtil
    {
        public static string Reverse(string str)
        {
            var stringCharacters = str.ToCharArray();
            Array.Reverse(stringCharacters);
            return new string(stringCharacters);
        }
    }
}