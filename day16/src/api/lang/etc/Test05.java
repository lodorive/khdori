package api.lang.etc;

public class Test05 {
	public static void main(String[] args) {
		//Integer 클래스
		//= Wrapper 클래스(총 8종류(원시형의 개수만큼))
		//= int와 관련된 여러 기능들을 제공하는 클래스
		//= int를 객체 형태로 사용하도록 만들어주는 클래스
		
		//생성 - Java 9 이후부터 비추천 처리
		Integer a = new Integer(10); //int a = 10;
		Integer b = new Integer("10"); //int b = 10;
		System.out.println(a.toString()); //System.out.println(a);
		System.out.println(b.toString()); //System.out.println(b);
		
		//자주쓰는 값(-128~+127)은 신규로 만들지 않고 캐싱된 값을 사용
		Integer c = Integer.valueOf(10);
		Integer d = Integer.valueOf("10");
		System.out.println("c = "+c);
		System.out.println("d = "+d);		
		
		//int와 Integer는 무슨 차이가 있는가?
		//-10 + 20을 각각의 방식으로 계산
		//-123을 각각의 방식으로 16진수로 변환하여 출력
		
		int v1 = 10, v2 = 20;
		int v3 = v1 + v2;
		System.out.println("v3 = "+v3);
		
		Integer w1 = Integer.valueOf(10);
		Integer w2 = Integer.valueOf(20);
		Integer w3 = Integer.sum(w1, w2);
		System.out.println("w3 = "+w3.toString());
		
		//------------------------------------------------------
		
		StringBuffer buffer = new StringBuffer();
		
		int x = 123;
		
		for(int i =x; i>0; i/=2) {
			//System.out.println("i = "+ i +", 나머지 = "+i%2);
			buffer.insert(0, i%2);
		}
		System.out.println("x = "+buffer.toString());
		
		
		Integer y = Integer.valueOf(123);
		System.out.println("y = "+Integer.toBinaryString(y));
		
		//int와 Integer는 호환이 된다
		
		Integer z = 10 + 20; //int(원시형) ----> Integer(참조형) : auto-boxing
		int p = z; //Integer(참조형) ----> int(원시형) : auto-unboxing
		
		//int와 Integer의 결정적인 차이
		//= null(참조 대상이 없음)
		
		//int q1 = null; //error
		Integer q2 = null; //ok
	}
}
