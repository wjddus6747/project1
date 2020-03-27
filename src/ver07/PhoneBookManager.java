package ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import ver07.PhoneInfo;

public class PhoneBookManager implements SubMenuItem
{
	HashSet<PhoneInfo> Book = new HashSet<PhoneInfo>();
	// PhoneInfo[] Book = new PhoneInfo[100];

	// 메뉴츨력
	public void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택: ");
	}

	// 입력
	public void dataInput()
	{
		String name, phoneNumber, major, com_name;
		int grade;

		System.out.println("데이터입력을 시작합니다.");
		System.out.println("1.일반");
		System.out.println("2.동창");
		System.out.println("3.회사");

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int an = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("핸드폰번호 : ");
		phoneNumber = scan.nextLine();

		if (number == GENERAL)
		{
			if (Book.add(new PhoneInfo(name, phoneNumber)) == false)
			{
				System.out.println("중복됨 덮어쓰시겠습니까(1:예 2:아니오)");
				Scanner s = new Scanner(System.in);
				an = s.nextInt();
				if (an == 1)
				{
					Book.remove(new PhoneInfo(name, phoneNumber));
					Book.add(new PhoneInfo(name, phoneNumber));
				} else if (an == 2)
				{
					
					// Book.add(new PhoneInfo(name, phoneNumber));
				}
			} else if (Book.add(new PhoneInfo(name, phoneNumber)) == true)
			{
				Book.add(new PhoneInfo(name, phoneNumber));
				System.out.println("데이터입력이 완료되었습니다.");
			}

		} else if (number == COLLEGE)
		{
			Scanner scan2 = new Scanner(System.in);
			System.out.print("전공: ");
			major = scan2.nextLine();
			System.out.print("학년: ");
			grade = scan2.nextInt();

			if (Book.add(new PhoneSchoolInfo(name, phoneNumber, major, grade)) == true)
			{
				Book.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				System.out.println("데이터입력이 완료되었습니다.");
			} else if (Book.add(new PhoneSchoolInfo(name, phoneNumber, major, grade)) == false)
			{
				System.out.println("중복됨 덮어쓰시겠습니까(1:예 2:아니오)");
				Scanner s = new Scanner(System.in);
				an = s.nextInt();
				if (an == 1)
				{

					Book.remove(new PhoneSchoolInfo(name, phoneNumber, major, grade));
					Book.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				} else if (an == 2)
				{
					// Book.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				}
			}
		} else if (number == GRADE)
		{
			Scanner scan3 = new Scanner(System.in);
			System.out.print("회사명 : ");
			com_name = scan3.nextLine();

			if (Book.add(new PhoneCompanyInfo(name, phoneNumber, com_name)) == true)
			{
				Book.add(new PhoneCompanyInfo(name, phoneNumber, com_name));
				System.out.println("데이터입력이 완료되었습니다.");
			} else if (Book.add(new PhoneCompanyInfo(name, phoneNumber, com_name)) == false)
			{
				System.out.println("중복됨 덮어쓰시겠습니까(1:예 2:아니오)");
				Scanner s = new Scanner(System.in);
				an = s.nextInt();
				if (an == 1)
				{
					Book.remove(new PhoneCompanyInfo(name, phoneNumber, com_name));
					Book.add(new PhoneCompanyInfo(name, phoneNumber, com_name));
				} else if (an == 2)
				{

					// Book.add(new PhoneCompanyInfo(name, phoneNumber, com_name));
				}
			}
		}
	}

	// 검색
	public void dataSearch()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터검색을 시작합니다.");
		System.out.print("이름:");
		String serach = sc.nextLine();
		boolean searchCheck = false;

		Iterator<PhoneInfo> itr = Book.iterator();
		while (itr.hasNext())
		{
			PhoneInfo phoneInfo = itr.next();
			if (serach.equals(phoneInfo.name))
			{
				searchCheck = true;
				phoneInfo.showPhoneInfo();
			}
		}
		if (searchCheck == true)
		{
			System.out.println("데이터검색이 완료되었습니다.");
		} else
		{
			System.out.println("검색하신 데이터가 없습니다.");
		}
	}

	// 삭제
	public void dataDelete()
	{
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		Scanner sc = new Scanner(System.in);
		String deletename = sc.nextLine();
		boolean deletenameCheck = false;

		Iterator<PhoneInfo> itr = Book.iterator();
		while (itr.hasNext())
		{
			PhoneInfo phone = itr.next();
			if (deletename.equals(phone.name))
			{
				deletenameCheck = true;
				System.out.println(Book.remove(phone));
			}
		}
		if (deletenameCheck == true)
		{
			System.out.println("데이터삭제가 완료되었습니다.");
		} else
		{
			System.out.println("삭제된 데이터 없습니다.");
		}
	}

	// 전체출력
	public void dataAllShow()
	{
		Iterator<PhoneInfo> itr = Book.iterator();
		while (itr.hasNext())
		{
			PhoneInfo pi = itr.next();
			pi.showPhoneInfo();
		}
	}
}
