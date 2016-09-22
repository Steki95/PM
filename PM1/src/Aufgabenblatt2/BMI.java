/**
* Praktikum TIPR1, SS 2016
* Gruppe: Stefan Belic (max.muster@haw-hamburg.de),
* Mia Meister (mia.meister@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 2.2
* 
*/

package Aufgabenblatt2;

import java.util.Scanner;

/**
 * 
 * Berechnung des Body-Mass index mit hilfe der Grose in cm und des Gewichts in kg
 * 
 */

public class BMI {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		double hohe,gewicht;
		int bmi;
		
		//Eingabe der Hohe in cm
		System.out.println("Bitte geben sie die Hohe in cm ein: ");
		hohe = input.nextDouble();
		
		//Eingabe des Gewichts in kg
		System.out.println("Bitte geben sie jetz das Gewicht in kg: ");
		gewicht = input.nextDouble();
		
		//Berechnung des Body-Mass-Index
		hohe = hohe/100;//Verwandlung der Hohe von cm in m
		bmi =(int) (gewicht/(hohe*hohe)+0.5); //casting von double ins int
		
		//Ausgabe
		System.out.println("Der BMI ist : "+bmi);
		input.close();
	}
}
