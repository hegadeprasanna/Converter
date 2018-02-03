import java.math.BigDecimal;
import java.util.Base64;

public class DecToBase64Converter {

	
	public static void main(String[] args) {
		
		 char[] lookUp = new char[] {  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
                'U', 'V', 'W', 'X', 'Y', 'Z', 
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
                'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '+', '/'};
		
		StringBuilder build= new StringBuilder();
		BigDecimal sixtyFour=BigDecimal.valueOf(64);
		
		BigDecimal decimal= new BigDecimal("100656668888888888834244242342343423423432432445345354345");
		BigDecimal j=decimal;

		while (j.compareTo(sixtyFour) > 0){

			build.append(lookUp[j.remainder(sixtyFour).intValue()]);
			j=j.divide(sixtyFour);		
			
		}
		build.append(lookUp[j.intValue()]);
	
		String base64=build.reverse().toString();
		System.out.println(decimal+"\n"+base64);
		
	}
}
