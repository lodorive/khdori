package api.lang.string3;

public class Test02_1 {
	public static void main(String[] args) {
		//문자열 덧셈 성능 측정
		//StringBuffer
		
		long start = System.currentTimeMillis(); //측정 시작
		
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<1000; i++) {
			buffer.append("*");
		}
		String star = buffer.toString();
		
		long finish = System.currentTimeMillis(); //측정 완료
		
		long time = finish - start;
		System.out.println("time = " +time);
	}
}
