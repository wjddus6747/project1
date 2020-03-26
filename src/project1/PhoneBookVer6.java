package project1;

import java.util.Scanner;

import javax.swing.MenuSelectionManager;

import ver05.PhoneBookManager;
import ver05.PhoneInfo;
import ver05.MenuItem;

public class PhoneBookVer6 implements MenuItem
{

	public static void main(String[] args)
	{
		

		PhoneBookManager pbm = new PhoneBookManager();
		pbm.printMenu();
		try {
		while (true)
		{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == INPUT)
			{
				pbm.dataInput();
				pbm.printMenu();
				continue;
			} 
			else if(choice==SEARCH) {
				pbm.dataSearch();
				pbm.printMenu();
				continue;
			}
			else if(choice==DELETE) {
				pbm.dataDelete();
				pbm.printMenu();
				continue;
				
			}
			else if(choice==ALLSHOW) {
				pbm.dataAllShow();
				pbm.printMenu();
				continue;
			}
			else if(choice==EXIT)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("1~5만 입력하세요");
		}
		
		
	}

}
