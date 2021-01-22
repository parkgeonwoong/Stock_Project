package Frame_Test;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Company_edit extends JFrame {
	Company_Panel C_panel;
	Statement ps;
	ResultSet rs;
	DefaultTableModel model;
	private JTextField[] textFields = new JTextField[10];
	private JTextField textField;
	private JLabel lblNewLabel_2_3;
	private JButton btnNewButton;

	public Company_edit(Statement ps, ResultSet rs, DefaultTableModel model) {
		this.ps = ps;
		this.rs = rs;
		this.model = model;
		Edit_frame();

		///// 테이블의 마우스 클릭 /////
		C_panel.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = C_panel.table.getSelectedRow();
			}
		});
		
		///// 수정 버튼 /////
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String code = textFields[0].getText();
				String company = textFields[1].getText();
				String re_name = textFields[2].getText();
				String re_num = textFields[3].getText();
				String keeper = textFields[4].getText();
				String phone = textFields[5].getText();
				String email = textFields[6].getText();
				
				DataBase.update(code, company, re_name, re_num, keeper, phone, email);
				DataBase.Load(model);
				dispose();
			}
		});
		
	}

///// Table 관리 보기  /////
	public void view(int index) {
		try {
			String sql = "select * from admin";
			rs = ps.executeQuery(sql);

			while (rs.next()) {
				if (rs.getInt(1) == index) {
					for (int i = 0; i <= 6; i++)
						textFields[i].setText(rs.getString(i + 1));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	///// Edit UI //////
	public void Edit_frame() {
		setTitle("Edit");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/edit.png"));
		setSize(600, 250);
		JPanel panel = new JPanel();
		C_panel = new Company_Panel(ps, rs);
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 10, 30, 3, 20, 30, 30, 30, 3, 30, 3, 130, 10, 0 };
		gbl_panel.rowHeights = new int[] { 13, 30, 7, 30, 7, 30, 7, 0, 5, 10, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("\uCF54\uB4DC");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textFields[0] = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel.add(textFields[0], gbc_textField);
		textFields[0].setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uCC98");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 8;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFields[1] = new JTextField();
		GridBagConstraints gbc_ci_text2 = new GridBagConstraints();
		gbc_ci_text2.insets = new Insets(0, 0, 5, 5);
		gbc_ci_text2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ci_text2.gridx = 10;
		gbc_ci_text2.gridy = 1;
		panel.add(textFields[1], gbc_ci_text2);
		textFields[1].setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uB300\uD45C\uC790");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFields[2] = new JTextField();
		textFields[2].setColumns(10);
		GridBagConstraints gbc_ci_text3 = new GridBagConstraints();
		gbc_ci_text3.gridwidth = 2;
		gbc_ci_text3.insets = new Insets(0, 0, 5, 5);
		gbc_ci_text3.fill = GridBagConstraints.HORIZONTAL;
		gbc_ci_text3.gridx = 3;
		gbc_ci_text3.gridy = 3;
		panel.add(textFields[2], gbc_ci_text3);

		JLabel lblNewLabel_1_1 = new JLabel("\uC0AC\uC5C5\uC790 \uB4F1\uB85D\uBC88\uD638");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 8;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		textFields[3] = new JTextField();
		textFields[3].setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 10;
		gbc_textField_3.gridy = 3;
		panel.add(textFields[3], gbc_textField_3);

		JLabel lblNewLabel_2_1 = new JLabel("\uB2F4\uB2F9\uC790");
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 5;
		panel.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		textFields[4] = new JTextField();
		textFields[4].setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		panel.add(textFields[4], gbc_textField_4);

		JLabel lblNewLabel_2_2 = new JLabel("\uD734\uB300\uD3F0");
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_2.gridx = 8;
		gbc_lblNewLabel_2_2.gridy = 5;
		panel.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);

		textFields[5] = new JTextField();
		textFields[5].setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 10;
		gbc_textField_5.gridy = 5;
		panel.add(textFields[5], gbc_textField_5);

		lblNewLabel_2_3 = new JLabel("E-mail");
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3.gridx = 1;
		gbc_lblNewLabel_2_3.gridy = 7;
		panel.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);

		textFields[6] = new JTextField();
		textFields[6].setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 4;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 7;
		panel.add(textFields[6], gbc_textField_6);

		btnNewButton = new JButton("수정");
		

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 8;
		panel.add(btnNewButton, gbc_btnNewButton);

	}

}
