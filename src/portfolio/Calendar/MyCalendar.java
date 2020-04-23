package portfolio.Calendar;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

class MyCalendar {
	public String[] cal(int year, int month) {
		String[] three = new String[42];
		Scanner scanner = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		int i, j,  l = 0;
		int cnt = 0;
		int cnt2, dateYS;
		int[] mon = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		char[] date = { '일', '월', '화', '수', '목', '금', '토' };
		for (i = 1; i < year; i++) {
			if ((i % 4) == 0 && (i % 100) != 0 || (i % 400) == 0) {
				cnt += 366;
			} else {
				cnt += 365;
			}
		}
		if ((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0) {
			mon[1]=29;
		}
		for (i = 0; i < month - 1; i++) {
			cnt += mon[i];
		}
		i = 0;
		j = 0;
		cnt2 = 0; // 날짜 출력하기 위한 카운트
		dateYS = (cnt) % 7; // 이번년도 1월 1일 요일 구하기
		l = 0;
		while (cnt2 < mon[month - 1]) {
			if (l <= dateYS) { // 시작일까지는 *
				three[l] = "";
				l++;
			} else if (cnt2 < mon[month - 1]) {
				cnt2++; // 날짤 출력카운트
				three[l] = String.valueOf(cnt2);
				l++;
			}
		}
		for (i = 0; i < three.length; i++) {
			if (three[i] == null) {
				three[i] = "";
			}
		}
		return three;
	}
}
