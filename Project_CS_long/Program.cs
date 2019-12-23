using System;

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
            long n;
            if (long.TryParse(args[0], out n) == false)
            {
                Console.WriteLine(args[0] + " in not numeric.");
                return;
            }

            n = long.Parse(args[0]);

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
