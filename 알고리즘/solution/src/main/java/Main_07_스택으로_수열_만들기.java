package main.java;


import java.util.Scanner;
import java.util.Stack;

public class Main_07_스택으로_수열_만들기 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열 개수
        int[] A = new int[N]; // 수열 배열

        // 수열 배열 채우기
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();

        for(int i=0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) { // 현재 수열 값 >= 오름차순 자연수
                while(su>=num) { // 값이 같아질 때까지
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else { // 현재 수열 값 < 오름차순 자연수
                int n = stack.pop();
                if (n > su) { //현재 수열 값이 스택의 마지막 값보다 크다는 뜻.
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);
    }
}
