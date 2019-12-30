using System;
using System.Collections.Generic;
using System.IO;

namespace Project_CS
{
    public class PrimeFactorization
    {
        public void Main(long n)
        {
            if (n < 2)
            {
                Console.WriteLine(n.ToString() + " is not positive longeger.");
                return;
            }

            SystemInformation si = new SystemInformation();
            si.PrintSystemInformation();

            Console.WriteLine(n.ToString() + " < pow(2, " + GetBitLength(n, 4097).ToString() + ")");

            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();

            long[] primes = trial_division(n);

            sw.Stop();

            Console.WriteLine("n = " + n.ToString() + ", primes = [" + ArraylongToString(primes) + "]");
            Console.WriteLine("Anser Check  : " + AnswerCheck(n, primes));
            Console.WriteLine("Execute time : " + (sw.ElapsedMilliseconds/1000.0).ToString() + "[s]\n");
        }

        private long GetBitLength(long N, long max)
        {
            for (long i = 1; i < max; i++)
            {
                if (N <= Math.Pow(2, i))
                {
                    return i;
                }
            }
            return -1;
        }

        private long[] trial_division(long n)
        {
            List<long> prime_list = new List<long>();
            long max = (long)(Math.Sqrt(n)) + 1;

            // 2 で割っていく
            while (n % 2 == 0) {
                prime_list.Add((long)2);
                n /= 2;
            }

            // 3 で割っていく
            while (n % 3 == 0) {
                prime_list.Add((long)3);
                n /= 3;
            }

            // 5 ～ Math.Sqrt(n) の数字で割っていく
            bool flag = true;
            for (long i = 5; i < max; ) {
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

        private String ArraylongToString(long[] primes)
        {
            if (primes.Length <= 0)
            {
                return "";
            }

            String resultStr = primes[0].ToString();
            for (long i = 1; i < primes.Length; i++)
            {
                resultStr += ", " + primes[i].ToString();
                
            }

            return resultStr;
        }

        private String AnswerCheck(long n, long[] primes)
        {
            long answer = 1;
            foreach (long target in primes)
                answer *= target;

            if (n == answer)
                return "OK";
            else
                return "NG";
        }
    }
}
