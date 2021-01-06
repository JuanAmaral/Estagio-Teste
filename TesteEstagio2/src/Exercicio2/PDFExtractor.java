/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author Juan Amaral
 * 
 * Extrair texto do pdf,
 * Informe o ´número da primeira página, do última página, primeira linha, última linha, diretório do arquivo pdf
 * 
 */
public class PDFExtractor {

    public List PDFExtractor(int minPage,int maxPage,int minLine,int maxLine,File file) throws IOException
    {
        ArrayList<String> content = new ArrayList<String>();
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(minPage);
        pdfStripper.setEndPage(maxPage);

        String pages = pdfStripper.getText(document);   //Ler todas as linhas em uma string

        String[] lines = pages.split("\r\n|\r|\n");     
        
        int line=1;                                   
        for(String temp:lines){
            if(line >= minLine && line <= maxLine){   //filtrar linhas
                //System.out.println(line+" "+temp);   //para visualizar linhas
                content.add(temp);                      //adicionar linha na lista
            }
            line++;
        }
        document.close();
        return content;
    }
   
}
