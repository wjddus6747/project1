package project1;

import java.util.Scanner;

import ver02.PhoneInfo;

public class PhoneBookVer2
{

	public static void main(String[] args)
	{
		String name = null;
		String phoneNumber = null;
		String birthday = null;

		System.out.println("1.데이터입력");
		System.out.println("2.프로그램종료");

		while (true)
		{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1)
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("이름 : ");
				name = scan.nextLine();

				System.out.println("핸드폰번호 : ");
				phoneNumber = scan.nextLine();

				System.out.println("생년월일 : ");
				birthday = scan.nextLine();
				
				PhoneInfo p1 = new PhoneInfo(name, phoneNumber, birthday);
				p1.showPhoneInfo();
				System.out.println("1.데이터입력");
				System.out.println("2.프로그램종료");
				continue;
			} else
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		
	}

}
