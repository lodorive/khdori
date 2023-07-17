package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//멀티바이트 입력
		
		//준비물
		File target = new File("sample/multi.kh");
		
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		//구조
		//[프로그램] <- data(조립) <- buffer(임시저장) 
		//				<- stream(통로)<- target(파일) <- [실제파일]
				
		int a = data.readInt();
		double b = data.readDouble();
		char c = data.readChar();
		float d = data.readFloat();
		long e = data.readLong();
		
		//정리
		data.close();
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		System.out.println("d = "+d);
		System.out.println("e = "+e);
	 			
	}
}
