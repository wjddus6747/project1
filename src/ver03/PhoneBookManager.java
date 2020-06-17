package ver03;

import java.util.Scanner;
import ver03.PhoneInfo;

public class PhoneBookManager
{
	PhoneInfo[] Book = new PhoneInfo[100];
	int numfriend=0;
	
	//메뉴츨력
	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택: ");
	}
	
	//입력
	public void dataInput() {
		String name = null;
		String phoneNumber = null;
		String birthday = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 : ");
		name = scan.nextLine();

		System.out.println("핸드폰번호 : ");
		phoneNumber = scan.nextLine();

		System.out.println("생년월일 : ");
		birthday = scan.nextLine();
		System.out.println("데이터입력이 완료되었습니다.");
		
		PhoneInfo p1 = new PhoneInfo(name, phoneNumber, birthday);
		Book[numfriend++] = p1;
	}
	//검색
	public void dataSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터검색을 시작합니다.");
		System.out.println("이름:");
		String serach= sc.nextLine();
		for(int i=0; i<numfriend; i++) {
			if(serach.compareTo(Book[i].name) == 0) {
				Book[i].showPhoneInfo();
				
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
	}
	//삭제
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("이름:");
		Scanner sc = new Scanner(System.in);
		String deletename = sc.nextLine();
		
		int deleteindex=-1;
		for(int i=0; i<numfriend; i++) {
			if(deletename.compareTo(Book[i].name)==0) {
				Book[i] = null;
				numfriend--;
				deleteindex = i;
			}
		}
		if(deleteindex==-1) {
			System.out.println("삭제된 데이터 없습니다.");
		}
		else {
			for(int j=deleteindex; j<numfriend; j++) {
				Book[j] = Book[j+1];
			}
		}
		System.out.println("데이터삭제가 완료되었습니다.");
	}
	//전체출력
	public void dataAllShow() {
		for(int i=0; i<numfriend; i++) {
			Book[i].showPhoneInfo();
		}
	}
}









