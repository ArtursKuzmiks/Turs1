package sec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uzd2 {
    public static void main(String[] args) throws IOException {

        long carLimit = (long) Math.pow(2, 31);
        int secLimit = 100000;
        long[][] sec;
        long cars;
        String[] temp;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Size: ");
            temp = br.readLine().split("x");
            //temp = args[0].split("x"); //jUnit test
            int row = Integer.parseInt(temp[0]);
            int col = Integer.parseInt(temp[1]);

            if ((row * col) > secLimit)
                throw new IllegalArgumentException();
            sec = new long[row][col];

            System.out.print("Cars: ");
            cars = Long.parseLong(br.readLine());
            //cars = Long.parseLong(args[1]); //jUnit test

            if (cars > carLimit)
                throw new IllegalArgumentException();

            for (int i = 0; i < sec.length; i++) {
                System.out.print("Sector car count: ");
                temp = br.readLine().split(";");
                //temp = args[i+2].split(";");    //jUnit test
                for (int n = 0; n < temp.length; n++) {
                    sec[i][n] = Long.parseLong(temp[n]);
                    if (sec[i][n] > carLimit)
                        throw new IllegalArgumentException();
                }
            }

            while (cars != 0) {
                long min = sec[1][1];

                for (long[] i : sec){
                    for (long j : i)
                        if (j < min) min = j;
                }

                for (int i = 0; i < sec.length; i++) {
                    for (int j = 0; j < sec[i].length; j++) {
                        if (sec[i][j] == min) {
                            if (cars > 0) {
                                sec[i][j]++;
                                cars--;
                            } else break;

                            if (sec[i][j] > carLimit)
                                throw new IllegalArgumentException();

                        }
                    }
                }
            }

            System.out.println();
            for (long[] aSec : sec) {
                for (long anASec : aSec)
                    System.out.print(anASec + "\t");
                System.out.println();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Input error");
        }

    }
}
