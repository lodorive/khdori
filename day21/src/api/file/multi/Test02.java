package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		//준비물
		File target = new File("sample/multi.kh");
		
		FileOutputStream stream = new FileOutputStream(target); //메인스트림
		BufferedOutputStream buffer = new BufferedOutputStream(stream, 10); //보조스트림
		DataOutputStream data = new DataOutputStream(buffer);
		
		//구조
		//[프로그램] -> data(분해) -> buffer(임시저장) -> stream(통로)
		//											-> target(파일) -> [실제파일]
		
		//data에게 각종 원시형 데이터를 전달
		//= 자료형에 다라서 분해방식이 달라진다! 명령이 자료형별로 존재!
		data.writeInt(100);
		data.writeDouble(100);
		data.writeChar(100);
		data.writeFloat(100);
		data.writeLong(100);
		
		//정리(+버퍼 지우기 -flush)
		//data.flush(); //앞으로도 전송할 것이 있을 때(네트워크 통신에서 많이 사용)
		data.close(); //앞으로는 전송할 일이 없을 때(파일에서 많이 사용)
	}
}
