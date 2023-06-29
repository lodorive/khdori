package array03;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		//빙고판 만들기(5x5)
		//빙고판은 정사각형이며 홀수 크기만 가능
		//빙고판에는 숫자가 1부터 25까지 랜덤한 위치에 배치
		//한 칸에는 한 번의 숫자만 배치 가능
		
		Random r = new Random();
		
		int[][] bingo = new int[5][5];					
		
		for(int k=0; k<bingo.length; k++) {		
			for(int i =0; i<bingo[k].length; i++) {
			bingo[k][i] = r.nextInt(25)+1;
			
			
			System.out.print(bingo[k][i]+"\t");
			
				}
			System.out.println();
		}	
		
		
	}
}
