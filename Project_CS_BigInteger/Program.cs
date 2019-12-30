using System;
using System.Numerics;

namespace Project_CS
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length < 1)
            {
                prlong_msg_and_exit();
            }

            // 素因数分解したい値の指定
            BigInteger n = new BigInteger(0);
            try
            {
                n = BigInteger.Parse(args[0]);
            }
            catch (Exception e)
            {
                Console.WriteLine("new BigInteger(" + args[0] + ") ... error.");
                Console.WriteLine(e.ToString() + "\n");
                Environment.Exit(-1);
            }

            PrimeFactorization pf = new PrimeFactorization();
            pf.Main(n);
        }

        private static void prlong_msg_and_exit()
        {
            Console.WriteLine("\nUsage: dotnet run <number>");
            Environment.Exit(-1);
        }
    }
}
