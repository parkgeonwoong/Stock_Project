package Frame_Test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Excel_exe {
   
   public Excel_exe(String path) {
      String exeFile = path;
      
      try {
         Desktop.getDesktop().edit(new File(exeFile));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();   
      }
   }
}