package array;

import java.util.Random;

public class Test09 {
	public static void main(String[] args) {
		//로또 시뮬레이션
		//로또번호 중에서 가장 많이 나오는 번호를 찾는 목적
		//랜덤을 이용하여 로또번호를 1000번 정도 추첨
		//1.각 번호(1~45)가 몇 번 나왔는지 측정하여 출력
		//2.가장 많이 나온 번호를 찾아서 출력
		
		Random r = new Random();
		
		int[] countList = new int[45];
		
		
		for(int i = 0; i<1000; i++) { //로또 번호를 1000번 추첨
		int lotto = r.nextInt(45)+1;
		countList[lotto-1]++;
		}
		
		for(int i = 0; i < countList.length; i++) {
			System.out.println((i+1)+" 나온 횟수 = "+countList[i]);
			}		
		}	
	}

