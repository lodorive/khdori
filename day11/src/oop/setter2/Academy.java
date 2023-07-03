package oop.setter2;

public class Academy {

	String title; //강좌명
	int period; //강의시간
	int price; //수강료
	String type; //구분
	
	
	void setTitle(String title) {
		this.title = title;
	}
	
	void setPeriod(int period) {
		if(period > 0 && period % 30 == 0) { //음수도 30의 배수이기 때문에 0 이상을 적어주기
			this.period = period;
		}
	}	
	void setPrice(int price) {
			if(price >= 0) {
			this.price = price;
	}
		}
	//void setPrice(int price){ //위 방법과 둘 중 하나 쓰면 됨
	//	if(pirice <0{ //조건이 많을시 사용
	//		return; // 반환은 없지만 중지하세요!
	//		}	
	// 	this.price = price;
	//}
	
	void setType(String type) {
		switch(type) {
		case "온라인":
		case "오프라인":
		case "혼합":
			this.type = type;
		}		
	}
	
	void setup(String title, int period, int price, String type) {
		this.setTitle(title);
		this.setPeriod(period);	
		this.setPrice(price);
		this.setType(type);
}
	
	void show() {
		System.out.println("<강좌 정보>");
		System.out.println("이름 : "+this.title);
		System.out.println("시간 : "+this.period);
		System.out.println("가격 : "+this.price);
		System.out.println("유형: "+this.type);
		System.out.println();
	}
	
}
