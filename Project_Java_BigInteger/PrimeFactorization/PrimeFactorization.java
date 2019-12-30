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
        BigInteger num0 = new BigInteger("0");
        BigInteger num1 = new BigInteger("1");
        BigInteger num2 = new BigInteger("2");
        BigInteger num3 = new BigInteger("3");
        BigInteger num4 = new BigInteger("4");

        // 2 ‚ÅŠ„‚Á‚Ä‚¢‚­
        while (n.mod(num2).compareTo(num0) == 0) {
            prime_list.add(num2);
            n = n.divide(num2);
        }

        // 3 ‚ÅŠ„‚Á‚Ä‚¢‚­
        while (n.mod(num3).compareTo(num0) == 0) {
            prime_list.add(num3);
            n = n.divide(num3);
        }

        // 5 ` Math.sqrt(n) ‚Ì”š‚ÅŠ„‚Á‚Ä‚¢‚­
        Boolean flag = true;

        for (BigInteger i = new BigInteger("5"); i.compareTo(max) < 0; ) {
            while (n.mod(i).compareTo(num0) == 0) {
                prime_list.add(i);
                n = n.divide(i);
                if (n.compareTo(num1) == 0)
                    i = max;
            }

            if (flag)
                i = i.add(num2);
            else
                i = i.add(num4);

            flag = !flag;
        }

        if (n.compareTo(num1) != 0) {
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
