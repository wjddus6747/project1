package project1;

import ver01.PhoneInfo;

public class PhoneBookVer01
{

	public static void main(String[] args)
	{
		PhoneInfo p1 = new PhoneInfo("이정연", "010-7479-6747", "97-09-19");
		PhoneInfo p2 = new PhoneInfo("이준승", "010-3524-3447");
		
		p1.showPhoneInfo();
		p2.showPhoneInfo();//생년월일이 입력되지 않음
	}

}
