package loop2;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//구구단 게임
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원하는 단을 입력하세요 : ");
		int num = sc.nextInt();
		
		int count = 0;
		int count2 = 0;
		
		for(int i = 1; i<=9; i++){			
			System.out.print(num+" x "+ i +" = ");
			int num2 = sc.nextInt();

			if(num2 == num*i) {
				System.out.println("정답입니다");
				count++;
			}

			else {
				System.out.println("오답입니다");
				count2++;
				}
			}
		sc.close();
		System.out.println("정답 개수는 " +count+ "개 입니다");
		System.out.println("오답 개수는 " +count2+ "개 입니다");
		}
	}
