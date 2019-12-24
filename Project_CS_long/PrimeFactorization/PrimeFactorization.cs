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

            long[] result = trial_division(n);

            sw.Stop();

            Console.WriteLine("n = " + n.ToString() + ", primes = [" + ArraylongToString(result) + "]");
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
            for (long i = 2; i < max; i++) {
                while (n % i == 0) {
                    n /= i;
                    prime_list.Add(i);
                }
            }

            if (n != 1) {
                prime_list.Add(n);
            }

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
    }
}
