package api.file;

import java.io.File;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		File a = new File(sc.nextLine());

		if (a.isFile()) {
			System.out.println("<파일 정보>");
			System.out.println("이름 : "+a.getName());
			
			//확장자는 파일의 마지막 . 뒤에 있는 값을 말하며 없을 수 있다
			//(ex) abc.def.ghi면 확장자는 ghi이다
			int index = a.getName().lastIndexOf(".");
			String extension;
			if(index == -1) {
				extension = "없음";
			}
			else {
				extension = a.getName().substring(index+1);
			}
			
			System.out.println("확장자: "+extension);
			System.out.println("크기 : "+a.length()+"bytes");
		}
		else	if(a.isDirectory()) {//디렉터리면 목록[파일/폴더]	
			
			File[] files = a.listFiles(); //파일 객체를 추출		
			
			for(File file : files) {	
					if(file.isFile()) {
					System.out.print("[파일]");
				}
					else{
					System.out.print("[폴더]");
				}			
					System.out.println(file.getName());
		}
			}
			else {
				System.out.println("존재하지 않는 파일 또는 폴더");
			}
	}
}

