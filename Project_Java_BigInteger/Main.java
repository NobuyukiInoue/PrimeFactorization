import PrimeFactorization.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            prlong_msg_and_exit();
        }

        BigInteger n = new BigInteger("0");
        try {
            n = new BigInteger(args[0]);
        } catch(Exception e) {
            System.out.printf("new BigInteger(%s) ... error.\n", args[0]);
            System.out.printf("%s\n\n", e.toString());
            System.exit(1);
        }

        PrimeFactorization pf = new PrimeFactorization();
        pf.Main(n);
    }

    private static void prlong_msg_and_exit() {
        System.out.println("\nUsage: java Main <number>");
        System.exit(1);
    }
}
