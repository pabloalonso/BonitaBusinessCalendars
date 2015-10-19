package org.bonitasoft.delivery.businessCalendar.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessTime {
	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	private Map<Day, List<ParcialTime>> week;
	
	public BusinessTime(){
		super();
		this.week = new HashMap<BusinessTime.Day, List<ParcialTime>>();
	}
	
	/**
	 * 
	 * @param days Compound String 1234567 (whole week)... 125 (Monday, Tuesday and Friday)
	 * @param timing List of ParcialTime´s
	 */
	public BusinessTime(String days, List<ParcialTime> timing) {
		super();
		this.week = new HashMap<BusinessTime.Day, List<ParcialTime>>();
		setWeekWorkingTime(days, timing);
	}


	/**
	 * 
	 * @param days Compound String 1234567 (whole week)... 125 (Monday, Tuesday and Friday)
	 * @param timing
	 */
	public void setWeekWorkingTime(String days, List<ParcialTime> timing){
		char[] cs =  days.toCharArray();
		for(int i = 0; i < cs.length; i++){
			switch(cs[i]){
			case '1': this.week.put(Day.MONDAY, timing);
			break;	
			case '2': this.week.put(Day.TUESDAY, timing);
			break;
			case '3': this.week.put(Day.WEDNESDAY, timing);
			break;
			case '4': this.week.put(Day.THURSDAY, timing);
			break;
			case '5': this.week.put(Day.FRIDAY, timing);
			break;
			case '6': this.week.put(Day.SATURDAY, timing);
			break;
			case '7': this.week.put(Day.SUNDAY, timing);
			break;
			default: break;  
			}
			
		}
	}
	public int isThisDayToday(Day day, int minutes, String initTime) throws Exception{
		boolean today=false;
		int aux = minutes;
		List<ParcialTime> timings = week.get(day);		
		for(ParcialTime pt : timings){
			
			minutes = pt.getDiff(initTime, minutes);
			if(minutes > 0){
				//isToday
				today = true;
				break;
								
			}else{
				today= false;
				minutes = Math.abs(minutes);
				if(aux!=minutes)					
					initTime=null;
			}
		}
		if(today)
			return minutes;
		else
			return minutes*-1;
		
	}
	
	
	
	
	
	
	
}
