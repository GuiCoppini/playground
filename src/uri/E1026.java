package uri;

import java.util.Arrays;
import java.util.Scanner;

public class E1026 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            long a = s.nextLong();
            long b = s.nextLong();

            System.out.println(sum(a, b));
        }

    }


    static long sum(long a, long b) {
        char[] binA = leftPadWithZero(32, Long.toBinaryString(a).toCharArray());
        char[] binB = leftPadWithZero(32, Long.toBinaryString(b).toCharArray());


        char[] result = new char[32];

        Arrays.fill(result, '0');

        for(int i = binA.length-1 ; i>=0; i--) {
            if(binA[i] == binB[i]) {
                result[i] = '0';
            } else {
                result[i] = '1';
            }
        }

        return Long.parseLong(new String(result), 2);
    }

    private static char[] leftPadWithZero(int totalSize, char[] arrayToPad) {
        char[] result = new char[totalSize];

        Arrays.fill(result, '0');
        int actualIndex = arrayToPad.length-1;
        for(int i = result.length-1; i>=0 && actualIndex >= 0; i--) {
            result[i] = arrayToPad[actualIndex];
            actualIndex--;
        }

        return result;
    }
}
