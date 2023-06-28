package array;

public interface Test04 {
	public static void main(String[] args) {
		//'자바', '파이썬', '루비'를 저장하기 위한 배열 생성 후 출력
		
		//생성
		//data ------> [ null ] [ null ] [ null ]
		String[] data = new String[3];
		
		//초기화(대입)
		data[0] = "자바";
		data[1] = "파이썬";
		data[2] = "루비";
		
		//출력
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
	}
}
