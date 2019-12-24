package ExLong;

import java.util.Objects;
import ExLong.Out.*;

public class ExLong {

    public static boolean TryParse(String str, Out<Long> result) {
        Objects.requireNonNull(str, "str");
        Objects.requireNonNull(result, "result");

        long value = 0;
        boolean isNegative = false;

        for (char c : str.toCharArray()) {
            if (value == 0 && c == '-') {
                isNegative = true;
                continue;
            }

            if (c < '0' || c > '9') {
                result.set(0L);
                return false;
            }

            value *= 10;
            value += c - '0';

        }

        value = isNegative ? -value : value;
        result.set(value);
        return true;
    }
}
