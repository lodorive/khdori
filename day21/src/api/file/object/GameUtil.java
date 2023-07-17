package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

//도우미 클래스
public class GameUtil {
	//케릭터 불러오기
	public static Player load() throws IOException, ClassNotFoundException {
		Player player;
		File target = new File("sample/player.kh");
		if(target.exists()) {//파일이 있으면
			FileInputStream stream = new FileInputStream(target);
			BufferedInputStream buffer = new BufferedInputStream(stream);
			ObjectInputStream obj = new ObjectInputStream(buffer);
			player = (Player) obj.readObject();
			obj.close();
		}
		else {//파일이 없으면
			Scanner sc = new Scanner(System.in);
			System.out.println("처음 오셨네요");
			System.out.print("아이디 설정 : ");
			String id = sc.nextLine();
			player = new Player(id);
			//sc.close();//닫아버리면 다른데서 입력을 못받음
		}
		return player;
	}

	//케릭터 저장하기
	public static void save(Player player) throws IOException {
		File target = new File("sample/player.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);

		obj.writeObject(player);

		obj.close();
	}

	public static void play() throws ClassNotFoundException, IOException {
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
