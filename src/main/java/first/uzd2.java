package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// skaitam 10^31 otra thread
class Data implements Runnable {
    private volatile double t;

    @Override
    public void run() {
        t = Math.pow(10, 31);
    }

    double getrO() {
        return t;
    }
}

public class uzd2 {

    public static void main(String[] args) throws IOException {

        // TODO || Atrast garaku laiku kuru var skriet komanda

        Data time = new Data();
        Thread myThread = new Thread(time);
        myThread.start();

        int[] pS;
        int[] pA;
        int n, A, S;
        double pSum, t, C;
        String x;

        pSum = 0;
        C = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Ievadiet dalibnieka sakaitu komanda: ");
            x = br.readLine();
            n = Integer.parseInt(x);
            if (n <= 0) throw new IllegalArgumentException();

            pS = new int[n];
            pA = new int[n];

            System.out.println("Dalibnieka pazimes");

            for (int i = 0; i < n; i++) {
                x = br.readLine();
                String[] pZ = x.split(" ");
                pS[i] = Integer.valueOf(pZ[0]);
                pA[i] = Integer.valueOf(pZ[1]);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("input error");
            return;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - 1; j++) {
                if (pA[j] > pA[j + 1]) {
                    A = pA[j];
                    S = pS[j];
                    pA[j] = pA[j + 1];
                    pS[j] = pS[j + 1];
                    pA[j + 1] = A;
                    pS[j + 1] = S;
                }
            }

        int l = 0;
        for (int i = 0; i < n - 1; i++)
            if (pA[i] != pA[i + 1]) {
                for (int j = l; j <= i - 1; j++)
                    if (pS[j] > pS[j + 1]) {
                        S = pS[j];
                        pS[j] = pS[j + 1];
                        pS[j + 1] = S;
                    }
                l = i + 1;
            }

        for (int i = 0; i < n; i++)
            pSum += pS[i];

        if (pA[n - 1] <= pSum - pS[n - 1]) {
            System.out.println(-1);
            return;
        }

        t = time.getrO();

        for (int i = 0; i < n; i++) {
            C += pS[i];
            if (pSum >= pA[i] + C) pSum += pS[i];
            if (pSum >= t) {
                System.out.println(-1);
                return;
            }
        }

        System.out.printf("Ilgakais laik kuru var skriet komanda: %.0f\n", pSum);
    }
}