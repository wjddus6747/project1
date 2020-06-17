package ver05;

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
		super.showPhoneInfo();
		System.out.println("회사 :" + com_name);
	}
}
