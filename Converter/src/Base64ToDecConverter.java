import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Base64ToDecConverter {

	public static void main(String[] args) {
		 
		Map<Object, BigDecimal> lookUpMap=createLookUp();
		
		String base64="BBrnl6pBpqIPDAY6OBCZYJrmAqotxdJp";
		BigDecimal decimal=BigDecimal.valueOf(0);
		
		int strlen=base64.length();
		for(int i=0; i<strlen; i++){
			decimal=decimal.add(BigDecimal.valueOf(64).pow(strlen-1-i).multiply(lookUpMap.get(base64.charAt(i))));
		}
		
		System.out.println(base64+"\n"+decimal);
		
	}
	
	private static Map<Object, BigDecimal> createLookUp(){
		char a=65;
		int i=0;
		Map<Object, BigDecimal> lookUpMap=new HashMap<>();
		
		for(; i<26; i++){
			lookUpMap.put(a, BigDecimal.valueOf(i));
			lookUpMap.put(((char)(a+32)), BigDecimal.valueOf(i+26));
			a++;
		}
		
		for(i=0, a=48; i<10;i++){
			lookUpMap.put(a, BigDecimal.valueOf(i+52));
			a++;
		}

		lookUpMap.put("+", BigDecimal.valueOf(62));
		lookUpMap.put("/", BigDecimal.valueOf(63));
		return lookUpMap;
	}
}
