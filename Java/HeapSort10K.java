package arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSort10K {

    public static void main(String[] args) {

        FileReader fileReader;
        BufferedReader bufferedReader;

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        String name = "10K_Array_";
        int cont = 1;

        try {

            fileWriter = new FileWriter("C:\\Users\\bruno\\Desktop\\EP\\HeapSort\\Resultados" + "10K_Resultados.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            while (cont <= 250) {
                int i = 0;

                fileReader = new FileReader("C:\\Users\\bruno\\Desktop\\EP\\HeapSort\\Arrays\\10K" + name + cont + ".txt");
                System.out.println(name + cont + ".txt");
                bufferedReader = new BufferedReader(fileReader);

                String tamanho = bufferedReader.readLine();
                int[] vet = new int[Integer.parseInt(tamanho)];
                String linha = bufferedReader.readLine();

                long startTime = System.nanoTime();
                while (i < Integer.parseInt(tamanho) - 1) {
                    vet[i] = Integer.parseInt(linha);
                    linha = bufferedReader.readLine();
                    i++;
                }
                long endTime = System.nanoTime();
                long tempoLeitura = endTime - startTime;

                startTime = System.nanoTime();
                HeapSort.sort(vet);
                endTime = System.nanoTime();

                long duration = (endTime - startTime);

                String saida = name + cont + ".txt" + " " + tamanho + " " + tempoLeitura
                        + " " + duration + "i5-8250-8GHz-HD-1T_HeapSort_Java/8_Windows10_32-Bits_11207971";

                System.out.println(saida);
                bufferedWriter.write(saida);
                bufferedWriter.newLine();

                cont++;
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
