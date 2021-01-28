package Frame_Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
 
public class Excel_file {
   public Excel_file(String path) {
      try {
            // �������� ��ü ����
            WritableWorkbook workbook = null;
 
            // ��Ʈ ��ü ����
            WritableSheet sheet = null;
 
            // �� ��ü ����
            Label label = null;
 
            // ������ ���� ��ü ����
            File file = new File(path);
 
            // �׽�Ʈ ������ (S)
            HashMap hm_0 = new HashMap();
            hm_0.put("Code", "1");
            hm_0.put("Company", "LMC");
            hm_0.put("�躹", "re_name");
 
            HashMap hm_1 = new HashMap();
            hm_1.put("Code", "2");
            hm_1.put("Company", "BALENCIAGA");
            hm_1.put("�ڰǿ�", "re_name");
            
            List list = new ArrayList();
            list.add(hm_0);
            list.add(hm_1);
            
            // �׽�Ʈ ������ (E)
 
            // ���� ����
            workbook = Workbook.createWorkbook(file);
 
            // ��Ʈ ����
            workbook.createSheet("sheet1", 0);
            sheet = workbook.getSheet(0);
 
            // ���� ����
            label = new Label(0, 0, "Code");
            sheet.addCell(label);
 
            label = new Label(1, 0, "Company");
            sheet.addCell(label);
            
            label = new Label(2, 0, "re_name");
            sheet.addCell(label);
 
            // ������ ����
            for (int i = 0; i < list.size(); i++) {
                HashMap rs = (HashMap) list.get(i);
 
                label = new Label(0, (i + 1), (String) rs.get("Code"));
                sheet.addCell(label);
 
                label = new Label(1, (i + 1), (String) rs.get("Company"));
                sheet.addCell(label);
                
                label = new Label(2, (i + 1), (String) rs.get("re_name"));
                sheet.addCell(label);
            }
 
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   } 
}