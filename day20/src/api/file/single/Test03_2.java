package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class Test03_2 {
	public static void main(String[] args) throws IOException {
		//파일 복사 프로그램
		
		File readTarget = new File("D:/origin.txt"); //절대경로		
		File writeTarget = new File("./sample/copy.txt"); //상대경로

		FileUtil.copy(readTarget, writeTarget);
		
	}
}
