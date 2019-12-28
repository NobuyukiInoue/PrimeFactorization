package PrimeFactorization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

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

        BigInteger[] result = trial_division_by_rho(n);

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

    static BigInteger rho(BigInteger n){
        BigInteger i = new BigInteger("1");
        BigInteger x = new BigInteger(n.bitLength(),new Random());
        BigInteger y = x;
        BigInteger k = new BigInteger("2");
        BigInteger f;
        while (true) {
            i = i.add(BigInteger.ONE);
            if (i.compareTo(n) >= 0) {
                return n;
            }
            x = ((x.pow(2)).subtract(BigInteger.ONE)).mod(n);
            f = (y.subtract(x)).gcd(n);
            if (f.compareTo(BigInteger.ONE) != 0 && f.compareTo(n) != 0){
                return f;
            } else if (i.compareTo(k) == 0){
                y = x;
                k = k.pow(2);
            }
        }
    }

    private BigInteger[] trial_division_by_rho(BigInteger n) {
        List<BigInteger> prime_list = new ArrayList<>();
        BigInteger res;

        while (true) {
            res = rho(n);
            prime_list.add(res);
            if (n.compareTo(res) == 0)
                break;
            n = n.divide(res);
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
