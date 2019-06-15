
import java.util.Scanner;

public class Solution_1204_최빈수구하기  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t_c = sc.nextInt();
		int res[] = new int[t_c];

		for (int i = 0; i < t_c; i++) {
			int num = sc.nextInt();

			int arr[] = new int[1000];
			int index[]= new int[101];
					
			int max_num = Integer.MIN_VALUE;
			int max_ind=Integer.MIN_VALUE;

			for (int x = 0; x < 1000; x++)

			{
				arr[i] = sc.nextInt();
				index[arr[i]]++;
			}
			
			for(int x = 0 ; x< index.length;x++)
			{
				if(max_ind<=index[x])
					{
					if(max_num<x)
					{	max_num=x;
						max_ind=index[x];
					}
				
			}

			res[i] = max_num;
			}
		}

		for (int i = 0; i < res.length; i++)
			System.out.println("#" + (i+1) + " " + res[i]);
	}

}
