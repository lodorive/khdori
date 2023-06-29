package array03;

import java.util.Random;

public class Test05_1 {
	public static void main(String[] args) {
		//주사위 문제
		Random r = new Random();
		
		//배열 생성
		int[][] diceList = new int[6][5];
		
		//diceList ---> diceList[0] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		//			  ---> diceList[1] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		//			  ---> diceList[2] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		//			  ---> diceList[3] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		//			  ---> diceList[4] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		//			  ---> diceList[5] ---> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
		
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				System.out.print(diceList[i][k]+"\t");
			}
			System.out.println();
		}
	}
}
