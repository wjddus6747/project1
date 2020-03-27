package ver07;

public class PhoneSchoolInfo extends PhoneInfo
{
	String major;
	int grade;

	public PhoneSchoolInfo(String name, String phoneNumber, String _major, int _grade)
	{
		super(name, phoneNumber);
		major = _major;
		grade = _grade;
	}
	
	@Override
	public void showPhoneInfo()
	{
		System.out.println("입력된 정보출력...");
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		System.out.println("전공 :" + major);
		System.out.println("학년 :"+ grade );
	}
}
