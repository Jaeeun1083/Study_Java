package main.java;

import java.util.Scanner;

public class Main_11_내림차순으로_자릿_수_정렬하기 {

    // 입력 값을 String으로 받은 후 substring() 함수를 이용해 자릿 수 단위로 분리하고,
    // 이를 다시 int형으로 변경해 배열에 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        // 선택 정렬
        for(int i=0; i<str.length(); i++) {
            int Max = i;
            for (int j=i+1; j<str.length(); j++) {
                if (A[j] > A[Max]) {
                    Max = j;
                }
            }
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for(int i=0; i<str.length(); i++) {
            System.out.print(A[i]);
        }
    }

}
