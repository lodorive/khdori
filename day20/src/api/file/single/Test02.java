package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		
		//준비물
		//1. 대상 파일 객체
		//2. 입력용 스트림
		
		File farget = new File("sample", "single.kh");
		FileInputStream stream = new FileInputStream(farget);	
		
		//[프로그램]<-[입력통로(stream)]<-[파일객체(target)]<-[실제파일]
		
		while(true) {
			int a = stream.read();
			if(a == -1) break;//EOF(End Of File) 처리
			System.out.println("a = " + a);
		}

		stream.close();
			
		}
}
