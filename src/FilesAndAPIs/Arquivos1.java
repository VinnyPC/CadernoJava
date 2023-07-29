package FilesAndAPIs;

import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
public class Arquivos1 {

	public static void main(String[] args) throws IOException {
		
		//diretorios
		//elemento "diretorio" do tipo Path
		//Classe Paths> metodo .get que retorna um path. Passamos uma string
		Path arquivo = Paths.get("C:/Users/vinis/Documents/workspace-spring-tool-suite-4-4.17.2.RELEASE/treinoJavaArquivos/arquivos1/1 - Copia (10)");
		Path diretorio = Paths.get("C:/Users/vinis/Documents/workspace-spring-tool-suite-4-4.17.2.RELEASE/treinoJavaArquivos/arquivos1");
		
		//isDirectory é um dos metodos da classe Files, que retorna boolean verificando se o mesmo existe ou nao
		if(Files.isDirectory(diretorio)) {
			System.out.println("Diretorio é um diretorio");
		}else {
			System.out.println("Diretorio não é um diretorio");
		}
		
		Files.delete(arquivo);
		
		//verifica se o arquivo existe
		if(Files.exists(diretorio)) {
			System.out.println("Arquivo existente");
		}else {
			System.out.println("Arquivo inexistente");
		}
		//veja mais métodos aqui:
		//https://www.geeksforgeeks.org/file-class-in-java/

	}

}
