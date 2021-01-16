package Frame_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataBase {
	public static Connection con;	//DB�� ��Ŭ���� ����
	public static Statement ps;		//���� ������ �̿��� ����
	public static ResultSet rs;		// ������ �ּҰ� �̿��ϱ� ����
	
	public static PreparedStatement pstmtAdd    = null;
	public static PreparedStatement pstmtDel    = null;
	public static PreparedStatement pstmtUpdate = null;
	
	public DataBase() {
		String id = "root";
		String pass = "rjsdnd0614";
		String url = "jdbc:mysql://localhost:3306/mnu?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		
		try {
			///////// mysql version 8.0.22�� forname, url ////////
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					con = DriverManager.getConnection(url, id, pass);

					System.out.println("DB���� ����");
					
					ps = con.createStatement();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public static void Load(DefaultTableModel model) {
		model.setNumRows(0);  // �� ���̺� �ʱ�ȭ
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
			pstmtAdd.setInt(1, code);			//�ڵ�
			pstmtAdd.setString(2, company);		//��ȣ
			pstmtAdd.setString(3, re_name);		//��ǥ�ڸ�
			pstmtAdd.setString(4, re_num);		//��ϻ�ȣ
			pstmtAdd.setString(5, keeper);		//��ǥ��
			pstmtAdd.setString(6, phone);		//�޴���
			pstmtAdd.setString(7, email);		//�̸���

//			���Թ��� ������ ���� -> �Է� (insert)

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
//			code ���� ���ؼ� ������
// 			pstmtDel.setInt(1, code);
			
// 			���Թ��� ������ ����-> ���� (delete)
			pstmtDel.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void update(String code, String company,  String re_name, String re_num, String keeper, String phone, String email){
		try{
			pstmtUpdate = con.prepareStatement("update admin set company = ?, re_name = ?, re_num = ?, keeper = ?, phone = ?, email= ? where code = ?");
//			�� ����
			pstmtUpdate.setString(1, company);
			pstmtUpdate.setString(2, re_name);
//			? ���� �߿� Ȯ�� �ʿ���
			pstmtUpdate.setString(3, re_num);
			pstmtUpdate.setString(4, keeper);
			pstmtUpdate.setString(5, phone);
			pstmtUpdate.setString(6, email);
			pstmtUpdate.setString(7, code);
			
//			���� ����
			pstmtUpdate.executeUpdate();

		}catch(Exception e){

			e.printStackTrace();

		}

	}
	
	public static void update_item(String code, String product,  String in_pro, String out_pro, String now_pro){
		try{
			pstmtUpdate = con.prepareStatement("update admin set product = ?, in_pro = ?, out_pro = ?, now_pro = ? where code = ?");
//			�� ����
			pstmtUpdate.setString(1, product);
			pstmtUpdate.setString(2, in_pro);
//			? ���� �߿� Ȯ�� �ʿ���
			pstmtUpdate.setString(3, out_pro);
			pstmtUpdate.setString(4, now_pro);;
			pstmtUpdate.setString(5, code);
			
//			���� ����
			pstmtUpdate.executeUpdate();

		}catch(Exception e){

			e.printStackTrace();

		}

	}
	
	public static void Load_item(DefaultTableModel model) {
		model.setNumRows(0);  // �� ���̺� �ʱ�ȭ
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