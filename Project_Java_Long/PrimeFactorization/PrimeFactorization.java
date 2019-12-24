package PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

import PrimeFactorization.SystemInformation.SystemInformation;

public class PrimeFactorization {
    public void Main(long n) {
        if (n < 2) {
            System.out.println(Long.toString(n) + " is not positive longeger.");
            return;
        }

        SystemInformation si = new SystemInformation();
        si.printProrties();

        System.out.println(Long.toString(n) + " < pow(2, " + Long.toString(GetBitLength(n, 4097)) + ")");

        long start = System.currentTimeMillis();

        long[] result = trial_division(n);

        long end = System.currentTimeMillis();

        System.out.println("n = " + Long.toString(n) + ", primes = [" + ArraylongToString(result) + "]");
        System.out.println("Execute time : " + (end - start)/1000.0 + "[s]\n");
    }

    private long GetBitLength(long N, long max) {
        for (long i = 1; i < max; i++) {
            if (N <= Math.pow(2, i)) {
                return i;
            }
        }
        return -1;
    }

    private long[] trial_division(long n) {
        List<Long> prime_list = new ArrayList<>();
        long max = (long)(Math.sqrt(n)) + 1;
        for (long i = 2; i < max; i++) {
            while (n % i == 0) {
                n /= i;
                prime_list.add(i);
            }
        }

        if (n != 1) {
            prime_list.add(n);
        }

        // Long[] result = prime_list.toArray(new Long[prime_list.size()]);
        long[] result = new long[prime_list.size()];
        for (int i = 0; i < prime_list.size(); i++) {
            result[i] = prime_list.get(i);
        }
        return result;
    }

    private String ArraylongToString(long[] primes) {
        if (primes.length <= 0) {
            return "";
        }

        String resultStr = Long.toString(primes[0]);
        for (int i = 1; i < primes.length; i++) {
            resultStr += ", " + Long.toString(primes[i]);
            
        }

        return resultStr;
    }
}
