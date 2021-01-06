/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio1;


import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


/**
 * Realizando a pesquisa no formato de YYYYMM pela url
 * para realizar o download do arquivo mais recente do Padrão TISS
 * 
 * Atenção!, existe mais de um tipo de url!
 */

public class DownloaderUrl {

     public DownloaderUrl() throws MalformedURLException, IOException{//Download da versão mais recente
        URL urll = null;
        URL url2 = null;
         
         String version = "";
        LocalDate localDate = LocalDate.now(); //data atual
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        
        version = month<10?  Integer.toString(year) + "0" +Integer.toString(month) + ".pdf" : Integer.toString(year) + Integer.toString(month) + ".pdf";
        
        /**
         * Versões da URL!
         * Durante os testes, foi detectado que nas versões anteriores a url pode variar
         */

        urll = new URL("http://www.ans.gov.br/images/stories/Plano_de_saude_e_Operadoras/tiss/Padrao_tiss/tiss3/Padrao_TISS_Componente_Organizacional__" + version); 
        url2 = new URL("http://www.ans.gov.br/images/stories/Plano_de_saude_e_Operadoras/tiss/Padrao_tiss/tiss3/padrao_tiss_componente_organizacional_" + version); 
        
        File file = new File("C:\\Users\\lgdfj\\Downloads\\Padrao_TISS_Componente_Organizacional__" + version); //diretorio

        Connection(urll,url2,year,month,file);
        
    }

    public DownloaderUrl(int year,int month) throws MalformedURLException, IOException{//Data customizada

        URL urll = null;
        URL url2 = null;
        String version = "";
        
        version = month<10?  Integer.toString(year) + "0" +Integer.toString(month) + ".pdf" : Integer.toString(year) + Integer.toString(month) + ".pdf";
        
        urll = new URL("http://www.ans.gov.br/images/stories/Plano_de_saude_e_Operadoras/tiss/Padrao_tiss/tiss3/Padrao_TISS_Componente_Organizacional__" + version); 
        url2 = new URL("http://www.ans.gov.br/images/stories/Plano_de_saude_e_Operadoras/tiss/Padrao_tiss/tiss3/padrao_tiss_componente_organizacional_" + version); 
        File file = new File("C:\\Users\\lgdfj\\Downloads\\Padrao_TISS_Componente_Organizacional__" + version);
        
        Connection(urll,url2,year,month,file);
        
    }
    
    public void Connection(URL url1,URL url2,int year,int month,File directory) throws MalformedURLException, IOException{   
        
        try (ReadableByteChannel rbc = Channels.newChannel(url1.openStream()); FileOutputStream fos = new FileOutputStream(directory)) {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("Tentei URL 1");
            }
        
        catch(FileNotFoundException e) //Exceção caso o arquivo não seja encontrado
        {
            /**
            * Durante os testes, foi detectado auxência em relatórios de alguns meses, foi então criado um decremento de meses
            */
            
            try (ReadableByteChannel rbc = Channels.newChannel(url2.openStream()); FileOutputStream fos = new FileOutputStream(directory)) 
            {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            }
            catch(FileNotFoundException ex)
            {
                if(month==0){ 
                    new DownloaderUrl(year-1,12);
                }
                else
                {
                    new DownloaderUrl(year,month-1);
                }
            }    
        }  
    }
}
