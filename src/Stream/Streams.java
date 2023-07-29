package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		
		//Stream API é usado para processar collections de objetos
		
		
		var funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario(1,"Jose","11111111",59));
		funcionarios.add(new Funcionario(2, "Maria", "22222222", 32));
		funcionarios.add(new Funcionario(3,"Pedro","3333333",59));
		funcionarios.add(new Funcionario(4,"Ana","11444111",59));
		funcionarios.add(new Funcionario(5,"Carlos",null ,59));
		funcionarios.add(new Funcionario(6,"Mariana",null,59));
		funcionarios.add(new Funcionario(7,"Lucas","11117711",59));
		funcionarios.add(new Funcionario(8,"Laura","11118811",59));
		funcionarios.add(new Funcionario(9,"Rafael","11991111",59));
		funcionarios.add(new Funcionario(10,"Camila","11100111",59));
		
		//para imprimir no console com for
		//for (var funcionario : funcionarios) {
			//System.out.println(funcionario);
			//para fazer algum filtro precisaria usar if ou algo do tipo
		//}
		
		//imprimir no console
		funcionarios.stream().forEach(System.out::println);
		
		System.out.println("----------------ordernar por nome-------------------");
		//ordernar por nome
		funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);
		
		System.out.println("---------------ordernar por nome invertido--------------------");
		//ordernar por nome invertido
		funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome).reversed()).forEach(System.out::println);

		System.out.println("-----------------ordernar por nome e idade------------------");
		//ordernar por nome e idade
		funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome).thenComparing(Comparator.comparing(Funcionario::getIdade))).forEach(System.out::println);
		
		System.out.println("---------------dois primeiros registros--------------------");
		//dois primeiros registros
		funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).limit(2).forEach(System.out::println);
		
		System.out.println("---------------media de idade--------------------");
		//mostrar a media de idade
		var mediaIdade = funcionarios.stream().mapToInt(Funcionario::getIdade).average();
		System.out.println(mediaIdade.getAsDouble());
		
		System.out.println("-------------Funcionarios acima da media de idade----------------------");
		
		funcionarios.stream().filter( f -> f.getIdade() > mediaIdade.getAsDouble()).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------------Funcionarios abaixo da media de idade----------------------");
		
		funcionarios.stream().filter( f -> f.getIdade() < mediaIdade.getAsDouble()).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------------Funcionario mais velho----------------------");
		var maisVelho = funcionarios.stream().max(Comparator.comparing(Funcionario::getIdade)).get();
		
		System.out.println(maisVelho);
		
		System.out.println("-------------Funcionario mais jovem----------------------");
		var maisJovem = funcionarios.stream().min(Comparator.comparing(Funcionario::getIdade)).get();
		System.out.println(maisJovem);
		
		System.out.println("-------------Funcionario com c no nome----------------------");
		funcionarios.stream().filter(f -> f.getNome().toLowerCase().contains("c")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-------------Soma das idades----------------------");
		var somaDasIdades = funcionarios.stream().mapToInt(Funcionario::getIdade).sum();
		System.out.println(somaDasIdades);
		
		System.out.println("-------------Transformando List em setList----------------------");
		var funcionarioSet = funcionarios.stream().collect(Collectors.toSet());
		funcionarioSet.forEach(System.out::println);
	}

}
