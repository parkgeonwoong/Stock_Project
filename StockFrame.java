package Frame_Test;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

public class StockFrame extends JFrame {
	Company_Panel C_panel;

	Statement ps;
	ResultSet rs;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;

	public StockFrame(Statement ps, ResultSet rs) {
		this.ps = ps;
		this.rs = rs;
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/Frame.png"));
		setTitle("Stock_Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 601);
		Containers();		// UI
		
		C_panel.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = C_panel.table.getSelectedRow();
				view(index+1);			/// ¿⁄πŸø°º≠ index=0 ∫Œ≈Õ Ω√¿€ Mysqlø°º≠ 1∫Œ≈Õ Ω√¿€
			}
		});
	}
	
	///// Table ∞¸∏Æ ∫∏±‚  /////
	public void view(int index) {

		try {
			String sql = "select * from admin";
			rs = ps.executeQuery(sql);			
			
			while(rs.next()) {
				if(rs.getInt(1) == index) {
					textField_1.setText(rs.getString(1));
					textField_3.setText(rs.getString(1));
					textField.setText(rs.getString(2));
					textField_4.setText(rs.getString(2));
					textField_15.setText(rs.getString(3));
					textField_7.setText(rs.getString(4));
					textField_20.setText(rs.getString(5));
					textField_11.setText(rs.getString(6));
					textField_2.setText(rs.getString(7));
					textField_12.setText(rs.getString(8));
					textField_21.setText(rs.getString(8));
					textField_22.setText(rs.getString(9));
					textField_24.setText(rs.getString(10));
					textField_25.setText(rs.getString(11));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	///// UI /////
	public void Containers() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uAE30\uCD08\uAD00\uB9AC");
		mnNewMenu.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("[\uB4F1\uB85D] \uAD00\uB9AC");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\uACBD\uC601\uBC0F\uC5C5\uBB34");
		mnNewMenu_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("\uC138\uAE08\uACC4\uC0B0\uC11C");
		mnNewMenu_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("\uC601\uC5C5\uD604\uD669\uBCF4\uACE0");
		mnNewMenu_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("\uAC70\uB798\uCC98\uBCF4\uACE0");
		mnNewMenu_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("\uC81C\uD488\uBCF4\uACE0");
		mnNewMenu_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("\uACE0\uAC1D\uAD00\uB9AC");
		mnNewMenu_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("\uC8FC\uBB38");
		mnNewMenu_7.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_7);
		
		JMenu mnNewMenu_8 = new JMenu("\uB3C4\uC6C0\uB9D0");
		mnNewMenu_8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		menuBar.add(mnNewMenu_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab(" ¡∂»∏", new ImageIcon("./image/computer.png"), layeredPane, null);
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[]{10, 525, 129, 57, 57, 57, 0};
		gbl_layeredPane.rowHeights = new int[]{21, 28, 33, 23, 23, 23, 23, 46, 10, 95, 0};
		gbl_layeredPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_layeredPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredPane.setLayout(gbl_layeredPane);
		
		JLabel lblNewLabel_8 = new JLabel("\u318D\uAC70\uB798\uCC98 \uC870\uD68C");
		lblNewLabel_8.setBackground(Color.BLACK);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridheight = 2;
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 0;
		layeredPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JButton btnNewButton_7_6 = new JButton("Excel \uAC00\uC838\uC624\uAE30");
		btnNewButton_7_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_7_6 = new GridBagConstraints();
		gbc_btnNewButton_7_6.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_7_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_7_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7_6.gridx = 2;
		gbc_btnNewButton_7_6.gridy = 1;
		layeredPane.add(btnNewButton_7_6, gbc_btnNewButton_7_6);
		
		JButton btnNewButton_4 = new JButton("\uCD9C\uB825");
		btnNewButton_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 1;
		layeredPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\uBCF5\uC0AC");
		btnNewButton_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 1;
		layeredPane.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridheight = 6;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		layeredPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{49, 46, 22, 24, 17, 7, 45, 223, 17, 0};
		gbl_panel_1.rowHeights = new int[]{5, 35, 35, 35, 35, 60, 5, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\uAC70\uB798\uCC98");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 4;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0AC\uC5C5\uC790 \uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 7;
		gbc_textField_7.gridy = 1;
		panel_1.add(textField_7, gbc_textField_7);
		
		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBar.anchor = GridBagConstraints.WEST;
		gbc_scrollBar.fill = GridBagConstraints.VERTICAL;
		gbc_scrollBar.gridheight = 7;
		gbc_scrollBar.gridx = 8;
		gbc_scrollBar.gridy = 0;
		panel_1.add(scrollBar, gbc_scrollBar);
		
		JLabel lblNewLabel_1 = new JLabel("\uCF54\uB4DC");
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_1.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_11 = new JLabel("\uD734\uB300\uD3F0");
		lblNewLabel_11.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridwidth = 2;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 5;
		gbc_lblNewLabel_11.gridy = 2;
		panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.gridx = 7;
		gbc_textField_11.gridy = 2;
		panel_1.add(textField_11, gbc_textField_11);
		
		JLabel lblNewLabel_10 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_10.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 3;
		panel_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 3;
		panel_1.add(textField_9, gbc_textField_9);
		
		JButton btnNewButton_3 = new JButton("\uC6B0\uD3B8 \uAC80\uC0C9");
		btnNewButton_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 2;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 3;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_12 = new JLabel("\uC81C\uD488");
		lblNewLabel_12.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.gridwidth = 2;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 5;
		gbc_lblNewLabel_12.gridy = 3;
		panel_1.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.gridx = 7;
		gbc_textField_12.gridy = 3;
		panel_1.add(textField_12, gbc_textField_12);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 7;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		panel_1.add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_13 = new JLabel("\uBA54\uBAA8");
		lblNewLabel_13.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 5;
		panel_1.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.fill = GridBagConstraints.BOTH;
		gbc_textField_13.insets = new Insets(0, 0, 5, 5);
		gbc_textField_13.gridwidth = 7;
		gbc_textField_13.gridx = 1;
		gbc_textField_13.gridy = 5;
		panel_1.add(textField_13, gbc_textField_13);
		
		JPanel panel_3 = new JPanel();
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{94, 62, 64, 0, 0};
		gbl_panel_3.rowHeights = new int[]{31, 23, 40, 40, 40, 40, 40, 21, 40, 40, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBCF4\uAE30");
		lblNewLabel_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uAC70\uB798\uC911");
		rdbtnNewRadioButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		panel_3.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uAC70\uB798\uC815\uB9AC");
		rdbtnNewRadioButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		panel_3.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uBAA8\uB450");
		rdbtnNewRadioButton_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 2;
		gbc_rdbtnNewRadioButton_2.gridy = 1;
		panel_3.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC70\uB798\uCC98\uCF54\uB4DC(ID)");
		lblNewLabel_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		panel_3.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("\uAC70\uB798\uCC98\uBA85");
		lblNewLabel_5_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 3;
		panel_3.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_3.add(textField_4, gbc_textField_4);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("\uC0C1\uD638");
		lblNewLabel_5_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1_1.gridx = 0;
		gbc_lblNewLabel_5_1_1.gridy = 4;
		panel_3.add(lblNewLabel_5_1_1, gbc_lblNewLabel_5_1_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.gridwidth = 2;
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.insets = new Insets(0, 0, 5, 5);
		gbc_textField_14.gridx = 1;
		gbc_textField_14.gridy = 4;
		panel_3.add(textField_14, gbc_textField_14);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("\uB300\uD45C\uC790\uBA85");
		lblNewLabel_5_1_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1_1_1.gridx = 0;
		gbc_lblNewLabel_5_1_1_1.gridy = 5;
		panel_3.add(lblNewLabel_5_1_1_1, gbc_lblNewLabel_5_1_1_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.gridwidth = 2;
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.insets = new Insets(0, 0, 5, 5);
		gbc_textField_15.gridx = 1;
		gbc_textField_15.gridy = 5;
		panel_3.add(textField_15, gbc_textField_15);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("\uC0AC\uC5C5\uC7A5\uC18C\uC7AC\uC9C0");
		lblNewLabel_5_1_1_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_5_1_1_1_1.gridy = 6;
		panel_3.add(lblNewLabel_5_1_1_1_1, gbc_lblNewLabel_5_1_1_1_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		GridBagConstraints gbc_textField_16 = new GridBagConstraints();
		gbc_textField_16.gridwidth = 2;
		gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_16.insets = new Insets(0, 0, 5, 5);
		gbc_textField_16.gridx = 1;
		gbc_textField_16.gridy = 6;
		panel_3.add(textField_16, gbc_textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		GridBagConstraints gbc_textField_17 = new GridBagConstraints();
		gbc_textField_17.anchor = GridBagConstraints.NORTH;
		gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_17.insets = new Insets(0, 0, 5, 5);
		gbc_textField_17.gridwidth = 2;
		gbc_textField_17.gridx = 1;
		gbc_textField_17.gridy = 7;
		panel_3.add(textField_17, gbc_textField_17);
		
		JLabel lblNewLabel_5_1_1_1_1_1 = new JLabel("\uC5C5\uD0DC");
		lblNewLabel_5_1_1_1_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_5_1_1_1_1_1.gridy = 8;
		panel_3.add(lblNewLabel_5_1_1_1_1_1, gbc_lblNewLabel_5_1_1_1_1_1);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		GridBagConstraints gbc_textField_18 = new GridBagConstraints();
		gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_18.gridwidth = 2;
		gbc_textField_18.insets = new Insets(0, 0, 5, 5);
		gbc_textField_18.gridx = 1;
		gbc_textField_18.gridy = 8;
		panel_3.add(textField_18, gbc_textField_18);
		
		JLabel lblNewLabel_5_1_1_1_1_2 = new JLabel("\uC885\uBAA9");
		lblNewLabel_5_1_1_1_1_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_5_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_5_1_1_1_1_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5_1_1_1_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5_1_1_1_1_2.gridx = 0;
		gbc_lblNewLabel_5_1_1_1_1_2.gridy = 9;
		panel_3.add(lblNewLabel_5_1_1_1_1_2, gbc_lblNewLabel_5_1_1_1_1_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		GridBagConstraints gbc_textField_19 = new GridBagConstraints();
		gbc_textField_19.insets = new Insets(0, 0, 0, 5);
		gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_19.gridwidth = 2;
		gbc_textField_19.gridx = 1;
		gbc_textField_19.gridy = 9;
		panel_3.add(textField_19, gbc_textField_19);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridheight = 8;
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		layeredPane.add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{100, 170, 0, 72, 135, 0};
		gbl_panel_4.rowHeights = new int[]{35, 35, 35, 35, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_14 = new JLabel("\uAD00\uB9AC/\uB2F4\uB2F9\uC0AC\uC6D0");
		lblNewLabel_14.setForeground(Color.BLUE);
		lblNewLabel_14.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 0;
		panel_4.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		textField_20 = new JTextField();
		GridBagConstraints gbc_textField_20 = new GridBagConstraints();
		gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_20.insets = new Insets(0, 0, 5, 5);
		gbc_textField_20.gridx = 1;
		gbc_textField_20.gridy = 0;
		panel_4.add(textField_20, gbc_textField_20);
		textField_20.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("\uAC70\uB798\uCC98\uAD6C\uBD84");
		lblNewLabel_15.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 1;
		panel_4.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		textField_21 = new JTextField();
		GridBagConstraints gbc_textField_21 = new GridBagConstraints();
		gbc_textField_21.insets = new Insets(0, 0, 5, 5);
		gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_21.gridx = 1;
		gbc_textField_21.gridy = 1;
		panel_4.add(textField_21, gbc_textField_21);
		textField_21.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("\uCD9C\uACE0\uB4F1\uAE09");
		lblNewLabel_17.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 3;
		gbc_lblNewLabel_17.gridy = 1;
		panel_4.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		textField_23 = new JTextField();
		GridBagConstraints gbc_textField_23 = new GridBagConstraints();
		gbc_textField_23.insets = new Insets(0, 0, 5, 0);
		gbc_textField_23.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_23.gridx = 4;
		gbc_textField_23.gridy = 1;
		panel_4.add(textField_23, gbc_textField_23);
		textField_23.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("\uC785\uACE0");
		lblNewLabel_16.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 2;
		panel_4.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		textField_22 = new JTextField();
		GridBagConstraints gbc_textField_22 = new GridBagConstraints();
		gbc_textField_22.insets = new Insets(0, 0, 5, 5);
		gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_22.gridx = 1;
		gbc_textField_22.gridy = 2;
		panel_4.add(textField_22, gbc_textField_22);
		textField_22.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("\uCD9C\uACE0");
		lblNewLabel_18.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 3;
		panel_4.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		textField_24 = new JTextField();
		GridBagConstraints gbc_textField_24 = new GridBagConstraints();
		gbc_textField_24.insets = new Insets(0, 0, 0, 5);
		gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_24.gridx = 1;
		gbc_textField_24.gridy = 3;
		panel_4.add(textField_24, gbc_textField_24);
		textField_24.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("\uD604\uC7AC \uC218\uB7C9");
		lblNewLabel_19.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_19.gridx = 3;
		gbc_lblNewLabel_19.gridy = 3;
		panel_4.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		textField_25 = new JTextField();
		GridBagConstraints gbc_textField_25 = new GridBagConstraints();
		gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_25.gridx = 4;
		gbc_textField_25.gridy = 3;
		panel_4.add(textField_25, gbc_textField_25);
		textField_25.setColumns(10);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 9;
		layeredPane.add(panel_4, gbc_panel_4);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		tabbedPane.addTab(" \uAC70\uB798\uCC98", new ImageIcon("./image/office.png"), panel2, null);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[]{43, 164, 112, 97, 162, 358, 0, 0};
		gbl_panel2.rowHeights = new int[]{45, 405, 0};
		gbl_panel2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel2.setLayout(gbl_panel2);
		
		JLabel lblNewLabel_20 = new JLabel("\u318D\uAC70\uB798 \uD68C\uC0AC \uC815\uBCF4");
		lblNewLabel_20.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 1;
		gbc_lblNewLabel_20.gridy = 0;
		panel2.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		C_panel = new Company_Panel(ps, rs);
		GridBagConstraints gbc_JTablex_panel = new GridBagConstraints();
		gbc_JTablex_panel.gridwidth = 5;
		gbc_JTablex_panel.insets = new Insets(0, 0, 0, 5);
		gbc_JTablex_panel.fill = GridBagConstraints.BOTH;
		gbc_JTablex_panel.gridx = 1;
		gbc_JTablex_panel.gridy = 1;
		panel2.add(C_panel, gbc_JTablex_panel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		tabbedPane.addTab(" \uBB3C\uD488", new ImageIcon("./image/box.png"), panel_2_1, null);
		GridBagLayout gbl_panel_2_1 = new GridBagLayout();
		gbl_panel_2_1.columnWidths = new int[]{42, 164, 112, 97, 191, 325, 0, 0};
		gbl_panel_2_1.rowHeights = new int[]{45, 326, 0};
		gbl_panel_2_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2_1.setLayout(gbl_panel_2_1);
		
		JLabel lblNewLabel_20_1 = new JLabel("\u318D\uBB3C\uD488 \uC815\uBCF4");
		lblNewLabel_20_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_20_1 = new GridBagConstraints();
		gbc_lblNewLabel_20_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20_1.gridx = 1;
		gbc_lblNewLabel_20_1.gridy = 0;
		panel_2_1.add(lblNewLabel_20_1, gbc_lblNewLabel_20_1);
		
		Product_Panel panel_5_1 = new Product_Panel(ps, rs);
		GridBagConstraints gbc_panel_5_1 = new GridBagConstraints();
		gbc_panel_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5_1.fill = GridBagConstraints.BOTH;
		gbc_panel_5_1.gridwidth = 5;
		gbc_panel_5_1.gridx = 1;
		gbc_panel_5_1.gridy = 1;
		panel_2_1.add(panel_5_1, gbc_panel_5_1);
		

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		tabbedPane.addTab(" \uC7AC\uACE0 \uAD00\uB9AC", new ImageIcon("./image/inventory.png"), panel_2_2, null);
		GridBagLayout gbl_panel_2_2 = new GridBagLayout();
		gbl_panel_2_2.columnWidths = new int[]{43, 164, 112, 97, 162, 250, 22, 56, 0, 0};
		gbl_panel_2_2.rowHeights = new int[]{45, 0, 330, 0, 0, 0};
		gbl_panel_2_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2_2.setLayout(gbl_panel_2_2);
		
		JLabel lblNewLabel_20_2 = new JLabel("\u318D\uC7AC\uACE0 \uD30C\uC545");
		lblNewLabel_20_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_20_2 = new GridBagConstraints();
		gbc_lblNewLabel_20_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20_2.gridx = 1;
		gbc_lblNewLabel_20_2.gridy = 0;
		panel_2_2.add(lblNewLabel_20_2, gbc_lblNewLabel_20_2);
		
		Item_panel panel_5_2 = new Item_panel(ps, rs);
		GridBagConstraints gbc_panel_5_2 = new GridBagConstraints();
		gbc_panel_5_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5_2.fill = GridBagConstraints.BOTH;
		gbc_panel_5_2.gridwidth = 5;
		gbc_panel_5_2.gridx = 1;
		gbc_panel_5_2.gridy = 2;
		panel_2_2.add(panel_5_2, gbc_panel_5_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab(" \uC6D4,\uC77C \uD1B5\uACC4", new ImageIcon("./image/line-chart.png"), panel, null);
		
		JLabel lblNewLabel_6 = new JLabel("\uB2EC\uBCC4");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC77C\uBCC4");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE))
					.addGap(92))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
