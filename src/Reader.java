import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Sławomir Ciecierski
 * Program wylicza ilośc unikatowych słów z pliku tekstowego
 */
public class Reader {
  public static void main(String[] args) throws IOException {


    calculateWords(bufferedReaderExample());
  }

  /**
   * wylicza ilość unikalnych słów
   * @param myExample
   */
  private static void calculateWords(String myExample) {

    int myCounter = 0;
    Set<String> kluczeSzukajace=new HashSet<>();
    String pattern=" ";
    String result[] = myExample.split(pattern);
    Collections.addAll(kluczeSzukajace, result);


   myCounter=0;
    for(String item : kluczeSzukajace) {
      for(int i=0;i<result.length;i++){
        if (item.equals(result[i])){
          myCounter++;
        }

      }
      System.out.println("Słowo "+item+" występuje w ilości: "+myCounter);
      myCounter = 0;
    }



  }

  /**
   * zwraca zawartość pliku w postaci linii
   * @return  allLines
   * @throws IOException
   */
  private static String bufferedReaderExample() throws IOException {
    int a = 0;
    /**
     * allLines = pusty
     */
    String allLines = "";
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(source()))) {
      String line = bufferedReader.readLine();
      while (true) {
        a++;
        //System.out.println(a);
        if (line == null) break;
        //System.out.println(line);
        allLines = allLines + line + " ";
        //System.out.println(allLines+" ");
        line = bufferedReader.readLine();
      }
    }
    return allLines;
  }

  /**
   * zwraca obiekt klasy, która będzie użyta do pobrania danych
   * tu: plik
   * @return openFile();
   * @throws IOException
   */
  private static InputStream source() throws IOException {
    return openFile();
    // return openConnection();
    // return inMemory();
  }

  /**
   * zwraca strumień pliku o nazwie podanej w argumencie
   * @return InputStream
   * @throws FileNotFoundException
   */
  private static InputStream openFile() throws FileNotFoundException {
    return new FileInputStream(Paths.get("src", "text1.txt").toFile());
  }


}

