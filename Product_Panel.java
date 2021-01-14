package Frame_Test;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class Product_Panel extends JPanel{
	
	String header[] = {"코드","상호","대표자명","물품", "입고", "출고", "현재수량"};
	DefaultTableModel model = new DefaultTableModel(header , 0);
	Statement ps;
	ResultSet rs;
	private JTable table;
	
	public Product_Panel(Statement ps, ResultSet rs) {
		this.ps = ps;
		this.rs = rs;
		Product_frame();
	}
	
	public void db() {
		String sql = "select * from admin";
		
		try {
			rs = ps.executeQuery(sql);			
			
			while(rs.next()) {
				int code = rs.getInt(1);
				String company = rs.getString(2);
				String re_name = rs.getString(3);
				String product = rs.getString(8);
				String in_pro = rs.getString(9);
				String out_pro = rs.getString(10);
				String now_pro = rs.getString(11);
				
				String arr[] = {Integer.toString(code), company, re_name, product, in_pro, out_pro, now_pro};
				model.addRow(arr);
			}
		} catch (Exception e) {
			System.out.println("search error Product_Panel.");
		}
	}
	
	///// 물품 정보 UI /////
	public void Product_frame() {
		db();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
	}
}


