package project1;

import java.util.Scanner;

import ver08.PhoneBookManager;
import ver08.PhoneInfo;
import ver08.MenuItem;

public class PhoneBookVer8 implements MenuItem
{

	public static void main(String[] args)
	{

		PhoneBookManager pbm = new PhoneBookManager();
		pbm.printMenu();

		while (true)
		{
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			choice = sc.nextInt();

			if (choice == INPUT)
			{
				pbm.dataInput();
				pbm.printMenu();
				continue;
			} else if (choice == SEARCH)
			{
				pbm.dataSearch();
				pbm.printMenu();
				continue;
			} else if (choice == DELETE)
			{
				pbm.dataDelete();
				pbm.printMenu();
				continue;
			} else if (choice == ALLSHOW)
			{
				pbm.InPhoneInfo();
				pbm.dataAllShow();
				pbm.printMenu();
				continue;
			} else if (choice == EXIT)
			{
				pbm.savePhoneInfo();
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
