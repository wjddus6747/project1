package ver07;

public class PhoneInfo
{
	// 멤버변수
	String name;
	String phoneNumber;

	// 생년월일은 필수사항 아니므로 인자가 없는경우 null로 초기화
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// 정보출력용 메소드
	public void showPhoneInfo()
	{
		System.out.println("입력된 정보출력...");
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		PhoneInfo phoneinfo = (PhoneInfo) obj;
		if (phoneinfo.name.equals(this.name))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
