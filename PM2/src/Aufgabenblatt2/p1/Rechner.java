package Aufgabenblatt2.p1;

import java.util.HashMap;
import java.util.Map;

public class Rechner {
	
	private Map<Operation,BinaryOperator> rechnerMap;
	
	public Rechner(){
		rechnerMap = new HashMap<Operation,BinaryOperator>();
		rechnerMap.put(Operation.ADDITION, (x,y) -> {
			return x+y;
		});
		rechnerMap.put(Operation.SUBTRAKTION, (x,y) -> {
			return x-y;
		});
		rechnerMap.put(Operation.MULTIPLIKATION, (x,y) -> {
			return x*y;
		});
		rechnerMap.put(Operation.DIVISION, (x,y) -> {
			return x/y;
		});
	}
	public double berechne(Operation operation,double x,double y){
		
		BinaryOperator binaryOperation = rechnerMap.get(operation);
		return binaryOperation.operation(x, y);
		
	}
}
