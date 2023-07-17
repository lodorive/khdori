package api.file.object;

import java.io.Serializable;

//클래스를 만들 때 파일로도 저장할 계획이라면 마킹(marking)을 해야 함
// =java.io.Serialzable 인터페이스를 상속받으면 해결

//[1] 클래스의 버전을 설정할 수 있다.
//= 의도적으로 클래스를 관리할 수 있다

//[2] 필드 중에서 특정 항목을 입출력에서 제외시킬 수 있다
//= 저장하지 않을 필드에 transient 키워드를 추가
public class Student implements Serializable {
	private static final long serialVersionUID = 2L;
	private String name;
	private transient int score;//입출력 제외
	public Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
