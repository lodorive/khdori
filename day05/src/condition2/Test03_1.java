package condition2;

public class Test03_1 {
	public static void main(String[] args) {
		
		//입력
		int age = 25;
		
		//출력
		if(age >=65) {
		System.out.println("이용요금은 0원 입니다");
		}
		else if(age >=20) {
		System.out.println("이용요금은 1250원 입니다");
		}
		else if(age >= 14) {
		System.out.println("이용요금은 720원 입니다");
		}
		else if(age >= 8) {
		System.out.println("이용요금은 450원 입니다");
		}
		else {
		System.out.println("이용요금은 0원 입니다");
		}
	}
}
