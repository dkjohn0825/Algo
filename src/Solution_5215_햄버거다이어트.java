import java.util.Arrays;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트 
{
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++)
		{
			int N = sc.nextInt();
			int max_cal = sc.nextInt();
			
			int[] scores=new int[N];
			int[] cals=new int[N];
			
			for(int i = 0 ; i<N; i++)
			{
				scores[i]=sc.nextInt();
				cals[i]=sc.nextInt();
			}
			
			
			int num = N;
			int max=0;
			
			for(int i = 0 ;i<(1<<num);i++)
			{
			
				int total_cal=0;
				int total_score=0;
				
				for(int j = 0 ; j<num;j++)
				{
					if(((1<<j)&i)!=0){
					total_cal +=cals[j];	

					if(total_cal>max_cal)
						break;
					
					total_score +=scores[j];
				
					}
				}
				if(max<total_score)
					max=total_score;
		
				
			}
			System.out.println("#"+(tc)+" "+max);
			
		}
		
	
	}

}
