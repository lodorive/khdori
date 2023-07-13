package api.collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test04 {
	public static void main(String[] args) {
		//다른 저장소를 이용하여 생성		
		//List<Integer> list = new ArrayList<>();
		//list.add(10);
		//list.add(10);
		//list.add(20);
		//list.add(30);
		
		//데이터가 정해져 있는 경우 불변 리스트 생성(Java 8+)
		//List<Integer> list = Arrays.asList(10,10,20,30);
		
		//Java 9+ 
		List<Integer> list = List.of(10,10,20,30);
		System.out.println("list = "+list);
		
		//[Q] list에 들어있는 데이터를 중복 제거하고 나열
		Set<Integer> set = new TreeSet<>(list); 
		System.out.println("set = "+set);
		
		//Set을 이용하면 집합 연산을 할 수 있다
		Set<Integer> a = Set.of(30,50,20); //Java 9+ 이상
		Set<Integer> b = Set.of(30,20,40,10);
		
		//합집합(Union)
		//-중복을 제거할건지 제거하지 않을건지
		//-중복을 제거할거면 Set, 제거하지 않을거면 List
		Set<Integer> union1 = new TreeSet<>();
		union1.addAll(a);
		union1.addAll(b);
		System.out.println("합집합(중복제거) = "+union1);
		
		//union2란 이름으로 중복을 허용하고 합집합을 구해보세요
		List<Integer> union2 = new ArrayList<>();
		union2.addAll(a);
		union2.addAll(b);
		Collections.sort(union2);
		System.out.println("합집합(중복허용) = "+union2);
		
		//교집합(Intersection)
		//=두 집합이 모두 가진 요소들만으로 이루어진 집합
		
		Set<Integer> inter = new TreeSet<>();
		inter.addAll(a);
		inter.retainAll(b);
		System.out.println("교집합 = "+inter);
		
		//차집합(minus/except)
		Set<Integer> minus = new TreeSet<>();
		minus.addAll(a);
		minus.removeAll(b);
		System.out.println("차집합 = "+minus);
	}
}
