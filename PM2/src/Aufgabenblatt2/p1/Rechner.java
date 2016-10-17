package Aufgabenblatt2.p1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {

	/**
	 * Eine hashmap wo alle operationen gescpeichert sind
	 */
	private Map<Operation, BinaryOperator<Double>> operationMap;

	public Rechner() {
		operationMap = new HashMap<Operation, BinaryOperator<Double>>();
		operationMap.put(Operation.ADDITION, (x, y) -> {
			return x + y;
		});
		operationMap.put(Operation.SUBTRAKTION, (x, y) -> {
			return x - y;
		});
		operationMap.put(Operation.MULTIPLIKATION, (x, y) -> {
			return x * y;
		});
		operationMap.put(Operation.DIVISION, (x, y) -> {
			return x / y;
		});
	}

	/**
	 * Nimmt als argument die operation die wir ausfuhren wollen und zwei zahlen 
	 * zwischen dennen wir die operation ausfuhren
	 * @param operation die wir ausfuhren
	 * @param x zahl 1
	 * @param y zahl 2
	 * @return gibt die losung der operation zuruck
	 */
	public double berechne(Operation operation, double x, double y) {

		return operationMap.get(operation).apply(x, y).doubleValue();
		

	}
}
