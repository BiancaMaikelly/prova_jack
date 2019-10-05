import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Prova_bia{
    public static void main(String[] args) {
        ArrayList<Integer> vet = new ArrayList<Integer>();
        int AntValor = 0;
        int i = 0;

        try{
            BufferedReader leitura = new BufferedReader(new FileReader("VetorDesordenado.txt"));
            String value = "";
            while (true){
                if(value != null)
                {
                    //System.out.println(value);
                    if(value != "")
                    {
                        int valorInteiro = Integer.parseInt(value);
                        vet.add(valorInteiro);                    
                    }
                }else
                    break;
                    
                value = leitura.readLine();
            }
            leitura.close();
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }

        for(i = 0; i < vet.size(); i++){
            System.out.println("Valor Fora da ordem: " + vet.get(i));
        }
        System.out.println(" ");
            
        int PenultValor = vet.size()-1;

        for(i = 0; i<vet.size(); i++){
            for(int j = 0; j<PenultValor; j++){
                if(vet.get(j) > vet.get(j+1))
                {
                    AntValor = vet.get(j);
                    int ProxValor = vet.get(j+1);
                    vet.set(j, ProxValor);
                    vet.set(j+1, AntValor);
                }
            }
        }

        for(i = 0; i<vet.size(); i++){
            System.out.println("Valor na Ordem: "+vet.get(i));
        }

        try{
            BufferedWriter escrita = new BufferedWriter(new FileWriter("VetorOrdenado.txt"));
            
            for(i = 0; i<vet.size(); i++){
                int digitadoInt = vet.get(i);

                String digitado = Integer.toString(digitadoInt);
                // Scanner in = new Scanner(System.in);
                // digitado = in.nextLine();

                escrita.append(digitado + "\n");
                escrita.newLine();
                //in.close();
            }
            escrita.close();
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }        

        System.out.println("Novo arquivo de texto gerado com os números ordenados! VetorOrdenado.txt");

    }
    
}