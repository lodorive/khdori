package api.util.collection;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//Java Collection Framework(JCF)
		//= 자바에서 대용량 데이터를 저장하기 위해 고안한 시스템
		//= 자료구조(Date Structure)의 개념을 구현해 놓은 클래스들이 존재
		//= List, Tree, Hash, Stack, Queue, Deque, ...
		//= 배열은 크기가 고정이며 변할 수 없는데 Collection은 가변이 기본 컨셉
		
		ArrayList a = new ArrayList();
		TreeSet b = new TreeSet();
		Stack c = new Stack();
		
		a.add("유재석");	b.add("유재석");	c.add("유재석");
		a.add("이효리");	b.add("이효리");	c.add("이효리");
		a.add("김채원");	b.add("김채원");	c.add("김채원");
		a.add("유태오");	b.add("유태오");	c.add("유태오");
		a.add("지수");		b.add("지수");		c.add("지수");
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
	}
}
