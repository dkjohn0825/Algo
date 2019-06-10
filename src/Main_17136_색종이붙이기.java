import java.util.Scanner;

public class Main_17136_색종이붙이기 {

	static int min;
	static boolean visited[][];
	static int paper[];


	static void dfs(int[][] map, int d, int y, int x, int size) {
		
		boolean isEnd = true;
		if (d > min)
			return;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					isEnd = false;
					break;
				}
			}
			if (!isEnd)
				break;
		}

		if (isEnd) {
			min = min>d-1?d-1:min;
			if(min==-1) min = 0;
			return;
		}

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (i>=10 || j>=10 || map[i][j] == 0)
					return;
				map[i][j] = 0;
			}
		}

		int ny=0;
		int nx=0;
		boolean flag = false;
		for (ny = 0; ny < 10; ny++) {
			for (nx = 0; nx < 10; nx++) {
				if(map[ny][nx]==1)
				{
					flag=true;
					break;
				}
			}
			if(flag)	
				break;
		}
		
		
		System.out.println(d+ " "+ny+ " "+nx+ " "+ size);
		for(int i = 5; i>=1; i--)
		{
			if(paper[i]==5)	continue;
			paper[i]++;
			dfs(map,d+1,ny,nx,i);
			paper[i]--;
		}

	}

	static boolean isRange(int y, int x) {
		return 0 <= y && y < 10 && 0 <= x && x < 10;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[][] map = new int[10][10];
		paper = new int[6];
		visited = new boolean[10][10];

		min = 9999;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();

			}
		}

		dfs(map, 0, 0, 0, 0);

		if (min == 9999)
			System.out.println("-1");
		else
			System.out.println(min);

	}

}
