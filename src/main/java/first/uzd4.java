package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uzd4 {
    public static void main(String[] args) throws IOException {

        // TODO || aprekitan figuras laukumu

        int n;
        double a, sD, sR, t, r;
        String x;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Ievadiet malu skaitu: ");
            x = br.readLine();
            n = Integer.parseInt(x);
            if (n < 3) throw new IllegalArgumentException();

            System.out.print("Ievadit malas gatumu: ");
            x = br.readLine();
            a = Math.rint(1000.0 * Double.parseDouble(x)) / 1000.0;
            if (a < 0) throw new IllegalArgumentException();

        } catch (IllegalArgumentException e) {
            System.out.println("input error");
            return;
        }

        r = a / (2 * Math.tan(Math.PI / n));
        sD = 0.5 * n * a * r;
        sR = Math.PI * r * r;
        t = Math.rint(1000.0 * (sD - sR)) / 1000.0;

        System.out.printf("%.3f\n", t);

    }
}
