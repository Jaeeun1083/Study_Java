import java.util.Scanner;

public class Main_04_연속된_자연수의_합_구하기{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        
        int sum = 1;
        int N = sc.nextInt();
        while (end_index < N) {
            if (sum == N) {
                count ++;
                end_index ++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index ++;
            } else {
                end_index ++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
