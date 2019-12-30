using System;
using System.Collections.Generic;
using System.IO;
using System.Numerics;

namespace Project_CS
{
    public class PrimeFactorization
    {
        public void Main(BigInteger n)
        {
            if (n < 2)
            {
                Console.WriteLine(n.ToString() + " is not positive BigInteger.");
                return;
            }

            SystemInformation si = new SystemInformation();
            si.PrintSystemInformation();

            Console.WriteLine(n.ToString() + " < pow(2, " + GetBitLength(n, 4097).ToString() + ")");

            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();

            BigInteger[] primes = trial_division(n);

            sw.Stop();

            Console.WriteLine("n = " + n.ToString() + ", primes = [" + ArrayBigIntegerToString(primes) + "]");
            Console.WriteLine("Anser Check  : " + AnswerCheck(n, primes));
            Console.WriteLine("Execute time : " + (sw.ElapsedMilliseconds/1000.0).ToString() + "[s]\n");
        }

        private BigInteger GetBitLength(BigInteger N, int max)
        {
            BigInteger num2 = new BigInteger(2);
            for (int i = 1; i < max; i++)
            {
                if (N <= BigInteger.Pow(num2, i))
                {
                    return i;
                }
            }
            return -1;
        }

        public BigInteger MySqrt(BigInteger x)
        {
            if (x == 0)
                return 0;
            BigInteger left = new BigInteger(1);
            BigInteger right = x;
            BigInteger ans = new BigInteger(0);
            while (left <= right) {
                BigInteger mid = left + (right - left) / 2;
                if (mid <= x / mid) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
        
        private BigInteger[] trial_division(BigInteger n)
        {
            List<BigInteger> prime_list = new List<BigInteger>();
            BigInteger max = MySqrt(n) + 1;

            // 2 で割っていく
            while (n % 2 == 0) {
                prime_list.Add((BigInteger)2);
                n /= 2;
            }

            // 3 で割っていく
            while (n % 3 == 0) {
                prime_list.Add((BigInteger)3);
                n /= 3;
            }

            // 5 ～ Math.Sqrt(n) の数字で割っていく
            bool flag = true;
            for (BigInteger i = 5; i < max; ) {
                while (n % i == 0) {
                    prime_list.Add(i);
                    n /= i;
                    if (n == 1)
                        return prime_list.ToArray();
                }

                if (flag)
                    i += 2;
                else
                    i += 4;

                flag = !flag;
            }

            if (n != 1)
                prime_list.Add(n);

            return prime_list.ToArray();
        }

        private String ArrayBigIntegerToString(BigInteger[] primes)
        {
            if (primes.Length <= 0)
            {
                return "";
            }

            String resultStr = primes[0].ToString();
            for (int i = 1; i < primes.Length; i++)
            {
                resultStr += ", " + primes[i].ToString();
                
            }

            return resultStr;
        }

        private String AnswerCheck(BigInteger n, BigInteger[] primes)
        {
            BigInteger answer = 1;
            foreach (BigInteger target in primes)
                answer *= target;

            if (n == answer)
                return "OK";
            else
                return "NG";
        }
    }
}
