
package org.uninpahu.ConfigPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class saveSong {
    public static String uploadMP3Song(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo MP3");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo MP3", "mp3"));
        
        int result = fileChooser.showOpenDialog(fileChooser);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectFile = fileChooser.getSelectedFile();
            try{
                Path destinoDir = Paths.get("src/main/java/org/uninpahu/Music");
                Path destino = destinoDir.resolve(selectFile.getName());
                Files.copy(selectFile.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
                return destino.toString();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error to upload file: "+e.getMessage());
            }
        }
        return null;
    }
}
