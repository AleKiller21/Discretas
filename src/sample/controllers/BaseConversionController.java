package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.controllers.Utilities.ConverterHEX;

public class BaseConversionController {

    @FXML
    Button button;

    @FXML
    ComboBox<String> comboBox;

    @FXML
    ComboBox<String> comboBox2;

    @FXML
    Label number;

    @FXML
    Label lb;

    @FXML
    TextField numberfield;

    @FXML
    TextArea resultext;

    ConverterHEX c = new ConverterHEX();

    public BaseConversionController() {

    }
    
    public int toDecimal(String number, int base){
		int v = 0;
		int total = 0;
		int pow = 0;
		
		number = number.toUpperCase();
		
		for(int i = number.length() - 1; i>=0; i--){
			char c = number.charAt(i);
	        if (c >= '0' && c <= '9')
	            v = c - '0';
	        else if (c >= 'A' && c <= 'Z')
	            v = 10 + (c - 'A');
	        total += v * Math.pow(base, pow);
	        pow++;
			
		}
    	
		return total;
	}
    public String DectoOctal(int number){
    	int counter=0;
    	   int result = 0;
    	   while(number !=0) {
    	        int temp = (int) ((number%8) * Math.pow(10, counter));
    	        counter++;
    	        result += temp;
    	        number /= 8;
    	    }
    	   
    	    return result+"";
    	
    }
    public String DectoHex(int d){
    	String result = c.convertDecimalToHex(d);
    	
    	return result;

    }
    
    public int DectoBinary(int number, int binary){
		if(number == 0 || number == 1){
			return number;
		}
		binary = DectoBinary(number/2, binary);
		binary = binary*10 + (number%2);
		return binary;
	}
    
    public String BinarytoHex(String binary){
    	//TODO
    	int decimal = toDecimal(binary, 2);
    	String result = DectoHex(decimal);
    	return result;
    }
    
    public String BinaryToOct(String binary){
    	int decimal = toDecimal(binary, 2);
    	String result = DectoOctal(decimal);
    	
    	return result;
    	
    }
    
    public int OctalToDec(String number){
    	int a;
        int counter = 0;
        double product = 0;
        for ( int index = number.length() ; index > 0 ; index -- )
        {
            a = Character.getNumericValue( number.charAt( index - 1 ) );
            product = product + ( a * Math.pow( 8 , counter ) );
            counter ++ ;
        }
        return ( int ) product;
    }
    
    public String OctalToHex(String number){
    	int decimal = OctalToDec( number );
        String hex = DectoHex(decimal);
        return hex;
    }
    
    public String OctalToBin(String number){
    	int decimal = toDecimal(number, 8);
    	String hex = DectoBinary(decimal, 0)+"";
    	return hex;
    }
    
    public String HexToOctal(String number){
    	int decimal = toDecimal(number, 16);
    	String octal = DectoOctal(decimal);
    	
    	return octal;
    }
    public String HextoBinary(String hexString){
    	int decimal = toDecimal(hexString, 16);
    	String hex = DectoBinary(decimal, 0)+"";
    	
    	return hex;
    }

    public void callConvertNumber() {
        ConvertNumber(numberfield.getText(), comboBox.getValue(), comboBox2.getValue());
    }
    
    private void ConvertNumber(String number, String op1, String op2){
        try {
			String option = op1+"-"+op2;
			String result = "";


			switch(option){
				case "Hexadecimal-Binario":
					result = this.HextoBinary(number);
					break;
				case "Hexadecimal-Decimal":
					result = this.toDecimal(number, 16)+"";
					break;
				case "Hexadecimal-Octal":
					result = this.HexToOctal(number);
					break;
				case "Binario-Hexadecimal":
					if(Integer.toString(Integer.parseInt(number)).matches("[01]*"))
						result = this.BinarytoHex(number)+"";
					break;
				case "Binario-Decimal":
					if(Integer.toString(Integer.parseInt(number)).matches("[01]*"))
						result = this.toDecimal(number, 2)+"";
					break;
				case "Binario-Octal":
					if(Integer.toString(Integer.parseInt(number)).matches("[01]*"))
						result = this.BinaryToOct(number);
					break;
				case "Decimal-Hexadecimal":
					result = this.DectoHex(Integer.parseInt(number));
					break;
				case "Decimal-Binario":
					int num = Integer.parseInt(number);
					result = this.DectoBinary(num, 0)+"";
					break;
				case "Decimal-Octal":
					result = this.DectoOctal(Integer.parseInt(number));
					break;
				case "Octal-Decimal":
					if(number.matches("[8-9]+"))
						break;
					result = this.OctalToDec(number)+"";
					break;
				case "Octal-Binario":
					if(number.matches("[8-9]+"))
						break;
					result = this.OctalToBin(number);
					break;
				case "Octal-Hexadecimal":
					if(number.matches("[8-9]+"))
						break;
					result = this.OctalToHex(number);
					break;

			}

			resultext.setText(result);
		}

        catch(Exception ex) {
            resultext.setText("El valor ingresado no esta en el formato correcto");
        }
    }


}