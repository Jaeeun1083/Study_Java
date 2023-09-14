package main.java;

import java.io.IOException;
import java.util.Scanner;

public class Main_10_수_정렬하기_01 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        // 버블 정렬 구현
        for (int i=0; i<N-1; i++) {
            for (int j=0; i<N-1-i; j++) {
                if(A[j]> A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for (int i=0; i<N; i++) {
            System.out.println(A[i]);
        }
    }

}
