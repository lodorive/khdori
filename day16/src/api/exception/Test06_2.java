package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test06_2 {
	public static void main(String[] args) {
		System.out.println(DateCalculator.getMonthDay(2023, 7));
		
		//만약에 2021-03-15일생이면
		int total = 0;
		total += 365 - DateCalculator.getYearDay(2023, 3, 15) +1;
		total += 365;
		total += DateCalculator.getYearDay(2023, 7, 11);
		System.out.println("total = "+total);
		}
	}