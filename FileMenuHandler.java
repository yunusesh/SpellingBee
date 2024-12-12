import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class FileMenuHandler implements ActionListener {
   public static File file;

   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }

   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open")){
         JFileChooser fd = new JFileChooser();
         fd.setFileSelectionMode(JFileChooser.FILES_ONLY);
         fd.showOpenDialog(null);
         file = fd.getSelectedFile();
      }
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

}