package condition2;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//BMI 계산기 개조
		//신장과 체중을 입력 받아 BMI 수치를 계산
		//기준에 따라 비만도 판정까지 수행
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(cm)를 입력하세요 : ");
		float cm = sc.nextFloat();
		System.out.print("몸무게(kg)를 입력하세요 : ");
		float kg = sc.nextFloat();
		
		sc.close();
		
		//계산
		
		float m = cm / 100;
		double bmi = (double)kg / (m * m);
		
		String result;
		
		
		if(bmi < 18.5) {
			result = "BMI 수치는 " +bmi + " 로 저체중입니다";
			}
		else if(bmi < 23) { 
			result = "BMI 수치는 " +bmi + " 로 정상입니다";
		}
		else if(bmi < 25) {
			result = "BMI 수치는 " +bmi + " 로 과체중입니다";
		}
		else if(bmi < 30) {
			result = "BMI 수치는 " +bmi + " 로 경도비만입니다";
		}
		else{
			result = "BMI 수치는 " +bmi + " 로 중등도비만입니다";
		}
		
		//출력
		System.out.println(result);
	}
}
