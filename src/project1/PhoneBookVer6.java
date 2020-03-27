package project1;

import java.io.EOFException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.MenuSelectionManager;

import ver06.PhoneBookManager;
import ver06.PhoneInfo;
import ver06.MenuSelectException;
import ver06.MenuItem;

public class PhoneBookVer6 implements MenuItem
{

	public static void main(String[] args)
	{
		PhoneBookManager pbm = new PhoneBookManager();
		pbm.printMenu();

		while (true)
		{
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			try
			{
				choice = sc.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.println("문자를 입력했습니다.");
				pbm.printMenu();
				continue;
			}

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

			else if (choice > 5 || choice < 1)
			{
				MenuSelectException excep = new MenuSelectException();
				try
				{
					throw excep;
				} catch (MenuSelectException e)
				{
					System.out.println(e.getMessage());
					pbm.printMenu();
					continue;
				}
			}
		}
	}
}
