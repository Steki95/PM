package Aufgabenblatt2.p1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {

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

	public double berechne(Operation operation, double x, double y) {

		return operationMap.get(operation).apply(x, y).doubleValue();
		

	}
}
