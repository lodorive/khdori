package api.collection4;

import java.util.LinkedList;
import java.util.Queue;

public class Test02 {
	public static void main(String[] args) {
		//큐(Queue)
		//=대기열을 구현할 때 사용하는 저장소
		
		//List<String> queue = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
		
		//추가 - offer()
		queue.offer("홍길동");
		queue.offer("임꺽정");
		queue.offer("허준");
		queue.offer("장보고");
		
		//확인
		System.out.println(queue.peek()); //누가 나갈 준비가 되었니?
		
		queue.poll(); //내보내라
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		queue.poll();
		System.out.println(queue.peek());
		
		System.out.println(queue);
	}
}
