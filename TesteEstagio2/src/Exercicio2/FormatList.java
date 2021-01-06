/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Juan Amaral
 * 
 * Formatação de 2 listas, primeira capturando números no primeiro campo e segundo letras do segundo campo
 * 
 */
public class FormatList {
    public List<String> ListFirstField(List<String> list)
    {
        /**
         * Aqui verifica se o primeiro espaço é composto por números e o método os retorna
         */
        
        List<String> fistField = new ArrayList<String>();   
        
        for(int i =0;i<list.size();i++){                    
            if(!list.get(i).trim().equals("")){                                         //remover campos vazios
                String firstWord = list.get(i).substring(0, list.get(i).indexOf(" "));  //capturar primeira palavra da lista
                if(firstWord.matches("[0-9]*")){                                         
                    fistField.add(firstWord);
                }
            }
        }
      return fistField;
    }

     public List<String> ListLastField(List<String> list)
     {
       /**
        *   Alguns campos de texto da coluna 2,possuem 2 linhas, formatado a tabela para que cada campo possua 1 linha junto com o respectivo numeral a esquerda
        */
         
         for(int i =0;i<list.size();i++){
             String firstWord = list.get(i).substring(0, list.get(i).indexOf(" "));     //capturar primeira palavra da lista
                if(!firstWord.matches("[0-9]*")){                                       //verificar se o primeiro campo é diferente de numérico
                    int ant = i-1;
                    int prox = i+1;
                    list.set(ant,list.get(ant) + list.get(i));
                    list.remove(i);
                     if(!firstWord.matches("[0-9]*")){                                  
                        list.set(ant,list.get(ant) + list.get(i));
                        list.remove(i);
                    }
                }
            }

        ArrayList<String> lastField = new ArrayList<String>();    //lista para último campo da tabela
        
        for(int i = 0;i<list.size();i++){ 
                if(!list.get(i).trim().equals("")){                                                 //remover campos vazios
                String SecondWord = list.get(i).substring(list.get(i).indexOf(" "), list.get(i).length()); 
                SecondWord.replaceAll("\n","").replaceAll("\r","");                                        //remover quebra de linha
                lastField.add(SecondWord.substring(1, SecondWord.length()-1));                                    //adicionar na lista removendo primeiro e o 1 último espaço
            }
        }
        return lastField;
         
    }
         
     
     
   
}
