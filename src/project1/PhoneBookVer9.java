package project1;

import java.util.Scanner;

import ver09.PhoneBookManager;
import ver09.PhoneInfo;

public class PhoneBookVer9
{
	
	public static void main(String[] args)
	{
		

		PhoneBookManager pbm = new PhoneBookManager();
		pbm.printMenu();
		pbm.ConnectionOracle();
		
		while (true)
		{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice == 1)
			{
				pbm.dataInput();
				pbm.printMenu();
				continue;
			} 
			else if(choice==2) {
				pbm.dataSearch();
				pbm.printMenu();
				continue;
			}
			else if(choice==3) {
				pbm.dataDelete();
				pbm.printMenu();
				continue;
			}
			else if(choice==4) {
				pbm.dataAllShow();
				pbm.printMenu();
				continue;
			}
			else 
			{	pbm.close();	
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		
	}

}
