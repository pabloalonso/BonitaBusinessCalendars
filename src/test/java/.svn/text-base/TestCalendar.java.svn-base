import java.util.Calendar;
import java.util.Date;

import org.bonitasoft.delivery.businessCalendar.BusinessCalendar;
import org.junit.Assert;
import org.junit.Test;

	public class TestCalendar {
		
		private BusinessCalendar calendar;

		
		@SuppressWarnings("unused")
		@Test
		public void testCreationCalendar() {
			BusinessCalendar cal;
			boolean thrown =  false; 
			try{
				cal = new BusinessCalendar("HO");
			}catch(Exception e){
				thrown = true;
			}
			Assert.assertFalse(thrown);
		}
		
		
		@Test
		public void testResultZero(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 9, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{				
				Assert.assertEquals(calendar.addBusinessHours(d, 0 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultFirstTime(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 9, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{
				aux.setHours(10);				
				Assert.assertEquals(calendar.addBusinessHours(d, 1 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultSecondTime(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 9, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{
				aux.setHours(18);				
				Assert.assertEquals(calendar.addBusinessHours(d, 4 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultNextDay(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 9, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{
				aux.setHours(19);
				aux.setDate(aux.getDate()+1);
				Assert.assertEquals(calendar.addBusinessHours(d, 12 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultBeforeFirstDay(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 7, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{		
				aux.setHours(10);
				Assert.assertEquals(calendar.addBusinessHours(d, 2 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultAfterFirstDay(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 25, 21, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{
				aux.setHours(10);
				aux.setDate(aux.getDate()+1);
				Assert.assertEquals(calendar.addBusinessHours(d, 2 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testResultNextDayWithHoliday(){
			boolean thrown =  false; 
			createCalendar();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(0);
			cal.set(2015,2, 23, 9, 0, 0);
			Date d = cal.getTime();
			Date aux =  cal.getTime(); 
			
			try{
				aux.setHours(19);
				aux.setDate(aux.getDate()+2);
				Assert.assertEquals(calendar.addBusinessHours(d, 12 ), aux);
			}catch(Exception e){
				thrown = false;
			}
			Assert.assertFalse(thrown);	 
		}
		
		private void createCalendar(){
			try{
				this.calendar = new BusinessCalendar("HO");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
	