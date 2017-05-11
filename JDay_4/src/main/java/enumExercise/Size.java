package enumExercise;

public enum Size {
	S,
	M,
	L,
	XL,
	XXL;
	
	double getSurchargePercentage(){
		switch (this) {
		case XL:
			return 1.05;
		case XXL:
			return 1.1;
		default:
			return 1;
		}
	}
}
