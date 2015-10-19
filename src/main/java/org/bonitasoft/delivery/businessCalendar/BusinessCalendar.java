package org.bonitasoft.delivery.businessCalendar;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.objectlab.kit.datecalc.common.DateCalculator;
import net.objectlab.kit.datecalc.common.DefaultHolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayCalendar;
import net.objectlab.kit.datecalc.joda.LocalDateKitCalculatorsFactory;

import org.bonitasoft.delivery.businessCalendar.util.BusinessTime;
import org.bonitasoft.delivery.businessCalendar.util.BusinessTime.Day;
import org.bonitasoft.delivery.businessCalendar.util.ParcialTime;
import org.joda.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
/**
 * http://objectlabkit.sourceforge.net/
 * @author pablo.alonso
 *
 */
public class BusinessCalendar {
	private String name;
	private BusinessTime time;
	
	public BusinessCalendar(String name) throws Exception{
		this.name = name;
		try{
			//JSONTokener tokener = new JSONTokener(new FileReader(new File(this.getClass().getResource( "/configHolidays.json" ).toURI())));	
			JSONTokener tokener = new JSONTokener(new InputStreamReader(this.getClass().getResourceAsStream("/configHolidays.json")));
			
			JSONObject obj = new JSONObject(tokener);		
			Set<LocalDate> holidays = new HashSet<LocalDate>();		
			JSONArray array = obj.getJSONArray("holidays");

			for(int i = 0; i<array.length(); i++){
				holidays.add(new LocalDate(array.getString(i)));
			}
			HolidayCalendar<LocalDate> calendar = new DefaultHolidayCalendar<LocalDate>( holidays, new LocalDate(obj.getString("initDate")), new LocalDate(obj.getString("endDate")));
			LocalDateKitCalculatorsFactory.getDefaultInstance().registerHolidays(name, calendar);

			//tokener = new JSONTokener(new FileReader(new File(this.getClass().getResource( "/configTiming.json" ).toURI())));
			tokener = new JSONTokener(new InputStreamReader(this.getClass().getResourceAsStream("/configTiming.json")));
			obj = new JSONObject(tokener);
			array = obj.getJSONArray("config"); 
			time = new BusinessTime();
			ParcialTime p;
			for(int i = 0; i<array.length(); i++){
				JSONObject config = array.getJSONObject(i);
				String days = config.getString("days");
				JSONArray timing = config.getJSONArray("timing");
				List<ParcialTime> lp = new ArrayList<ParcialTime>();
				for(int j = 0; j<timing.length(); j++){
					JSONObject time = timing.getJSONObject(j);
					p = new ParcialTime(time.getString("init"), time.getString("end"));				
					lp.add(p);
				}
				time.setWeekWorkingTime(days, lp);			
			}
		}catch(Exception e){
			throw new Exception ("Error on Calendar Creation:"+e.getMessage());
		}		
	}
	
	public Date addBusinessHours(Date localDate, int workingHours) throws Exception{
		return addBusinessMinutes(localDate, workingHours* 60);
	}
	
	public Date addBusinessMinutes(Date localDate, int workingMinutes) throws Exception{
		int counter =  workingMinutes;
		DateCalculator<LocalDate> cal = LocalDateKitCalculatorsFactory.forwardCalculator(name);
		LocalDate theDay = new LocalDate(localDate);
		cal.setStartDate(theDay);
		theDay = cal.getCurrentBusinessDate();
		boolean notFinish = true;
		String date = new SimpleDateFormat("HH:mm").format(localDate);
		while(notFinish){
			counter = time.isThisDayToday(whichDay(theDay.getDayOfWeek()),counter,date);			
			if(counter >=0){
				notFinish = false;
			}else{
				theDay = cal.moveByBusinessDays(1).getCurrentBusinessDate();
				date = null;
				counter = Math.abs(counter);
			}
		}		
		return theDay.toDateTimeAtStartOfDay().plusMinutes(counter).toDate();
		
	}
	
	private Day whichDay(int dayOfWeek){
		switch(dayOfWeek){
		case 1:return Day.MONDAY;
		case 2:return Day.TUESDAY;
		case 3:return Day.WEDNESDAY;
		case 4:return Day.THURSDAY;
		case 5:return Day.FRIDAY;
		case 6:return Day.SATURDAY;
		default:return Day.SUNDAY;
		
		}
	}
	
		
}

