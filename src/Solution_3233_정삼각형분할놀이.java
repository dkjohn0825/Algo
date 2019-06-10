import java.util.Scanner;
 
public class Solution_3233_정삼각형분할놀이 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long result = a/b;
 
            System.out.println("#" + i + " " + result*result);
 
        }
 
    }
 
}