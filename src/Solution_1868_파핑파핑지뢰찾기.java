

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기  {
	static int dy[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dx[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int count;
	static char map[][];
	static boolean visited[][];
	static Queue<Point> queue;
	static int N;

	private static void bfs() {
        while (!queue.isEmpty()) {
            Point head = queue.poll();
            // 일단은 8지점에 지뢰가 하나라도 있는지 체크
            int mine = getAroundMineCount(head.y, head.x);
            // 지뢰가 없다면 8방 탐색으로 새로운 후보지 몰색
            if (mine == 0) {
                for (int d = 0; d < dx.length; d++) {
                    int ny = head.y + dy[d];
                    int nx = head.x + dx[d];
                    if (0 <= ny && 0 <= nx && nx < N && ny < N && map[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx]=true;
                        queue.add(new Point(ny, nx));
                    }
                }
            }
        }
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited= new boolean[N][N];
			queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			count = 0;
			 for (int y = 0; y < N; y++) {
	                for (int x = 0; x < N; x++) {
	 
	                    if(map[y][x]=='*') {                // 해당 지점이 지뢰라면 관심 없음
	                        continue;
	                    }
	                    int mine =getAroundMineCount(y, x); // 주변의 지뢰 개수 가져오기
	 
	                    if(mine==0 && !visited[y][x]) {     // 주변에 지뢰가 하나도 없는 점이라면. 그곳을 기점으로 bfs
	                        visited[y][x]=true;
	                        queue.add(new Point(y, x));
	                        bfs();
	                        count++;
	                    }
	                }
	            }
			
			 for(int y=0; y<N; y++) {
	                for(int x=0; x<N; x++) {
	                    if(map[y][x]=='.' && !visited[y][x]) {
	                        count++;
	                    }
	                }
	            }

		
			System.out.println("#" + tc + " " + count);
		}
	}
	
	 private static boolean inRange(int y, int x) {
	        return 0<=y && 0<=x && y<N && x<N;
	    }
	
	  private static int getAroundMineCount(int y, int x) {
	        int mine = 0;
	        for (int d = 0; d < dx.length; d++) {
	            int ny = y + dy[d];
	            int nx = x + dx[d];
	            if (inRange(ny, nx) && map[ny][nx] == '*') {
	                mine++;
	            }
	        }
	        return mine;
	    }
	
	
	 public static class Point {
	        int y, x;
	 
	        public Point(int y, int x) {
	            this.y = y;
	            this.x = x;
	        }
	 
	    
	    }

}
