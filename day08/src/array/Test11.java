package array;

public class Test11 {
	public static void main(String[] args){
	//5명의 키 데이터가 다음과 같을 때 키가 작은 사람의 위치와 값을 출력
		
		//데이터 준비
		//double[] height = new double[] {150.8, 180.2, 175.9, 162.7, 170.3};
		double[] height = new double[] {175.9, 180.2, 150.8, 162.7, 170.3};
		
		//계산 - 탐색
		int minIndex = 0; //위치(index)는 정수(int)이다
		for(int i = 1; i<height.length; i++) {
			if(height[minIndex] > height[i]) { //더 작은 데이터를 만나면
			//위치 정보를 갱신
			minIndex = i; 
			} 
		}
			System.out.println("키가 작은 사람의 위치 = "+minIndex);
			System.out.println("키가 작은 사람의 값 = "+height[minIndex]);
	}			
}
