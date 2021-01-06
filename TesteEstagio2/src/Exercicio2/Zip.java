/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Juan Amaral
 * Zipar vários arquivos,
 * Informe: nome do arquivo que será compactado, diretório dos arquivos a serem compactos em lista
 * 
 */
public class Zip {
    
    public Zip(String nameZipFile,List<String> directoryFiles) throws FileNotFoundException, IOException{

       FileOutputStream fos = new FileOutputStream(nameZipFile +".zip");
       ZipOutputStream zipOut = new ZipOutputStream(fos);
       for (String srcFile : directoryFiles) {
           File fileToZip = new File(srcFile);
           FileInputStream fis = new FileInputStream(fileToZip);
           ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
           zipOut.putNextEntry(zipEntry);
           
           byte[] bytes = new byte[1024];
           int length;
           while((length = fis.read(bytes)) >= 0) {
               zipOut.write(bytes, 0, length);
           }
           fis.close();
       }
       zipOut.close();
       fos.close();
    }
}