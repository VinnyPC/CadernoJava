package treinoJava.Generics;

import java.util.ArrayList;

public class Generics {

	public static void main(String[] args) {

		Printer<Integer> printer = new Printer<>(23);
		printer.print();

		Printer<Double> doublePrinter = new Printer<>(23.5);
		doublePrinter.print();
		// um lugar onde provavelmente sempre uso generics é no collections:
		// public class ArrayList<E> extends AbstractList<E>
		// implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Beattle");

		String miniCar = cars.get(0);

	}

}
