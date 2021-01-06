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

/**¨&

 * @author Juan Amaral
 * 
 * Proposta: 
 * 
 * - Extrair do pdf anexo os dados dos Quadros 30,31,32 (Tabela de categoria do Padrão TISS);
 * - Salvar dados dessas tabelas em csvs;
 * - Zipar todos os csvs num arquivo "Teste_Intuitive_Care_{seu_nome}.zip".
 * 
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        File file = new File("./Padrao_TISS_Componente_Organizacional__201902.pdf"); 
        PDFExtractor pdf = new PDFExtractor();
        FormatList formatList = new FormatList();
        FormatCSV csv = new FormatCSV();
        
        
        //Primeira Tabela
        List<String> quadro30 = new ArrayList<String>();
        quadro30.addAll(pdf.PDFExtractor(90,91,43,47,file));    //pagina inicial,pagina final, linha inicial,linha final,diretório
        csv.CreateCsv(formatList.ListFirstField(quadro30),formatList.ListLastField(quadro30),"Quadro_30",","); //lista 1, lista 2, nome arquivo, separador
        
        //Segudna Tabela
        List<String> quadro31 = new ArrayList<String>();
        quadro31.addAll(pdf.PDFExtractor(90,96,69,71,file));    
        quadro31.addAll(pdf.PDFExtractor(90,96,76,102,file));
        quadro31.addAll(pdf.PDFExtractor(90,96,107,133,file));
        quadro31.addAll(pdf.PDFExtractor(90,96,138,167,file));
        quadro31.addAll(pdf.PDFExtractor(90,96,172,202,file));
        quadro31.addAll(pdf.PDFExtractor(90,96,207,233,file));   
        csv.CreateCsv(formatList.ListFirstField(quadro31),formatList.ListLastField(quadro31),"Quadro_31",",");
        

        
        //Terceira Tabela
        List<String> quadro32 = new ArrayList<String>();
        quadro32.addAll(pdf.PDFExtractor(95,97,109,111,file)); //pagina inicial,pagina final, linha inicial,linha final,diretório
        csv.CreateCsv(formatList.ListFirstField(quadro32),formatList.ListLastField(quadro32),"Quadro_32",",");
        
        
        //Compactando arquivos
        List<String> FilesStringList = new ArrayList<String>();
        FilesStringList.add("Quadro_30.csv");
        FilesStringList.add("Quadro_31.csv");
        FilesStringList.add("Quadro_32.csv");
        
        Zip zip = new Zip("Teste_Intuitive_Care_{Juan_Amaral}", FilesStringList);

    }

}
