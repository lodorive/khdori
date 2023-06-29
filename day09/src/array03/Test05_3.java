package array03;

import java.util.Random;

public class Test05_3 {
	public static void main(String[] args) {
		//주사위 문제
		Random r = new Random();
		
		//배열 생성
		int[][] diceList = new int[6][5];
		
		
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				diceList[i][k] = r.nextInt(6)+1;
			}
		}
		
		//회차별 평균 계산
		//= 합계을 저장할 변수가 "회차" 개수만큼 있어야 한다
		int[] totalList = new int[diceList.length];
		float[] avgList = new float[diceList.length];
		
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				totalList[i] += diceList[i][k];		
		}
			System.out.println((i+1) + "회차 합계 = "+totalList[i]);
			avgList[i] = (float)totalList[i] /  diceList[i].length;
			}
		
		for(int i=0; i < avgList.length; i++) {
			System.out.println((i+1) + "회차 평균 = " + avgList[i]);
		}
		
		//출력
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				System.out.print(diceList[i][k]+"\t");
			}
			
			System.out.println();
		}

	}
}
