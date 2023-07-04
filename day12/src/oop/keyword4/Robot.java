package oop.keyword4;

import java.util.Random;

public class Robot {
	//[1] 제곱 계산 기능
	public static int square(int n) {
		return n * n;
	}
	
	//public static double square(double n) {
	//	return n * n;
	//}
	
	//[2] 삼각형 넓이 구하는 메소드 
	public static float triangle(int width, int heigh) { //인자를 float로 받아도 됨 
		return (float)width * heigh / 2; //인자가 정수기 때문에 앞에 float 꼭 까먹지 말기
	}
	
	//[3] 원의 넓이를 구하는 메소드 
	public static float circle(int radius) { 
		//return radius * radius * 3.14f;	
		//return Robot.square(radius) * 3.14f;
		return square(radius) * 3.14f;
	}
	
	//[4] 정수 배열을 선택 정렬하는 메소드
	public static void sort(int[] data) {
		//선택정렬
		for(int k=0; k<data.length-1; k++) {

			int minIndex = k; // 1번 위치의 값이 제일 작다고 생각(0~3)

			for(int i = k+1; i<data.length; i++) {//뒤에 있는 데이터와 비교하여
				if(data[minIndex] > data[i]) {//더 작은 값이 있다면
					minIndex = i; //교체!
			}
				}
			//System.out.println(minIndex);

			int backup = data[minIndex];
				data[minIndex] = data[k];
				data[k] = backup;		
			}
	}

	//[5] 배열을 뒤집는 메소드(reverse)
	public static void reverse(int[] data) {
		int left = 0;
		int right = data.length-1;

		for(int i = 0; i<data.length/2; i++) {
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;

			left++;
			right--;
		}
	}

	//[6] 배열을 무작위로 섞는 메소드(shuffle)	
	public static void shuffle(int[] data) {
		
		Random r = new Random();
		
		for(int i = 0; i<data.length; i++) {
		//[i]과 <---> [0~4] 
		int index = r.nextInt(data.length);

		if(i == index) {
			i--;
			continue;
			}

		int backup = data[i]; //0, 1, 2, 3, 4 =for
		data[i] = data[index];
		data[index] = backup;
		}
	}
	
	//[7] 배열을 출력하는 메소드
	public static void print(int[] data) {
		
		for(int i =0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
			}
		System.out.println();
	}
		
}