
public class Conditionals {

	public static void main(String[] args) {
		int score = 45;
		char grade;
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 50) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("Student Grade is " + grade);

		int dayOfWeek = 3;
		String dayName;

		if (dayOfWeek == 1) {
			dayName = "Sunday";
		} else if (dayOfWeek == 2) {
			dayName = "Monday";
		} else if (dayOfWeek == 3) {
			dayName = "Tuesday";
		} else if (dayOfWeek == 4) {
			dayName = "Wednesday";
		} else if (dayOfWeek == 5) {
			dayName = "Thursday";
		} else if (dayOfWeek == 6) {
			dayName = "Friday";
		} else {
			dayName = "Satruday";
		}

		System.out.println("Day Name : " + dayName);

		switch (dayOfWeek) {
		case 1:
			dayName = "Sunday";
			break;
		case 2:
			dayName = "Monday";
			break;
		case 3:
			dayName = "Tuesday";
			break;
		case 4:
			dayName = "Wednesday";
			break;
		case 5:
			dayName = "Thursday";
			break;
		case 6:
			dayName = "Friday";
			break;
		default:
			dayName = "Saturday";
		}

		System.out.println("Day Name using switch : " + dayName);
	}

}
