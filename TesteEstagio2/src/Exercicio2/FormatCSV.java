/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Juan Amaral
 * 
 *  Tranformando os arquivos da tebela em csv
 *  informar lista 1, lista 2, nome do arquivo e tipo de separador
 * 
 */

public class FormatCSV {

    public void CreateCsv(List<String> ListFistField,List<String> ListLastField,String fileName,String separator) throws IOException{
        
        List<List<String>> rows = Arrays.asList();
        for(int i = 0;i<ListLastField.size();i++){
            rows = Arrays.asList(Arrays.asList(ListFistField.get(i),ListLastField.get(i)));
        }

      try (FileWriter csvWriter = new FileWriter(fileName + ".csv")) {  //título das tabelas
          csvWriter.append("Código");
          csvWriter.append(separator);
          csvWriter.append("Descrição da categoria");
          csvWriter.append(separator);
          

           for(int i = 0;i<ListFistField.size();i++){
            rows = Arrays.asList(Arrays.asList(ListFistField.get(i),ListLastField.get(i))); //juntando as 2 listas em 1, "lista.get(i)" e "lista.get(i)"

            for (List<String> rowData : rows) {
                csvWriter.append("\n");
                csvWriter.append(String.join(separator, rowData));
                csvWriter.append(separator);

            }
           }
          csvWriter.flush();
      }
      catch(IOException e){
          System.out.println("Error: " + e);
      }
    }
}