package api.lang.string;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		//욕설 필터링 프로그램
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문장 입력 : ");
		String line = sc.nextLine();
		sc.close();
		
		String star = "*";
		
		String[] filter = new String[] {
		"수박씨","신발끈","개나리","십장생","시베리아",
		"주옥","조카","게불","10원"
		};
		
		//수박씨만 필터링
		//line = line.replace("수박씨","***");
		
		for(int i = 0; i<filter.length; i++){
			int count = filter[i].length();
			line = line.replace(filter[i], star.repeat(count));
		}
		System.out.println(line);
	}
}
