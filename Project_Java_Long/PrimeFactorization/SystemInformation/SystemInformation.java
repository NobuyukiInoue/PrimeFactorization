
package PrimeFactorization.SystemInformation;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;

public class SystemInformation {
    public void printProperties() {
         // Get Date and Time
         DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         String datetimeStr = df1.format(LocalDateTime.now());

         System.out.printf("=====================================================================================\n");
         System.out.printf("%-10s: %s\n", "Date", datetimeStr);
         System.out.printf("%-10s: %s\n", "Language", "Java");

        // get System Information
        Properties systemProperties = System.getProperties();
        Set<Object> propertiesSet = systemProperties.keySet();

        // Sort a TreeSet order by key.
        TreeSet<Object> propertiesTreeSet = new TreeSet<Object>(propertiesSet);
        for (Object key: propertiesTreeSet) {
            if (key.equals("os.name")) {
                System.out.printf("%-10s: ", "OS");
                System.out.println(System.getProperty( (String) key) );
            }
        }

         System.out.printf("=====================================================================================\n");
    }
}
