package array;

import java.util.Scanner;

public interface Test08 {
	public static void main(String[] args) {
		//학생 5명의 시험점수를 입력받아 저장
		//1.통과하지 못한 학생의 점수만 출력
		//2.우수한 성적(90점 이상)으로 통과한 학생의 점수만 출력
		//3.만약 75점인 학생이 전학을 왔다면 몇등인지 구해서 출력
		
		//등수 구하기
		
		Scanner sc = new Scanner(System.in);
		
		//int[] scoreList = new int[] {0,0,0,0,0}; //미리 입력값을 알고 있을 때 
		int[] scoreList = new int[5];
		
		for(int i = 0; i<scoreList.length; i++) {
			System.out.print("시험 점수 입력 : ");
			scoreList[i] = sc.nextInt(); 
		}
		
		sc.close();
		
		System.out.println("통과하지 못한 학생의 점수는 다음과 같다");
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] <90) {
			System.out.println("통과하지 못한 학생의 점수 = "+scoreList[i]);
			}
		}
		
		System.out.println("우수한 성적으로 통과한 학생의 점수는 다음과 같다");
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] >= 90) {
				System.out.println("우수한 성적으로 통과한 학생의 점수 = "+scoreList[i]);
			}
		}
	
	}
}