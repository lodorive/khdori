package api.exception;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		 Calendar cal = Calendar.getInstance();
		 
		try {
				Scanner sc = new Scanner(System.in);
				
				System.out.print("생년월일 입력 : ");
				String input = sc.next();	
		
				sc.close();
				
						
				int year = Integer.parseInt( input.substring(0,4));
				if(year < 1900) {
					throw new Exception("연도를 1900 이상으로 입력하세요");
				}
				
				int month = Integer.parseInt(input.substring(5,7));
				if(month < 1 || month > 12) {
					throw new Exception("월을 1~12 사이로 입력하세요");
				}
				
				int day = Integer.parseInt(input.substring(8,10));
				if(day > 31) {
					throw new Exception("31일을 넘길 수 없습니다");
				}
				
				int thisYear = cal.get(Calendar.YEAR);
				int thisMonth = cal.get(Calendar.MONTH) + 1;
				int thisDay = cal.get(Calendar.DAY_OF_MONTH);
				
				int koreanAge = thisYear-year +1;
				int americanAge = thisYear-year-1;
				if(month <= thisMonth) {
					americanAge++; }
			
				int thisLast = thisYear*100+thisMonth*100+thisDay;
				int inputLast = year*100+month*100+day;
			
				
				if(thisLast < inputLast) {
					throw new Exception("현재보다 미래의 값은 입력할 수 없습니다");
				}
		
				System.out.println("한국 나이 : "+koreanAge);
				System.out.println("만 나이 : "+americanAge);
				}
				
				catch(Exception e) {
					
					if(e.getMessage() == null) {
						System.err.println("입력값이 너무 짧거나 숫자 변환이 올바르지 않습니다");
					}
					else {
					System.err.println(e.getMessage());
					}
				}
			}
		}