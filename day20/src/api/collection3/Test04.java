package api.collection3;

import java.util.Map;
import java.util.Set;

public class Test04 {
	public static void main(String[] args) {
		//Map의 전체출력
		//Map<String, Integer> vote = new HashMap<>();
		Map<String, Integer> vote = Map.of("아이유", 5, "피카츄", 2, "영탁", 4, "마리오", 10);
		
		//Map에서 Key만 보면 Set의 형태이다
		//-> 일단 Key만 추출하여 출력하고, value는 그때그때 가져와서 사용
		Set<String> names = vote.keySet(); //vote의 key만 뽑아서 추출
		
		for(String name : names) {
			int count = vote.get(name);
			System.out.println("이름 = "+name+", 득표수 = "+count);
		}
	}
}
