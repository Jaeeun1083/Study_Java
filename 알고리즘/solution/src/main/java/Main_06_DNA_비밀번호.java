package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_06_DNA_비밀번호{
    /*
     *  9 8         // DNA 문자열의 길이, 부분 문자열의 길이
     *  CCTGGATTG   // DNA 문자열
     *  2 0 1 1     // 부분 문자열에 포함되어야 할 A, C, G, T의 최소 개수
     */

    static int[] checkArr; // 비밀번호 체크 배열
    static int[] myArr;   // 현재 상태 배열
    static int checkSecret;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken());   // 부분 문자열의 길이
        
        char[] A = new char[S]; // 문자열 데이터
        A = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());
        // int[] checkArr = new int[4]; // 비밀번호 체크 배열
        // int[] myArr = new int[4];   // 현재 상태 배열
        checkArr = new int[4];
        myArr = new int[4];

        int Result = 0;
        // int checkSecret = 0;
        checkSecret = 0;

        for(int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkSecret++;
        }
        
        for(int i=0; i<P; i++) { // 부분 문자열 처음 받을 때 세팅
            Add(A[i]);
        }

        if (checkSecret == 4) Result++;

        // 슬라이딩 윈도우
        for(int i=P; i <S; i++) {
            int j = i-P;    // j : 슬라이딩 윈도우의 맨 왼쪽. P : 슬라이딩 윈도우의 맨 오른쪽
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++;
        }

        System.out.println(Result);
        br.close();
    }

    private static void Add(char c) {
        switch(c) {
            case 'A' -> {
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
            }
            case 'C' -> {
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
            }
            case 'G' -> {
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
            }
            case 'T' -> {
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
            }
        }
    }

    private static void Remove(char c) {
        switch(c) {
            case 'A' -> {
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
            }
            case 'C' -> {
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
            }
            case 'G' -> {
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
            }
            case 'T' -> {
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
            }
        }
    }
}
