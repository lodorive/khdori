package api.file.object;

import java.io.IOException;
import java.util.Scanner;

public class Test07_7 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일이 있을 때와 없을 때 모두 처리되도록 구현
		Player player = GameUtil.load();

		//메뉴 표시
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("<내가 만든 게임>");
			System.out.print("1-정보보기 / 2-레벨업 / 3 - 종료 : ");
			int choice = sc.nextInt();

			if(choice == 1) {
				player.show();
			}
			else if(choice == 2) {
				player.levelUp();
			}
			else if(choice == 3) {
				break;
			}
		}
		sc.close();

		GameUtil.save(player);
	}
}



