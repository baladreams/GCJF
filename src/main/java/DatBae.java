
/**
 * DatBae 
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881de
 */

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatBae {

    public static void main(String args[]) {
        try (Scanner input = new Scanner(System.in); FileWriter fos=new FileWriter("datbae.log")) {
            int T = input.nextInt();
            for (int ks = 1; ks <= T; ks++) {
                int n = input.nextInt();
                int b = input.nextInt();
                int f = input.nextInt();
                
                int maxF=new Double(Math.pow(2,f)).intValue()-1;
                fos.write("Number of bits: " + n + " Broken bits: " + b + " Number of guesses: "+f+" Max k" +maxF);

                char[][] guesses = new char[f][n];
                char[][] results = new char[f][n];

                int k = 0;
                for (int i = 0; i < n; i++) {
                    fos.write("Guessing number " + k+"\n");
                    String binaryStr = Integer.toBinaryString(k);
                    while(binaryStr.length()<f){
                        binaryStr="0"+binaryStr;
                    }
                    int j = 0;
                    for (char c : binaryStr.toCharArray()) {//.substring(binaryStr.length() - f, binaryStr.length())
                        guesses[j++][i] = c;
                    }
                    if (++k>maxF)
                        k = 0;
                }

                for (int i = 0; i < f; i++) {
                    fos.write("Guess: " +String.copyValueOf(guesses[i])+"\n");
                    System.out.println(String.copyValueOf(guesses[i]));
                    String response = input.next();
                    fos.write("Response : "+response+"\n");
                    fos.write(String.copyValueOf(guesses[i])+"\n");
                    int j = 0;
                    for (char c : response.toCharArray()) {
                        results[i][j++] = c;
                    }
                }

                int bit = k = 0;
                StringBuilder sb;
                List<Integer> missingBits = new ArrayList<Integer>();
                for (int i = 0; i < n; i++,bit++) {
                    sb = new StringBuilder();
                    for (int j = 0; j < f; j++) {
                        sb.append(results[j][i]);
                    }
                    if(sb.toString().trim().length()==0) break;
                    int received = Integer.valueOf(sb.toString(), 2);
                    fos.write("Received " + received+" k " + k +" at column i " + i+"\n");
                    while (k != received) {
                        fos.write("Mimatch Received " + received+" k " + k +" at column i " + i+"\n");
                        missingBits.add(bit++);
                        if(++k>maxF)
                            k = 0;
                    }
                    if(++k>maxF)
                        k = 0;
                }

                while(bit<n){
                    missingBits.add(bit++);
                }

                sb = new StringBuilder();
                for (Integer i : missingBits) {
                    sb.append(i);
                    sb.append(" ");
                }
                fos.write("Guessing " + sb.toString().trim());
                fos.write("\n\n----------------------------------------------------\n\n");
                System.out.println(sb.toString().trim());
                int judgement = input.nextInt();
                if (judgement == -1)
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}