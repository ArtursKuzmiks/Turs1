package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class uzd5 {
    public static void main(String[] args) throws IOException {

        // TODO || saskaitit lielus veselus ciparus

        int n;
        String str;
        BigInteger numB;
        BigInteger S = BigInteger.valueOf(0);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Ievadiet saskaitamo skaitlu skaits: ");
            str = br.readLine();
            n = Integer.parseInt(str);
            if (n <= 0) throw new IllegalArgumentException();

            System.out.println("Ievadiet skaitlus:");

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                numB = new BigInteger(str);
                S = S.add(numB);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("input error");
            return;
        }

        System.out.println(S);

    }
}
