import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {
    public void Main(long n) {
        if (n < 2) {
            System.out.println(Long.toString(n) + " is not positive longeger.");
            return;
        }

        System.out.println(Long.toString(n) + " < pow(2, " + Long.toString(GetBitLength(n, 4097)) + ")");

        long start = System.currentTimeMillis();

        Long[] result = trial_division(n);

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

    private Long[] trial_division(long n) {
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

        Long[] result = prime_list.toArray(new Long[prime_list.size()]);
        return result;
    }

    private String ArraylongToString(Long[] primes) {
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
