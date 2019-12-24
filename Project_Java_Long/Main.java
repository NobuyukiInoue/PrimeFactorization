import PrimeFactorization.*;
import ExLong.*;
import ExLong.Out.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            prlong_msg_and_exit();
        }

        ExLong el = new ExLong();
        Out<Long> n_temp = new Out<Long>();
        long n;
        if (el.TryParse(args[0], n_temp) == false) {
            System.out.println(args[0] + " in not numeric.");
            return;
        }

        // Read the value you want to factor
        n = n_temp.get();

        PrimeFactorization pf = new PrimeFactorization();
        pf.Main(n);
    }

    private static void prlong_msg_and_exit() {
        System.out.println("\nUsage: java Main <number>");
        System.exit(1);
    }
}
