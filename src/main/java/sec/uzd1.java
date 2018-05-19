package sec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class uzd1 {
    public static void main(String[] args) throws IOException {

        int count;
        long limit = (long) Math.pow(2, 31);  //cant use Integer -> 2^31 -1
        long[] num = {1, 1};
        String[] temp;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Number count: ");
            count = Integer.parseInt(br.readLine());
            //count = Integer.parseInt(args[0]); //jUnit test

            for (int i = 0; i < count; i++) {
                System.out.print("Input num " + (i + 1) + " : ");
                temp = br.readLine().split("/");
                //temp = args[i+1].split("/"); //jUnit test


                long tempNum1 = Long.parseLong(temp[0]);
                long tempNum2 = Long.parseLong(temp[1]);

                if (tempNum1 > limit || tempNum2 > limit)
                    throw new IllegalArgumentException();

                num[0] = num[0] * tempNum1;
                num[1] = num[1] * tempNum2;

                if (num[0] > limit || num[1] > limit)
                    throw new IllegalArgumentException();

                for (int n = 2; n <= Math.min(num[0], num[1]); n++)
                    if (num[0] % n == 0 && num[1] % n == 0) {
                        num[0] /= n;
                        num[1] /= n;
                    }
            }

            if (num[0] > limit || num[1] > limit)
                throw new IllegalArgumentException();

            System.out.println(num[0] + "/" + num[1]);


        } catch (IllegalArgumentException e) {
            System.out.println("Input error");
        }
    }
}
