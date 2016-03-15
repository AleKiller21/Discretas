package sample.controllers.Utilities;
import java.util.HashMap;

public class ConverterHEX {
	HashMap<String, String> fromBinary = new HashMap<String, String>();
	HashMap<Integer, String> fromDecimal = new HashMap<Integer, String>();
	
	public ConverterHEX() {
		fill();
	}
	
	public void fill(){
		fromBinary.put("0000", "0");
		fromBinary.put("0001", "1");
		fromBinary.put("0010", "2");
		fromBinary.put("0011", "3");
		fromBinary.put("0100", "4");
		fromBinary.put("0101", "5");
		fromBinary.put("0110", "6");
		fromBinary.put("0111", "7");
		fromBinary.put("1000", "8");
		fromBinary.put("1001", "9");
		fromBinary.put("1010", "A");
		fromBinary.put("1011", "B");
		fromBinary.put("1100", "C");
		fromBinary.put("1101", "D");
		fromBinary.put("1110", "E");
		fromBinary.put("1111", "F");
		
		fromDecimal.put(0, "0");
		fromDecimal.put(1, "1");
		fromDecimal.put(2, "2");
		fromDecimal.put(3, "3");
		fromDecimal.put(4, "4");
		fromDecimal.put(5, "5");
		fromDecimal.put(6, "6");
		fromDecimal.put(7, "7");
		fromDecimal.put(8, "8");
		fromDecimal.put(9, "9");
		fromDecimal.put(10, "A");
		fromDecimal.put(11, "B");
		fromDecimal.put(12, "C");
		fromDecimal.put(13, "D");
		fromDecimal.put(14, "E");
		fromDecimal.put(15, "F");
	}
	
	
	public String convertDecimalToHex(int b){
		String result = "";
		int num = b;
		while(num/16>0){
			result=fromDecimal.get(num%16)+result;
			num=num/16;
		}
		result=fromDecimal.get(num%16)+result;
		System.out.println(result);
		return result;
	}
	
}
