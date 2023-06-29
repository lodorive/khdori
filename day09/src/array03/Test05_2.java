package array03;

import java.util.Random;

public class Test05_2 {
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
				diceList[i][k] = r.nextInt(6)+1;
			}
		}
		
		//합계와 개수를 구하면 평균을 구할 수 있다
		int total = 0;
		int count = 0;
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				total += diceList[i][k];
				count++;
			}
		}
		
		System.out.println("total(합계) = "+total);
		System.out.println("count(개수) = "+count);
		double avg = (double)total/count;
		System.out.println("avg(평균) ="+avg);
		
		//출력
		for(int i=0; i<diceList.length; i++) {
			for(int k=0; k<diceList[i].length; k++) {
				System.out.print(diceList[i][k]+"\t");
			}
			
			System.out.println();
		}

	}
}
