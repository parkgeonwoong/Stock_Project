package Frame_Test;

import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class Main {
	
	public static void main(String[] args) {
		///// DB 연결 /////
		DataBase db = new DataBase();
		Statement ps;
		ResultSet rs;
		ps = db.getps();
		rs = db.getrs();
		
		///// UI 글꼴 /////
		UI_Font.set(new FontUIResource(new Font("맑은 고딕", Font.BOLD, 13)));  
		
		///// 프레임 연결 /////
		StockFrame sf = new StockFrame(ps, rs);
		sf.setVisible(true);
		sf.setLocationRelativeTo(null);
	}
}
