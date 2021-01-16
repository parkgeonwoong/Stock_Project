package Frame_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataBase {
	public static Connection con;	//DB랑 이클립스 연결
	public static Statement ps;		//동적 쿼리를 이용해 보기
	public static ResultSet rs;		// 데이터 주소값 이용하기 위함
	
	public static PreparedStatement pstmtAdd    = null;
	public static PreparedStatement pstmtDel    = null;
	public static PreparedStatement pstmtUpdate = null;
	
	public DataBase() {
		String id = "root";
		String pass = "rjsdnd0614";
		String url = "jdbc:mysql://localhost:3306/mnu?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		
		try {
			///////// mysql version 8.0.22의 forname, url ////////
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					con = DriverManager.getConnection(url, id, pass);

					System.out.println("DB연결 성공");
					
					ps = con.createStatement();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public static void Load(DefaultTableModel model) {
		model.setNumRows(0);  // 모델 테이블 초기화
		String sql = "select * from admin";
		
		try {
			rs = ps.executeQuery(sql);			
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String company = rs.getString(2);
				String re_name = rs.getString(3);
				String re_num = rs.getString(4);
				String keeper = rs.getString(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				String arr[] = {Integer.toString(code), company, re_name, re_num, keeper, phone, email};
				model.addRow(arr);
			}
		} catch (Exception e) {
			System.out.println("search error Load.");
		}
	}
	
	
	public static boolean insert_company(int code, String company, String re_name, String re_num, String keeper, String phone, String email) {
		try{

			pstmtAdd = con.prepareStatement("insert into admin(code, company, re_name, re_num, keeper, phone, email) values(?,?,?,?,?,?,?)");
			pstmtAdd.setInt(1, code);			//코드
			pstmtAdd.setString(2, company);		//상호
			pstmtAdd.setString(3, re_name);		//대표자명
			pstmtAdd.setString(4, re_num);		//등록상호
			pstmtAdd.setString(5, keeper);		//대표자
			pstmtAdd.setString(6, phone);		//휴대폰
			pstmtAdd.setString(7, email);		//이메일

//			대입받은 쿼리를 실행 -> 입력 (insert)

			pstmtAdd.executeUpdate();
			
			return true;

		}catch(Exception e){

			e.printStackTrace();
			return false;

		}

	}
	
	public static void delete(int code){
		try{
			
			pstmtDel = con.prepareStatement("delete from admin where (code ="   +   code   +   ")");
//			code 값을 비교해서 삭제함
// 			pstmtDel.setInt(1, code);
			
// 			대입받은 쿼리를 실행-> 삭제 (delete)
			pstmtDel.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void update(String code, String company,  String re_name, String re_num, String keeper, String phone, String email){
		try{
			pstmtUpdate = con.prepareStatement("update admin set company = ?, re_name = ?, re_num = ?, keeper = ?, phone = ?, email= ? where code = ?");
//			값 대입
			pstmtUpdate.setString(1, company);
			pstmtUpdate.setString(2, re_name);
//			? 순서 중요 확인 필요함
			pstmtUpdate.setString(3, re_num);
			pstmtUpdate.setString(4, keeper);
			pstmtUpdate.setString(5, phone);
			pstmtUpdate.setString(6, email);
			pstmtUpdate.setString(7, code);
			
//			쿼리 실행
			pstmtUpdate.executeUpdate();

		}catch(Exception e){

			e.printStackTrace();

		}

	}
	
	public static void update_item(String code, String product,  String in_pro, String out_pro, String now_pro){
		try{
			pstmtUpdate = con.prepareStatement("update admin set product = ?, in_pro = ?, out_pro = ?, now_pro = ? where code = ?");
//			값 대입
			pstmtUpdate.setString(1, product);
			pstmtUpdate.setString(2, in_pro);
//			? 순서 중요 확인 필요함
			pstmtUpdate.setString(3, out_pro);
			pstmtUpdate.setString(4, now_pro);;
			pstmtUpdate.setString(5, code);
			
//			쿼리 실행
			pstmtUpdate.executeUpdate();

		}catch(Exception e){

			e.printStackTrace();

		}

	}
	
	public static void Load_item(DefaultTableModel model) {
		model.setNumRows(0);  // 모델 테이블 초기화
		String sql = "select * from admin";
		
		try {
			rs = ps.executeQuery(sql);			
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String product = rs.getString(8);
				String in_pro = rs.getString(9);
				String out_pro = rs.getString(10);
				String now_pro = rs.getString(11);

				
				String arr[] = {Integer.toString(code), product, in_pro, out_pro, now_pro};
				model.addRow(arr);
			}
		} catch (Exception e) {
			System.out.println("search error Load.");
		}
	}
	
	
	public ResultSet getrs() {
		return rs;
	}
	
	public Statement getps() {
		return ps;
	}
	
	public void closeDatabase() {
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Database Close Error");
		}
	}
}