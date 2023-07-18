package api.file.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
		//문자열 입력
		//[1] 일정 글자 수만큼 지정해서 읽는 방법 (=FileReader)
		//[2] 줄단위로 읽는 방법 (=BufferedReader)
		
		File target = new File("sample/string.kh");
		
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
		String line = br.readLine();
		if(line == null) break;
		System.out.println("line = "+line);		
		}		
		br.close();
	}
}
