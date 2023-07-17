package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test07_2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//sample/player.kh에 저장된 객체를 불러와서 정보 출력

		File target = new File("sample/player.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream obj = new ObjectInputStream(buffer);

		Player player = (Player) obj.readObject();

		obj.close();

		player.show();

	}
}