package input;

import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {
		//사용자에게 정보를 입력받아 총점(tot)과 평균(avg)를 구하여 출력
		
		//입력		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 숫자로 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 숫자로 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 숫자로 입력하세요 : ");
		int mat = sc.nextInt();
		
		sc.close();
		
		//계산
		int tot = kor + eng + mat;
		float avg = (float)tot / 3;
		
		//출력
		System.out.println("<계산 결과>");
		System.out.println("총점 = " + tot);
		System.out.println("평균 = " + avg);		
	}
}