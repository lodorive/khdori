package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//업다운 게임
		//업다운 게임은 숫자를 맞추는 게임
		
		//술래가 1부터 1000사이의 정수 중에 랜덤으로 하나의 숫자를 정한다
		//술래가 아닌 사람이 정답을 예측 
		//예측한 정답과 실제 정답이 같으면 게임 종료
		//예측한 정답과 실제 정답이 다르면 '업' or '다운' 외치기
		//1. '업'을 외치는 경우 예측한 정답보다 실제 정답이 더 큰 수일 경우
		//2. '다운'을 외치는 경우 예측한 정답보다 실제 정답이 더 작은 수일 경우
		
		//컴퓨터가 술래를 하고, 사용자가 정답을 맞추는 형태
		//정답을 맞추면 몇 번만에 맞췄는지 카운트하여 출력
	
		Random r = new Random();	
		Scanner sc = new Scanner(System.in);
		
		//정답을 생성
		int answer = r.nextInt(1000) +1; //1부터 1000까지
		
		System.out.println("1부터 1000 사이의 숫자 중 하나를 컴퓨터가 골랐습니다!");
		
		int round = 0;
		
		while(true) {
		//입력하여 맞춘다
		System.out.print("정답 입력 : ");
		int input = sc.nextInt();
		
		round++; //모든 경우 사용할 경우 이 위치에 입력
		
		if(input == answer) {
			System.out.println("정답");
			break;
		}
		else if(input < answer) {
			System.out.println("업");
		}
		else {
			System.out.println("다운");
			}
		}
		sc.close();
		
		System.out.println("총 입력한 횟수는 "+round+"번 입니다");
	}
}

