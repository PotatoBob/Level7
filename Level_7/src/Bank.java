import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {
    
    void updateBalances(List accounts){
   	 for (Object object : accounts) {
   		 double xtra = calculateInterest((BankAccount) object);
   		 BankAccount acc = (BankAccount) object;
   		 acc.money = acc.money + xtra;
   	 }
   	 
    }
    
    double calculateInterest(BankAccount account) {

   	 Date dateOpened = account.date;
   	 double amount = account.getBalance();
   	 
   	 double perc = 2.54/100;
   	 
   	 
   	 Calendar a = Calendar.getInstance(Locale.US);
    	a.setTime(new Date());
    	Calendar b = Calendar.getInstance(Locale.US);
    	b.setTime(dateOpened);
    	int diff = 0;//a.get(Calendar.YEAR) - b.get(Calendar.YEAR);
    	if (b.get(Calendar.MONTH) < a.get(Calendar.MONTH) && b.get(Calendar.DATE) < a.get(Calendar.DATE)) {
        	diff=1;
    	}
   	 
       
     //return  2.54 * amount;
   	 return diff * perc * amount;
    }


}



class BankAccount {

    Date date;
    double money;

    BankAccount(Date date, double money) {
   	 this.date = date;
   	 this.money = money;
    }
    

    public double getBalance() {
   	 // TODO Auto-generated method stub
   	 return money;
    }

}


