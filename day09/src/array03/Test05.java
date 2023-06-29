package array03;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		//주사위 문제
		
		Random r = new Random();
		
		//주사위를 5번씩 6회 던진 결과 저장
		int[][] dice = new int[][] {
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
			{r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1, r.nextInt(6)+1},
		};
		
		int total = 0;
		int count = 0;
		for(int k = 0; k<dice.length; k++) {
			
		for(int i = 0; i<dice[k].length; i++) {
		System.out.print(dice[k][i]+"\t");
		count++;
		total += dice[k][i];
		}
	
		System.out.println();
		}
		
		int avg = total/count;
		

		
		System.out.println();
		System.out.println("모든 주사위 값의 평균 = "+avg);
		
		
	}
}
