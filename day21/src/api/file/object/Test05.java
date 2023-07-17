package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05 {
	public static void main(String[] args) throws IOException {
		//Student의 객체를 파일에 출력
		Student st = new Student("테스트", 50);

		//출력
		File target = new File("sample/student.kh");

		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);

		obj.writeObject(st);

		obj.close();
	}
}
