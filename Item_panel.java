package Frame_Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Item_panel extends JPanel{
	String header[] = { "코드", "상품", "입고", "출고", "현재수량" };
	DefaultTableModel model = new DefaultTableModel(header, 0);
	Statement ps;
	ResultSet rs;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Item_panel(Statement ps, ResultSet rs) {
		this.ps = ps;
		this.rs = rs;
		item_frame();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				view(index+1);			/// 자바에서 index=0 부터 시작 Mysql에서 1부터 시작
			}
		});
	
	}
	
	public void db() {
		model.setNumRows(0); // 모델 테이블 초기화
		String sql = "select * from admin";

		try {
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				int code = rs.getInt(1);
				String product = rs.getString(8);
				String in_pro = rs.getString(9);
				String out_pro = rs.getString(10);
				String now_pro = rs.getString(11);


				String arr[] = { Integer.toString(code), product, in_pro, out_pro, now_pro };
				model.addRow(arr);
			}
		} catch (Exception e) {
			System.out.println("search error item_panel.");
		}
	}
	
	
	public void view(int index) {

		try {
			String sql = "select * from admin";
			rs = ps.executeQuery(sql);			
			
			while(rs.next()) {
				if(rs.getInt(1) == index) {
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(8));
					textField_2.setText(rs.getString(9));
					textField_3.setText(rs.getString(10));
					textField_4.setText(rs.getString(11));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void item_frame() {
		db();
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{8, 15, 5, 20, 10, 15, 5, 30, 15, 15, 8, 0};
		gbl_panel_1.rowHeights = new int[]{10, 30, 5, 30, 5, 0, 8, 0, 10, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\uCF54\uB4DC");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC785\uACE0");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		panel_1.add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uACE0");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 7;
		gbc_textField_3.gridy = 3;
		panel_1.add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uD604\uC7AC\uC218\uB7C9");
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 5;
		panel_1.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		panel_1.add(textField_4, gbc_textField_4);
		
		JButton btnNewButton_1 = new JButton("\uC5C5\uB370\uC774\uD2B8");
		btnNewButton_1.setIcon(new ImageIcon("./image\\update.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textField.getText();
				String product = textField_1.getText();
				String in_pro = textField_2.getText();
				String out_pro = textField_3.getText();
				String now_pro = textField_4.getText();
				
				DataBase.update_item(code, product, in_pro, out_pro, now_pro);
				DataBase.Load_item(model);

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 6;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
	}
}
