package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		//파일 복사 프로그램
		
		File readTarget = new File("D:/origin.txt"); //절대경로
		FileInputStream readStream = new FileInputStream(readTarget);
		
		List<Integer> list = new ArrayList<>();
		
		while(true) {
			int a = readStream.read();
			if(a == -1) break;
			list.add(a);
		}
		
		readStream.close();
		
		//---------------------------------------------
		File writeTarget = new File("./sample/copy.txt");//상대경로(relative path)
		FileOutputStream writeStream = new FileOutputStream(writeTarget);

		for(int i=0; i < list.size(); i++) {
			writeStream.write(list.get(i));
		}

		//정리
		writeStream.close();
		
	}
}
