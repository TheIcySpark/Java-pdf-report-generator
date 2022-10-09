package com.mycompany.generador_reporetes_pdf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author bfran
 */
public class RWHtml {
    public static void readWrite(String data[]) throws FileNotFoundException{
        try (FileReader fr = new FileReader(new File("FormatoSolicitud.html"))) {
            BufferedReader read = new BufferedReader (fr);
            FileWriter fw = new FileWriter("docActual.html", false);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                String line, endOfFile = "</html>", id = "$";
                int i=0; //Número de dato
                while ((line= read.readLine()) != null ){
                    if (line.contains(endOfFile)){
                        bw.write(line);
                    }else{
                        if (line.contains(id)){
                            line = line.replace(id, data[i]);
                            bw.write(line + "\n");
                            i++;
                        }else{
                            bw.write(line + "\n");
                        }                      
                    }
                }
            }catch(IOException e){
                System.out.println(e);
            }
            fr.close();
        }catch(IOException e){
            System.out.print(e);
        }
    }
}
