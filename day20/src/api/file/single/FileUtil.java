package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	//파일 복사 메소드
	public static void copy(File readTarget, File writeTarget) throws IOException {
		
		//준비물 : 입력용파일+스트림, 출력용파일+스트림
	
		FileInputStream readStream = new FileInputStream(readTarget);
		FileOutputStream writeStream = new FileOutputStream(writeTarget);
		
		//한 글자만 복사
		
		while(true) {
		int a = readStream.read();
		if(a == -1) break;
		writeStream.write(a);
		}
		
		//정리
		readStream.close();
		writeStream.close();
		
	}
}

