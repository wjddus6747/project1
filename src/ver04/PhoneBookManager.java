package ver04;

import java.util.Scanner;
import ver04.PhoneInfo;

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
		String name, phoneNumber, major, com_name ;
		int grade;
		
		System.out.println("데이터입력을 시작합니다.");
		System.out.println("1.일반");
		System.out.println("2.동창");
		System.out.println("3.회사");
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 : ");
		name = scan.nextLine();
		System.out.println("핸드폰번호 : ");
		phoneNumber = scan.nextLine();
		
		if(number==1) {
			System.out.println("데이터입력이 완료되었습니다.");
			
			PhoneInfo p1 = new PhoneInfo(name, phoneNumber);
			Book[numfriend++] = p1;
		}
		else if(number==2) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("전공: " );
			major = scan2.nextLine();
			System.out.println("학년: " );
			grade= scan2.nextInt();
			System.out.println("데이터입력이 완료되었습니다.");
			PhoneSchoolInfo school = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			Book[numfriend++] = school;
		}
		else if(number==3) {
			Scanner scan3 = new Scanner(System.in);
			System.out.println("회사명 : ");
			com_name = scan3.nextLine();
			System.out.println("데이터입력이 완료되었습니다.");
			PhoneCompanyInfo company = new PhoneCompanyInfo(name, phoneNumber, com_name);
			Book[numfriend++] = company;
		}
		
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









