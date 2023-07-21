package jdbc;

public class Test01 {
	public static void main(String[] args) {
		//JDBC(Java DataBase Connectivity)
		//= 자바를 이용해서 데이터베이스 작업을 하는 것
		//= 데이터베이스 구문을 프로그램에 작성하여 처리하도록 중계
		
		//(ex) 포켓몬스터 테이블에 데이터를 등록하는 작업
		
		//[1] 구문을 세미콜론 제외하고 준비
		String sql = "insert into pocketmon(no, name, type) "
					  + "values(43,'뚜벅초','풀')";
		
		//DB가 어떤건지 계정은 뭔지 비밀번호는 뭔지 정보가 없다
		//통신을 내가 구현할 것이 아니라면 도구를 찾아야 한다
		//프로젝트 우클릭 → Build path → Configure build path → Libraries에 복사		
	}
}
