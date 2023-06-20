package data;

public class Test10 {
	public static void main(String[] args) {
		//어제 2시간 45분, 오늘 1시간 50분 공부 총 공부시간
		//시간은 가장 작은 단위로 변환하여 푼다
		
		//입력
		int yesterdayHour = 2 , yesterdayMin = 45;
		int todayHour = 1 , todayMin = 50;
		
		//계산
		int yesterdayTime = yesterdayHour * 60 + yesterdayMin;
		int todayTime = todayHour * 60 + todayMin;
		
		int time = yesterdayTime + todayTime;
		int hour = time / 60;
		int min = time % 60;
		
		//출력
		System.out.println(hour);
		System.out.println(min);
	}
}
