package array03;

import java.util.Random;

public class Test06_2 {
	public static void main(String[] args) {
		//빙고판 만들기(5x5)
		//빙고판에는 숫자가 1부터 25까지 랜덤한 위치에 배치
		//한 칸에는 한 번의 숫자만 배치 가능
		
		Random r = new Random();
		
		//배열 생성
		int size = 5;
		int[][] bingo = new int[size][size];					
		
		//데이터 초기화
		for(int i =0; i<size*size; i++) {
			int x = r.nextInt(size);
			int y = r.nextInt(size);
			
			if(bingo[x][y] == 0) { //처음 넣는 자리라면
			bingo[x][y] = i;
		}
			else {
				i--;}
			}
				
		//출력
		for(int k=0; k<size; k++) {		
			for(int i =0; i<size; i++) {
			System.out.print(bingo[k][i]+"\t");
				}
			System.out.println("\t");
		}	
		
		
	}
}
