package api.file.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test07_4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//파일을 불러와서 출력하고 레벨 1증가시킨 뒤 저장

		//입력
		File target = new File("sample/player.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream obj = new ObjectInputStream(buffer);

		Player player = (Player) obj.readObject();

		obj.close();

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