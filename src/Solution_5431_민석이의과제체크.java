import java.util.Scanner;

public class Solution_5431_민석이의과제체크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		int t_c = sc.nextInt();
		String res[]=new String[t_c+1];
		for(int i=1;i<t_c+1;i++)
		{
			int num = sc.nextInt();
			int num2 = sc.nextInt();
			int student[]=new int[num+1];
		
			for(int j = 0 ; j<num2;j++)
			{
				int input=sc.nextInt();
				student[input]++;
				
			}
			
			System.out.print("#"+i);
			for(int j = 1 ; j<student.length;j++)
			{
				if(student[j]==0)
					System.out.print(" "+j);
			}
			
		System.out.println();	
		}
		
		
	}

}
