package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneBookManager
{
	public Connection con;
	public PreparedStatement psmt;
	public Statement stmt;
	public ResultSet rs;

	// 메뉴츨력
	public void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("선택: ");
	}

	// 입력 PreparedStatement 클래스 이용 
	public void dataInput()
	{

		try
		{
			// 쿼리문
			String sql = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
			psmt = con.prepareStatement(sql);

			// 사용자로부터 값입력
			Scanner sc = new Scanner(System.in);
			System.out.print("이름: ");
			String name = sc.nextLine();
			System.out.print("핸드폰번호: ");
			String phonenumber = sc.nextLine();
			System.out.println("생년월일: ");
			String birthday = sc.nextLine();

			psmt.setString(1, name);
			psmt.setString(2, phonenumber);

			//java.util.Date utilDate = new java.util.Date();
			//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			DateFormat formatter = new SimpleDateFormat("yymmdd");
			Date date = formatter.parse(birthday);
			java.sql.Date sDate = new java.sql.Date(date.getTime());

			psmt.setDate(3, sDate);

			// 쿼리문 실행
			int updatenum = psmt.executeUpdate();
			System.out.println(updatenum + "행이 입력되었습니다.");
		} catch (Exception e)
		{
			System.out.println("입력문예외발생");
			e.printStackTrace();
		}

	}

	// 검색 Statement 클래스 이용

	public void dataSearch()
	{

		try
		{
			stmt = con.createStatement();

			Scanner sc = new Scanner(System.in);
			System.out.println("데이터검색을 시작합니다.");
			System.out.print("이름:");
			String search = sc.next();

			String sql = "select name, phonenumber, birthday from phonebook_tb WHERE name LIKE " + "'" + search + "'";
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				java.sql.Date birthday = rs.getDate("birthday");
				
				
				
				System.out.printf("%-10s %-10s %-10s\n", name, phonenumber, birthday);
			}
		} catch (Exception e)
		{
			System.out.println("검색쿼리문에러발생");
			e.printStackTrace();
		}
	}

	// 삭제 PreparedStatement 클래스 이용
	public void dataDelete()
	{
		try
		{

			// sql준비
			String sql = "DELETE FROM phonebook_tb WHERE name=?";
			// prepared객체생성
			psmt = con.prepareStatement(sql);

			System.out.println("데이터 삭제를 시작합니다.");
			System.out.println("이름:");
			Scanner sc = new Scanner(System.in);
			String deletename = sc.nextLine();
			// 인파리미터값설정
			psmt.setString(1, deletename);

			System.out.println(psmt.executeQuery() + "행이 삭제되었습니다.");
		} catch (Exception e)
		{
			System.out.println("DB삭제에러발생");
			e.printStackTrace();
		}
	}

	// 전체출력
	public void dataAllShow()
	{
		try
		{
			stmt = con.createStatement();

			String sql = "SELECT * FROM phonebook_tb";
			rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				java.sql.Date birthday = rs.getDate("birthday");
				
				System.out.printf("%-10s %-10s %-10s\n", name, phonenumber, birthday);

			}
		} catch (Exception e)
		{
			System.out.println("전체출력시에러");
			e.printStackTrace();
		} 
	}

	// 오라틀 DB에 연결
	public void ConnectionOracle()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			// 커넥션URL -> jdbc:oracle:thin://@IP주소:포트번호:SID
			con = DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:orcl", "kosmo", "1234");
		} catch (Exception e)
		{
			System.out.println("DB연결오류");
		}
	}

	public void close()
	{
		try
		{
			if (con != null)
			{
				con.close();
			}
			if (stmt != null)
			{
				stmt.cancel();
			}
			if (psmt != null)
			{
				psmt.close();
			}
			if (rs != null)
			{
				rs.close();
			}
		} catch (Exception e)
		{
			System.out.println("전체출력자원반남시에러");
			e.printStackTrace();
		}
	}
}
