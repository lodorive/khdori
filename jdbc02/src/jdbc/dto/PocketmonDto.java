package jdbc.dto;

//DTO 클래스
//= Data Transfer Object. 데이터 변환용 객체(포장 상자)
//= 데이터베이스의 한 줄을 그대로 옮겨담기 위한 자바 Wrapper(포장) 클래스
public class PocketmonDto {

	//필드는 데이터베이스의 컬럼과 동일하게 작성
	private int no;
	private String name;
	private String type;
	
	//기본 생성자와 setter/getter 메소드를 추가, toString() 재정의	
	public PocketmonDto() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "PocketmonDto [no=" + no + ", name=" + name + ", type=" + type + "]";
	}
	
}
