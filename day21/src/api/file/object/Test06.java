package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test06 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//Test05에서 저장한 Student 객체를 입력하여 정보 출력
		
		File target = new File("sample/student.kh");
		
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream obj = new ObjectInputStream(buffer);
		
		Student st = (Student) obj.readObject();
		
		obj.close();
		
		System.out.println("name = "+st.getName());
		System.out.println("score = "+st.getScore());
	
	}
}
