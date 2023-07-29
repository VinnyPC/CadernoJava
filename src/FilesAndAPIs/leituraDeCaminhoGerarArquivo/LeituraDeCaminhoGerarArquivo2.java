package FilesAndAPIs.leituraDeCaminhoGerarArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import FilesAndAPIs.leituraDeCaminhoGerarArquivo.entities.Product;

public class LeituraDeCaminhoGerarArquivo2 {

	/*Esse programa lê o caminho de um arquivo .csv,
	 * contendo dados de itens vendidos.
	 * Cada item possui um nome, preço unitario e quantidade separados por virgula
	 * O programa gera um novo arquivo chamado "summary.csv" locarizado em uma subpasta
	 * chamada "out" a partir da pasta original do arquivo de origem contendo o nome e o
	 * preço total unid * qtd */
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		//classe file criando um objeto para que possa ser passado o caminho
		File sourceFile = new File(sourceFileStr);
		//.getParent retorna um nivel anterior ao arquivo
		String sourceFolderStr = sourceFile.getParent();
		
		//criando a pasta out
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		//criando arquivo summary.csv
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		//fazendo a leitura do arquivo input.csv
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			//lendo cada linha que compoe o arquivo
			String itemCsv = br.readLine();
			while(itemCsv != null) {
				
				//split quebra a linha em tres valores usando o paramentro passado ","
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
			}
			
			//gravando no arquivo summary.csv
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				
				for (Product item: list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CREATED");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		
		sc.close();

	}

}
