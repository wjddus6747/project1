package ver08;

public class PhoneCompanyInfo extends PhoneInfo
{
	String com_name;
	
	public PhoneCompanyInfo(String name, String phoneNumber,String com_name) {
		super(name, phoneNumber);
		this.com_name = com_name;
	}
	
	@Override
	public void showPhoneInfo()
	{
		System.out.println("입력된 정보출력...");
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		System.out.println("회사 :" + com_name);
	}
}
