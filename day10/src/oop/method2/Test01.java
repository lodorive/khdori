package oop.method2;

public class Test01 {
	public static void main(String[] args) {
		
		//생성
		Olympic o1 = new Olympic();
		Olympic o2 = new Olympic();
		Olympic o3 = new Olympic();
		
		//초기화
		o1.setup("진종오", "사격", "하계", 4, 2, 0);
		o2.setup("김수녕", "양궁", "하계", 4, 1, 1);
		o3.setup("전이경",	"쇼트트랙",	"동계", 4, 0, 1);
		
		//출력
		o1.show();
		o2.show();
		o3.show();
	}
}
