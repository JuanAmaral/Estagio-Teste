
package Exercicio1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;

/**
 * @author Juan Amaral
 * 
 * Proposta: 
 * 
 * 1-Acessar o site: http://www.ans.gov.br/prestadores/tiss-troca-de-informacao-de-saude-suplementar;
 * 2-Buscar a versão mais recente do Padrão TISS (arquivo - padrao_tiss_componente_organizacional_201902.pdf);
 * 3-Baixar o componente organizacional;
 * 
 */

public class Main {
     public static void main(String[] args) throws MalformedURLException, IOException {
        
        LocalDate localDate = LocalDate.now();

        
        DownloaderUrl downloaderUrl = new DownloaderUrl();//Download da versão mais recente
        //DownloaderUrl downloaderUrl = new DownloaderUrl(2019,02); //Download da versão solicitada durante o enunciado

     }
    
}
