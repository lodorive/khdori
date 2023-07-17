package api.file.single2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Test03_2 {
	public static void main(String[] args) throws IOException {
		//파일 복사 프로그램(바이트 배열 - 버퍼 사용) 풀이
		
		//배열 준비
		byte[] buffer = new byte[10]; 
		
		//대상 준비
		File readTarget = new File("D:/origin.txt");
		File writeTarget = new File("./sample/copy.txt"); 
		
		//스트림 준비
		FileInputStream readStream = new FileInputStream(readTarget);
		BufferedInputStream readBuffer = new BufferedInputStream(readStream);
		
		FileOutputStream writeStream = new FileOutputStream(writeTarget);
		BufferedOutputStream writeBuffer = new BufferedOutputStream(writeStream); //보조스트림
		
		//[읽을파일] -> readTarget -> readStream -> [프로그램]
		//			->  writeStream -> writeTarget -> [내보낼파일]
		
		long count = 0L;
		long total = readTarget.length(); //전체 옮길 글자수
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		
		long start = System.currentTimeMillis();
		
		while(true) {
			int size = readStream.read(buffer); 
			if(size == -1) break;
			writeStream.write(buffer,0,size);
			count += size;
			double percent = count * 100d / total;
			System.out.println(count + "/" + total + "("+fmt.format(percent)+"%)");
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("실행 시간 : "+(finish-start));
		
		//파일 통로 정리
		readBuffer.close(); //마지막으로 사용한걸 종료해주면 됨
		writeBuffer.close();
		
	}
}

