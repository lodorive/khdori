package api.lang.etc;

import java.sql.DriverPropertyInfo;
import java.util.Properties;

public class Test03 {
	public static void main(String[] args) {
		//System 클래스
		//= 외부 시스템(운영체제, OS)과 연결되는 정보들을 가진 클래스
		//= 객체 생성 불가 및 모든 구성요소가 static
		
		//필드
		//-System.err - 표준 에러 스트림(통로)
		//-System.out - 표준 출력 스트림(통로)
		//-System.in - 표준 입력 스트림(통로)
		
		//스트림마다 용도가 정해져 있으며 혼합하여 사용하는 것을 금지! 
		System.out.println("Hello");
		System.err.println("Hello");
		
		//메소드
		//[1] 시간 측정 메소드
		//= 프로그래밍에서는 기준시각이라는 것이 존재
		///= 1970년 1월 1일 0시 0분 0초
		//= 기준시로부터 현재까지 흘러온 총 시간을 밀리초(ms)로 반환
		//= 시간차를 계산할 수 있도록 long 형태로 반환
		long start = System.currentTimeMillis();
		System.out.println("start = "+start);
		
		//[2] 시스템의 정보를 읽을 수 있다
		System.out.println(System.getProperties());
		Properties prop = System.getProperties();
		System.out.println(prop.getProperty("user.country")); //지역
		System.out.println(prop.getProperty("user.language")); //언어
		System.out.println(prop.getProperty("os.name")); //운영체제
		
		String osName = prop.getProperty("os.name");
		//if(osName.startsWith("Windows")) {
		if(osName.matches("^Windows\\s(3\\.1|XP|7|8|9|10|11)$")){
			System.out.println("윈도우 사용중이시네요!");
		}				
		
		System.out.println(prop.getProperty("java.version")); //자바 버전
		
		System.out.println(prop.getProperty("user.home")); //사용자 기본폴더 
		
		//[3] 프로그램 종료를 요청할 수 있다
		//= 종료상태를 정수로 전달할 수 있다
		//= 0은 정상종료, 0이 아니면 비정상종료로 인식함
		//= 오류 상태 번호는 정하기 나름
		
		System.exit(0);
		System.out.println("이 메시지는 나오지 않습니다");
	}
}
