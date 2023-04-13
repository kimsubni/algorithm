package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_21314_민겸수 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int mCnt = 0;
        String min = "";
        String max = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == 'K') {
                // K를 발견했을 때
                BigInteger big = new BigInteger("10");
                BigInteger bigMax = new BigInteger("1");
                bigMax = big.pow(mCnt);
                BigInteger n = new BigInteger("5");
                bigMax = bigMax.multiply(n);
                max += String.valueOf(bigMax);
                BigInteger bigMin = new BigInteger("1");
                if (mCnt - 1 >= 0)
                    bigMin = big.pow(mCnt - 1);
                min += mCnt - 1 >= 0 ? String.valueOf(bigMin + "5") : "5";

                mCnt = 0;
            } else if (str.charAt(i) == 'M') {
                mCnt++;
            }
        }

        if (mCnt > 0) {
            // 만약 mCnt가 남아있다면
            BigInteger big = new BigInteger("10");
            for (int i = 0; i < mCnt; ++i) {
                max += "1";
            }
            BigInteger bigMin = new BigInteger("1");
            bigMin = big.pow(mCnt - 1);
            min += String.valueOf(bigMin);
        }

        System.out.println(max);
        System.out.println(min);

    }

}
