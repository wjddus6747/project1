package project1;

import java.util.Scanner;

import ver07.PhoneBookManager;
import ver07.PhoneInfo;
import ver07.MenuItem;

public class PhoneBookVer7 implements MenuItem
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
				pbm.dataAllShow();
				pbm.printMenu();
				continue;
			} else if (choice == EXIT)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
