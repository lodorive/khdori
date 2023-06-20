package data;

public class Test10_1 {
	public static void main(String[] args) {
		//사람이 푸는 방식으로 풀이
		
		//입력
		int yesterdayHour = 2, yesterdayMin = 45;
		int todayHour = 1, todayMin = 50;
		
		//계산
		int totalMin = (yesterdayMin + todayMin) % 60;
		int totalHour = yesterdayHour + todayHour +  (yesterdayMin + todayMin) / 60;
		
		//출력
		System.out.println(totalHour);
		System.out.println(totalMin);
	}
}
