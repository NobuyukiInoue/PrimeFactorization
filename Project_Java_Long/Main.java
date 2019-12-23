import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            prlong_msg_and_exit();
        }

        // 素因数分解したい値の読み込み
        Long n = Long.parseLong(args[0]);

        PrimeFactorization pf = new PrimeFactorization();
        pf.Main(n);
    }

    private static void prlong_msg_and_exit() {
        System.out.println("\nUsage: java Main <number>");
        System.exit(1);
    }
}
