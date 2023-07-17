package api.file.single2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//파일 복사 프로그램(바이트 배열 - 버퍼 사용)	
		
		File readTarget = new File("D:/origin.txt");
		FileInputStream readStream = new FileInputStream(readTarget);
		
		File writeTarget = new File("./sample/copy.txt"); 
		FileOutputStream writeStream = new FileOutputStream(writeTarget);	
		
		byte[] buffer = new byte[1024]; 

		
		long start = System.currentTimeMillis();
		
		while(true) {
			int size = readStream.read(buffer); 
			if(size == -1) break;
			writeStream.write(buffer,0,size);
			
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("실행 시간 : "+(finish-start));
			
		readStream.close();
		writeStream.close();
		
	}
}

