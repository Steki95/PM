package Aufgabenblatt6;

public class OfflineSendungsdauerSchaetzer implements SendungsdauerSchaetzer {

	/**
	 *Array der alle mogliche ort kombination hatt
	 */
	private int[][] alleDauern = { { 0, 172, 320, 333, 310, 354, 324, 284, 306, 225 },
			{ 170, 0, 423, 251, 285, 378, 235, 202, 216, 78 }, { 321, 424, 0, 324, 231, 141, 353, 345, 363, 407 },
			{ 330, 250, 322, 0, 119, 214, 42, 70, 62, 190 }, { 312, 284, 229, 117, 0, 129, 146, 141, 157, 261 },
			{ 353, 377, 144, 214, 131, 0, 243, 246, 253, 360 }, { 324, 237, 350, 42, 146, 242, 0, 57, 36, 178 },
			{ 283, 203, 344, 72, 142, 247, 56, 0, 32, 144 }, { 306, 218, 362, 62, 158, 253, 35, 34, 0, 158 },
			{ 227, 80, 407, 194, 265, 362, 178, 145, 159, 0 } };

	@Override
	public int getSendungsTransportDauer(Staedte senderOrt, Staedte empfaengerOrt) {
		int senderIndex = senderOrt.ordinal();
		int empfaengerIndex = empfaengerOrt.ordinal();
		return alleDauern[senderIndex][empfaengerIndex];
	}
}
