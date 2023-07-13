package api.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test05 {
	public static void main(String[] args) {
		//집합 연산 문제
		
		Set<String> people1 = Set.of("범죄도시3","늑대사냥","드림","퍼펙트게임");
		Set<String> people2 = Set.of("파수꾼","늑대사냥","리바운드","익스트랙션2","드림");
		
		//[1] 둘 다 본 영화를 구하라(교집합)
		Set<String> inter = new HashSet<>();
		inter.addAll(people1);
		inter.retainAll(people2);
		System.out.println("둘 다 본 영화 : "+inter);
		
		//[2] 둘 중 한 명만 본 영화를 구하라(차집합)
		//(1) (a-b) ∪ (b-a)
		//(2) (a ∪ b) - (a ∩ b)
		
		//(1)
		Set<String> a_b = new HashSet<>();
		a_b.addAll(people1);
		a_b.removeAll(people2);
		Set<String> b_a = new HashSet<>();
		b_a.addAll(people2);
		b_a.removeAll(people1);
		Set<String> result1 = new HashSet<>();
		result1.addAll(a_b);
		result1.addAll(b_a);
		System.out.println("둘 중 한명만 본 영화 = " + result1);

		//(2)
		Set<String> all = new HashSet<>();
		all.addAll(people1);
		all.addAll(people1);
		all.removeAll(inter);
		System.out.println("둘 중 한명만 본 영화 = " + all);
		
		//내가 푼거
		Set<String> minus = new HashSet<>();
		minus.addAll(people1);
		minus.removeAll(people2);
		System.out.println("철수만 본 영화 : "+minus);
		minus.addAll(people2);
		minus.removeAll(people1);
		System.out.println("영희만 본 영화 : "+minus);
		
		//Set도 전체 출력이 된다
		//=확장 반복(foreach)은 가능
		for(String name : all){
			System.out.println("name : "+name);
		}
	}
}
