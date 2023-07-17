package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//객체 입출력		
		Date d = new Date();
		
		//준비물
		File target = new File("sample/object.kh");	
		
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		//DataOutputStream data = new DataOutputStream(buffer); //분해
		ObjectOutputStream obj = new ObjectOutputStream(buffer); //직렬화+분해
		
		obj.writeObject(d);
		
		//정리
		obj.close();
		
	}
}
