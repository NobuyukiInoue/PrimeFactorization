package PrimeFactorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import PrimeFactorization.SystemInformation.SystemInformation;

public class PrimeFactorization {
    public void Main(BigInteger n) {
        if (n.compareTo(new BigInteger("2")) <= 0) {
            System.out.println(n.toString() + " is not positive longeger.");
            return;
        }

        SystemInformation si = new SystemInformation();
        si.printProperties();

        System.out.println(n.toString() + " < pow(2, " + Long.toString(GetBitLength(n, 4097)) + ")");

        long start = System.currentTimeMillis();

        BigInteger[] result = trial_division(n);

        long end = System.currentTimeMillis();

        System.out.println("n = " + n.toString() + ", primes = [" + ArraylongToString(result) + "]");
        System.out.println("Answer Check : " + AnswerCheck(n, result));
        System.out.println("Execute time : " + (end - start)/1000.0 + "[s]\n");
    }

    private long GetBitLength(BigInteger n, long max) {
        for (int i = 1; i < max; i++) {
            if (n.compareTo(new BigInteger("2").pow(i)) <= 0) {
                return i;
            }
        }
        return -1;
    }

    private BigInteger[] trial_division(BigInteger n) {
        List<BigInteger> prime_list = new ArrayList<>();
        BigInteger max = n.sqrt().add(new BigInteger("1")) ;

        // 2 ‚ÅŠ„‚Á‚Ä‚¢‚­
        while (n.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0) {
            prime_list.add(new BigInteger("2"));
            n = n.divide(new BigInteger("2"));
        }

        // 3 ` Math.sqrt(n) ‚Ì”š‚ÅŠ„‚Á‚Ä‚¢‚­
        for (BigInteger i = new BigInteger("3"); i.compareTo(max) < 0; i = i.add(new BigInteger("2"))) {
            while (n.mod(i).compareTo(new BigInteger("0")) == 0) {
                prime_list.add(i);
                n = n.divide(i);
            }
        }

        if (n.compareTo(new BigInteger("1")) != 0) {
            prime_list.add(n);
        }

        // Long[] result = prime_list.toArray(new Long[prime_list.size()]);
        BigInteger[] result = new BigInteger[prime_list.size()];
        for (int i = 0; i < prime_list.size(); i++) {
            result[i] = prime_list.get(i);
        }
        return result;
    }

    private String ArraylongToString(BigInteger[] primes) {
        if (primes.length <= 0) {
            return "";
        }

        String resultStr = primes[0].toString();
        for (int i = 1; i < primes.length; i++) {
            resultStr += ", " + primes[i].toString();
            
        }

        return resultStr;
    }

    private String AnswerCheck(BigInteger n, BigInteger[] primes) {
        BigInteger answer = new BigInteger("1");

        for (BigInteger target : primes)
            answer = answer.multiply(target);

        if (answer.equals(n))
            return "OK";
        else
            return "NG";

    }
}
