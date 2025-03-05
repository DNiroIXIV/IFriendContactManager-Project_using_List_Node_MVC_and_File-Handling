import javax.swing.*;
import java.time.*;

public class TextFieldInputVerifier extends InputVerifier{
	public boolean verify(JComponent input){
		if(input instanceof JFormattedTextField){
			JFormattedTextField textField = (JFormattedTextField)input;			
			if(textField != null){
				String text = textField.getText();
				switch(textField.getName()){				
					case "contactNoTextField" : {
						String validPhoneNumberFormat = "^0\\d{9}$";
						String emptyField = "";
						for (int i = 0; i < 10; i++){
							emptyField+="_";							
						}
						
						if(!text.matches(validPhoneNumberFormat) && !text.equals(emptyField)){
							JOptionPane.showMessageDialog(null,"Contact number should start with \"0\" and must have 10 digits!","Invalid Contact Number Error!",JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
					}
					break;
					case "salaryTextField" : {					
						if(!text.isEmpty() && ((Number)textField.getValue()).doubleValue()<0){
							JOptionPane.showMessageDialog(null,"Salary should be a positive value!","Invalid Salary Error!",JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
					}
					break;
					case "birthdayTextField" : {						
						if(!text.equals("____-__-__")){
							String validDateFormat = "^\\d{4}-\\d{2}-\\d{2}$";							
							if(text.matches(validDateFormat)){
								LocalDate currentDate = LocalDate.now();								
								int currentYear = currentDate.getYear();
								int currentMonth = currentDate.getMonthValue();
								int currentDay = currentDate.getDayOfMonth();
								
								int year = Integer.parseInt(text.substring(0,4));
								String month = text.substring(5,7);
								int monthValue = Integer.parseInt(month);
								String day = text.substring(8);
								int dayValue = Integer.parseInt(day);
								
								String validMonthFormat = "^(0[1-9]|1[0-2])$";
								if(month.matches(validMonthFormat)){									
									if(isFutureDate(currentYear,currentMonth,currentDay,year,monthValue,dayValue)){
										JOptionPane.showMessageDialog(null,"Birthday field cannot contain a future date! Date should be on or before "+currentDate,"Future Date Error!",JOptionPane.INFORMATION_MESSAGE);
										return false;
									}		
									
									String[] monthName = {"January","February","March","April","May","June","July","August","September","October","November","December"};
									
									switch(monthValue){
										case 2  : {
											if(year%4==0 && (year%100!=0 || year%400==0)){														
												return printErrorMessage(dayValue==0 || dayValue>29, year, monthName[monthValue-1], "01 to 29");
											}
											return printErrorMessage(dayValue==0 || dayValue>28, year, monthName[monthValue-1], "01 to 28");
										}
										case 4  :
										case 6  :
										case 9  :
										case 11 : {
											return printErrorMessage(dayValue==0 || dayValue>30, year, monthName[monthValue-1], "01 to 30");
										}
										default : return printErrorMessage(dayValue==0 || dayValue>31, year, monthName[monthValue-1], "01 to 31");
									}									
								}
								JOptionPane.showMessageDialog(null,"Incorrect month value! Month value should be from 01 to 12","Invalid Date Error!",JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
							JOptionPane.showMessageDialog(null,"Missing one/more field value! Please input the date in the format YYYY-MM-DD","Date Format Violated!",JOptionPane.INFORMATION_MESSAGE);
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean printErrorMessage(boolean invalidDay, int year, String monthName, String dateRange){
		if(invalidDay){
			JOptionPane.showMessageDialog(null,"Incorrect day value for "+monthName+", "+year+"! Day value should be from "+dateRange+"...","Invalid Date Error!",JOptionPane.INFORMATION_MESSAGE);
		}
		return !invalidDay;
	}
	
	public boolean isFutureDate(int currentYear, int currentMonth, int currentDay, int year, int month, int day){
		if(year>currentYear){
			return true;
		}
		if(year==currentYear){
			if(month>currentMonth){
				return true;
			}
			if(month==currentMonth && day>currentDay){
				return true;
			}
		}
		return false;		
	}
}

