package main.java;

import java.util.Scanner;

public class Main_02_평균_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // int[] A = new int[N];
        
        // for (int i = 0; i < A.length; i ++) {
        //     A[i] = sc.nextInt();
        // }
        long sum = 0;
        long max = 0;
        
        // for (int i = 0; i < A.length; i ++) {
        //     if(A[i]>max) max = A[i];
        //     sum += A[i];
        // }
        
        for (int i = 0; i < N; i ++) {
            int temp = sc.nextInt();
            if(temp>max) max = temp;
            sum += temp;
        }

        System.out.println(sum * 100.0/max/N);
    }
}
