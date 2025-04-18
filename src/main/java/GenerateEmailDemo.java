import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {

		Date date = new Date();
		String dateString=date.toString();
		String noSpaceDateString=dateString.replaceAll("\\s", "");
		String noSpaceandnocolonsDateString=noSpaceDateString.replaceAll("\\:", "");
		String emailwithtimestamp=noSpaceandnocolonsDateString+"@gmail.com";
		System.out.println(emailwithtimestamp);
		
		
	}

}
