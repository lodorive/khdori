package condition2;

import java.util.Scanner;

public class Test06_1 {
	public static void main(String[] args) {
		//인바디 측정기
		//신장과 체중을 입력 받아 BMI 수치를 계산
		//기준에 따라 비만도 판정까지 수행
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(cm)를 입력하세요 : ");
		float height = sc.nextFloat();
				
		System.out.print("몸무게(kg)를 입력하세요 : ");
		float weight = sc.nextFloat();
		
		sc.close();
		
		//계산		
		float heightMeter = height / 100;
		//System.out.println(heightMeter);
		float bmi = weight / ( heightMeter * heightMeter);
		//float bmi = weight / heightMeter / heightMeter;
		
		String status;		
		if(bmi < 18.5f) {//f를 붙여주는게 좋다
			status = "저체중";
			}
		else if(bmi < 23f) { 
			status = "정상";
		}
		else if(bmi < 25f) {
			status = "과체중";
		}
		else if(bmi < 30f) {
			status = "경도비만";
		}
		else{
			status = "중등도비만";
		}
		
		//출력
		System.out.println("BMI 수치는 : " +bmi );
		System.out.println("건강 상태는 : " + status);
	}
}
