package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test07_1 {
	public static void main(String[] args) throws IOException {
		//만들어진 객체를 sample/player.kh에 저장

		Player player = new Player("테스트");
		player.show();

		File target = new File("sample/player.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);

		obj.writeObject(player);

		obj.close();

	}
}
