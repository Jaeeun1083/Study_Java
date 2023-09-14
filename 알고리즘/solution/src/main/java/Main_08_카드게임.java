package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_08_카드게임 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드 개수
        Queue<Integer> myQueue = new LinkedList<>();

        // 카드 개수만큼 반복
        for (int i=1; i<=N; i++) {
            myQueue.add(i);
        }
        while(myQueue.size()>1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
}
