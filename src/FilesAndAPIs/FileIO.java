package FilesAndAPIs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
		String[] nomes = { "Vinicius", "Silva", "Santos" };
		// gravando dados em um arquivo de texto

		// classe comumente usada para output de arquivos
		// toda vez que o programa rodar ele irá substituir o arquivo
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(
					"C:\\Users\\vinis\\Documents\\workspace-spring-tool-suite-4-4.17.2.RELEASE\\treinoJava\\output.txt"));

			// métodos de BufferedWriter aqui:
			// https://www.geeksforgeeks.org/io-bufferedwriter-class-methods-java/
			escritor.write("Escrevendo no arquivo");
			escritor.write("\nEscrevendo no arquivo 2");

			// Escrevendo um array
			for (String nome : nomes) {
				escritor.write("\n" + nome);
			}
			escritor.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// para ler conteudos de um arquivo

		try {
			BufferedReader leitor = new BufferedReader(new FileReader("output.txt"));
			// para ler todo o conteudo do arquivo
			String linha;
			while ((linha = leitor.readLine()) != null) {
				System.out.println(linha);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
