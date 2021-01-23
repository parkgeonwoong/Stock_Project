package Frame_Test;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Company_Panel extends JPanel {
	Company_insert Ci;
	Company_edit Ce;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	String header[] = { "ÄÚµå", "»óÈ£", "´ëÇ¥ÀÚ¸í", "»ç¾÷ÀÚµî·Ï¹øÈ£", "´ã´ç", "ÈÞ´ëÆù", "E-mail" };
	DefaultTableModel model = new DefaultTableModel(header, 0);
	Statement ps;
	ResultSet rs;
	public JTable table;
	private JButton btnNewButton_3;

	public Company_Panel(Statement ps, ResultSet rs) {
		this.ps = ps;
		this.rs = rs;
		Company_frame();

		///// Insert(»ðÀÔ) ¹öÆ° //////
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ci = new Company_insert(ps, rs, model);
				Ci.setVisible(true);
				Ci.setLocationRelativeTo(null);
			}
		});
		
		////// Delete(»èÁ¦) ¹öÆ° //////
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tableRow = table.getSelectedRow();
				int code = Integer.valueOf((String) table.getValueAt(tableRow, 0));
				DataBase.delete(code);
				DataBase.Load(model);
			}
		});
		
		////// Edit(¼öÁ¤) ¹öÆ° //////
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ce = new Company_edit(ps, rs, model);
				Ce.setVisible(true);
				Ce.setLocationRelativeTo(null);
				int tableRow = table.getSelectedRow();
				Ce.view(tableRow + 1);

			}
		});

	}

	public void db() {
		model.setNumRows(0); // ¸ðµ¨ Å×ÀÌºí ÃÊ±âÈ­
		String sql = "select * from admin";

		try {
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				int code = rs.getInt(1);
				String company = rs.getString(2);
				String re_name = rs.getString(3);
				String re_num = rs.getString(4);
				String keeper = rs.getString(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);

				String arr[] = { Integer.toString(code), company, re_name, re_num, keeper, phone, email };
				model.addRow(arr);
			}
		} catch (Exception e) {
			System.out.println("search error Company_panel.");
		}
	}

	///// °Å·¡ È¸»ç Á¤º¸ UI /////
	public void Company_frame() {
		db();
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable(model);
		table.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 10, 20, 10, 20, 10, 20, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnNewButton = new JButton("Insert");
		btnNewButton.setIcon(new ImageIcon("./image\\insertin.png"));
		
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_3 = new JButton("Excel ");
		btnNewButton_3.setIcon(new ImageIcon("./image\\excel.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path = "./admin.xlsx";
	            //Excel_file exel = new Excel_file(path + 1); // ¿¢¼¿ ÆÄÀÏ »ý¼º (db µ¥ÀÌÅÍ »ðÀÔ)
	            Excel_exe open = new Excel_exe(path);         // ¿¢¼¿ ÆÄÀÏ ½ÇÇà
			}
		});
				
						btnNewButton_1 = new JButton("Delete");
						btnNewButton_1.setIcon(new ImageIcon("./image\\delete.png"));
						
						btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
						
						gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 2;
						panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
				btnNewButton_2 = new JButton("Edit  ");
				btnNewButton_2.setIcon(new ImageIcon("./image\\update.png"));
				
						btnNewButton_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
						GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
						gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
						gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnNewButton_2.gridx = 0;
						gbc_btnNewButton_2.gridy = 4;
						panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 6;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);

	}
}
