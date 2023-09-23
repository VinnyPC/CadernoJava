import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, -1);

        //Desafio 1 - Mostre a lista na ordem numérica:
        //1 cria uma stream a partir da lista numeros, permitindo que você realize operações em seus elementos.
        //2 sorted(): Isso classifica os elementos da stream em ordem natural (crescente).
        //3 forEach:  itera sobre cada elemento da stream e imprime cada elemento na saída padrão usando System.out::println

        //referenciando o método println da classe System.
        // Quando a stream itera sobre os elementos da lista,
        //o método println é chamado para imprimir cada elemento na saída padrão.

        //o operador :: é uma maneira concisa de referenciar métodos em Java,
        // tornando o código mais limpo e legível, especialmente ao trabalhar com expressões lambda e programação funcional.
        numeros.stream().sorted().forEach(System.out::println);

        //Desafio 2 - Imprima a soma dos números pares da lista:

        int soma = numeros.stream().filter(numero -> numero % 2 == 0)//filtra os numeros pares
                .mapToInt(Integer::intValue)//converte para um stream de inteiros
                .sum();//calcula a soma dos numeros pares

        System.out.println("A soma dos números pares é: " + soma);


        //Desafio 3 - Verifique se todos os números da lista são positivos:

        boolean todosPositivos = numeros.stream()
                .allMatch(numero -> numero > 0);//allMatch() verifica se todos os elementos de uma stream atendem a uma determinada condição.

        if(todosPositivos){
            System.out.println("Todos os números são positivos.");
        }else{
            System.out.println("Nem todos os números não são positivos.");
        }


        //Desafio 4 - Remova todos os valores ímpares:

        List<Integer> numerosPares = numeros.stream()
                .filter(numero -> numero % 2 == 0)//filter() é usado com a condição numero % 2 == 0, que verifica se um número é par.
                .collect(Collectors.toList());

        System.out.println("Lista original: " + numeros);
        System.out.println("Lista com números pares: " + numerosPares);
    }





}
