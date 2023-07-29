package treinoJava.Generics;

	//Antes de Generics, era preciso que fosse criada uma 
	//classe/método/interface diferente para
	//trabalhar com apenas um objeto:

//	public class IntegerPrinter {
//	Integer thingToPrint;
//	
//	public IntegerPrinter(Integer thingToPrint) {
//		this.thingToPrint = thingToPrint;
//	}
//	
//	public void print() {
//		System.out.println(thingToPrint);
//	}
// }

public class Printer <T>{
	T thingToPrint;
	public Printer(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}
	
	public void print() {
		System.out.println(thingToPrint);
	}
	
}
