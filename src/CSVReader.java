import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "C:\\dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();
        	LinkedList<Libro> listaLibros = new LinkedList<Libro>();
            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                Libro libro = new Libro(items[0],items[1],items[2]);
                String[] generos = items[3].split(" ");
                for (String genero:generos) {
                	libro.addGenero(genero);
                }
                listaLibros.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
