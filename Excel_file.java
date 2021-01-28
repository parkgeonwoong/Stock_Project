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
            // 엑셀파일 객체 생성
            WritableWorkbook workbook = null;
 
            // 시트 객체 생성
            WritableSheet sheet = null;
 
            // 셀 객체 생성
            Label label = null;
 
            // 저장할 파일 객체 생성
            File file = new File(path);
 
            // 테스트 데이터 (S)
            HashMap hm_0 = new HashMap();
            hm_0.put("Code", "1");
            hm_0.put("Company", "LMC");
            hm_0.put("김복", "re_name");
 
            HashMap hm_1 = new HashMap();
            hm_1.put("Code", "2");
            hm_1.put("Company", "BALENCIAGA");
            hm_1.put("박건웅", "re_name");
            
            List list = new ArrayList();
            list.add(hm_0);
            list.add(hm_1);
            
            // 테스트 데이터 (E)
 
            // 파일 생성
            workbook = Workbook.createWorkbook(file);
 
            // 시트 생성
            workbook.createSheet("sheet1", 0);
            sheet = workbook.getSheet(0);
 
            // 셀에 쓰기
            label = new Label(0, 0, "Code");
            sheet.addCell(label);
 
            label = new Label(1, 0, "Company");
            sheet.addCell(label);
            
            label = new Label(2, 0, "re_name");
            sheet.addCell(label);
 
            // 데이터 삽입
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