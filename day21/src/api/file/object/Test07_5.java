package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test07_5 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일이 있을 때와 없을 때 모두 처리되도록 구현

		//Player player = 신규생성 or 불러온 객체;
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
			player = new Player("테스트");
		}

		//player.setLevel(player.getLevel() + 1);
		player.levelUp();

		player.show();

		//출력
		FileOutputStream stream2 = new FileOutputStream(target);
		BufferedOutputStream buffer2 = new BufferedOutputStream(stream2);
		ObjectOutputStream obj2 = new ObjectOutputStream(buffer2);

		obj2.writeObject(player);

		obj2.close();
	}
}
