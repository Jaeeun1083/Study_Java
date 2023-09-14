package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
* 우선 순위 큐
* */
public class Main_09_절대값_힙_구현하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine()); // 질의 요청 개수


        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2)-> {
            // 절댓값 기준으로 정렬 되도록 설정
            // 절댓값이 같으면 음수 우선 정렬

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            // 리턴 값이 양수일 경우
            return first_abs - second_abs;
        });

        // 요청 0 -> 큐가 비어 있으면 0/ 비어 있지 않으면 큐의 front 값 출력 (poll())
        // 요청 1 -> 새로운 데이터를 우선 순위 큐에 더하기 (add())
        for (int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if(myQueue.isEmpty()) System.out.println("0");
                else System.out.println(myQueue.poll());
            } else {
                myQueue.add(request);
            }
        }
    }
}
