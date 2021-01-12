package Frame_Test;

import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class Main {
	
	public static void main(String[] args) {
		///// DB ���� /////
		DataBase db = new DataBase();
		Statement ps;
		ResultSet rs;
		ps = db.getps();
		rs = db.getrs();
		
		///// UI �۲� /////
		UI_Font.set(new FontUIResource(new Font("���� ���", Font.BOLD, 13)));  
		
		///// ������ ���� /////
		StockFrame sf = new StockFrame(ps, rs);
		sf.setVisible(true);
		sf.setLocationRelativeTo(null);
	}
}
