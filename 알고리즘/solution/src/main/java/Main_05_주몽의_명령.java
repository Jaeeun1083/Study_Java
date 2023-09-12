package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_05_주몽의_명령{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 재료 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷이 되는 번호

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 재료 배열 저장
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 크기대로 정렬
        Arrays.sort(A);

        int count = 0;  // 정답 개수
        int i = 0;      // A[0] -> Min
        int j = N-1;    // A[N-1] -> Max
        while (i < j) {
            if (A[i] + A[j] < M) i++;
            else if (A[i] + A[j] > M) j--;
            else {
                count++;
                i++; j--;
            }
        }
        System.out.println(count);
    }
}
