import java.util.Scanner;
 
public class Solution_활주로건설{
 
    static int[][] a = new int[101][101], b = new int[101][101];
    static int n, l, ans;// l== 경사로의 크기, n은 크기
 
    static void check(int row, int a[][]) {
        boolean c[] = new boolean[n];
        int temp = a[row][0];
        for (int i = 0; i < n; i++) {
            if (a[row][i] != temp) {
                if (Math.abs(a[row][i] - temp) > 1)
                    return; // 차이가 1보다 클경우
                if (a[row][i] < temp) { // 다음것이 나보다 작을 경우(오른쪽 경사로)
                    int num = -1;
                    for (int j = i; j <= i + l - 1; j++) {
                        if (j >= n || c[j])
                            return;
                        c[j] = true;
                        if (num == -1) {
                            num = a[row][j];
                            continue;
                        }
                        if (num != -1 && a[row][j] != num)
                            return;
                    }
                    i = i + l - 1;
                    if (i >= n)
                        break;
                } else { // 다음것이 나보다 큰 경우(왼쪽 경사로)
                    int num = -1;
                    for (int j = i - 1; j >= i - l; j--) {
                        if (j < 0 || c[j])
                            return;
                        c[j] = true;
                        if (num == -1) {
                            num = a[row][j];
                            continue;
                        }
                        if (num != -1 && a[row][j] != num)
                            return;
                    }
                }
                temp = a[row][i];
            }
        }
        ++ans;
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc=1; tc<=T ;tc++) {
         
        ans = 0;
        n = sc.nextInt();
        l = sc.nextInt();
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                b[j][i] = a[i][j];
            }
        }
 
        for (int i = 0; i < n; i++) {
            check(i, a);
            check(i, b);
        }
 
        System.out.println("#"+tc+" "+ans);
        }
    }
 
}