package org.bonitasoft.delivery.businessCalendar.util;

public class ParcialTime {

	int initHours;
	int endHours;
	int init;
	int end;
	int initMinutes;
	int endMinutes;
	
	public ParcialTime(int initHours, int initMinutes, int endHours,
			int endMinutes) {
		super();
		this.initHours = initHours;
		this.initMinutes = initMinutes;
		this.endHours = endHours;
		this.endMinutes = endMinutes;
		this.init = 60*initHours + initMinutes;
		this.end = 60*endHours + endMinutes;
	}	
	
	public ParcialTime(String initTime, String endTime) throws Exception{
		String[] aux;
		if(initTime!= null && initTime.length()==5 && initTime.charAt(2)==':'){
			aux = initTime.split(":");
			this.initHours = new Integer(aux[0]).intValue();
			this.initMinutes = new Integer(aux[1]).intValue();
		}else{
			throw new Exception("initTime does not follow the following structure 'hh:mm'");
		}
		if(endTime!= null && endTime.length()==5 && endTime.charAt(2)==':'){
			aux = endTime.split(":");
			this.endHours = new Integer(aux[0]).intValue();
			this.endMinutes = new Integer(aux[1]).intValue();
		}else{
			throw new Exception("endTime does not follow the following structure 'hh:mm'");
		}
		if( endHours < initHours || ( endHours == initHours && endMinutes <= initMinutes) ){
			throw new Exception("End date is smaller or equal than Init date");
		}
		this.init = 60*initHours + initMinutes;
		this.end = 60*endHours + endMinutes;
		
	}
	/**
	 * 	
	 * @param initTime Time to start, empty/null if init time
	 * @param numMinutes Number of minutes (60 * numnHours) to calculate
	 * @return
	 * @throws Exception
	 */
	public Integer getDiff(String initTime, int numMinutes) throws Exception{
		//System.out.println("Minutes:"+numMinutes +"\t"+initHours+":"+initMinutes+"  "+initTime+"  "+endHours+":"+endMinutes);
		String[] aux;
		int currentTime;		
		if(initTime!= null && initTime.length()==5 && initTime.charAt(2)==':'){
			aux = initTime.split(":");
			int hours = new Integer(aux[0]).intValue();
			int minutes = new Integer(aux[1]).intValue();
			currentTime = hours * 60 + minutes;
		}else{
			if(initTime == null || initTime.length()==0){
				currentTime = init;
			}else{
				throw new Exception("initTime does not follow the following structure 'hh:mm' : "+initTime);
			}
		}
		if(currentTime >= init){
			if(end  > currentTime){
				//System.out.println("Minutos: "+numMinutes +" \tTiempoTramo: "+(end - currentTime)+"\tPOS: "+(currentTime + numMinutes)+"\tNEG: "+(end - (currentTime + numMinutes)));
				if( end - (currentTime + numMinutes)>=0)
					return currentTime + numMinutes;
				else
					return end - (currentTime + numMinutes);
			}else{
				return numMinutes * (-1);
			}
		}else{
			throw new Exception("initTime is before initial time of the journey");
		}

		
		
	}
}
