package com.room.proharvesting.phvroomdb.Utils;

import android.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public final class DateTools {
	public static Date toDate(String dateString) {
		//"MM/dd/yyyy HH:mm"
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try
        {       	       	
            Date date = simpleDateFormat.parse(dateString);
            return date;
        }
        catch (Exception ex)
        {
            return null;
        }
		
	}  
	public static String toString(Date date){

		String DATE_FORMAT_NOW = "yyyy/MM/dd HH:mm:ss";

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );

		return stringDate;
	}
	public static String toStringV1(Date date){

		String DATE_FORMAT_NOW = "MM/dd/yyyy HH:mm:ss";

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );

		return stringDate;
	}
	public static String toFormatFile(Date date){

		String DATE_FORMAT_NOW = "MMddyyyyHHmmss";

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );

		return stringDate;
	}
	public static int getYear(Date date){
		String DATE_FORMAT_NOW = "yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );
		if(stringDate.equals("")){
			stringDate="0";
		}
		return Integer.parseInt(stringDate);
	}
	public static int getMonth(Date date){
		String DATE_FORMAT_NOW = "MM";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );
		if(stringDate.equals("")){
			stringDate="0";
		}
		return Integer.parseInt(stringDate);
	}
	public static String getMonthAsString(Date date){
		String DATE_FORMAT_NOW = "MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );
		return stringDate;
	}
	public static int getDay(Date date){
		String DATE_FORMAT_NOW = "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date );
		if(stringDate.equals("")){
			stringDate="0";
		}
		return Integer.parseInt(stringDate);
	}
	public static String toStringShortDate(Date date){
		if(date!=null){
			String DATE_FORMAT_NOW = "yyyy/MM/dd";
		    
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			String stringDate = sdf.format(date );
			   
			return stringDate;
		}
		return "";
	}
	public static String toStringShortDateFile(Date date){
		if(date!=null){
			String DATE_FORMAT_NOW = "yyyy-MM-dd";

			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			String stringDate = sdf.format(date );

			return stringDate;
		}
		return "";
	}
	public static String toStringShortTime(Date date){
		if(date!=null){
			String DATE_FORMAT_NOW = "HH:mm:ss";
		    
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			String stringDate = sdf.format(date );
			  
			return stringDate;
		}
		else return "";
	}
	public static String toStringShortMiniTime(Date date){
		if(date!=null){
			String DATE_FORMAT_NOW = "HH:mm";
		    
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			String stringDate = sdf.format(date );
			   
			return stringDate;
		}
		else return "";
	}

	public static Date getDatePlusDays(Date date, int days){


		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
		Calendar cal = Calendar.getInstance();

		cal.setTime( date);

		cal.add(Calendar.DATE, days);
		String convertedDate=dateFormat.format(cal.getTime());
		return cal.getTime();

	}

	public static Date JSONDateToJavaDate(String JSONDate){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String JSONDate = "2012-06-26T15:51:59.078-0500"; 
		GregorianCalendar datum = new GregorianCalendar();

		try {
			datum.setTime(sdf.parse(JSONDate));
		} 
		catch (ParseException e) {
			System.out.print("Error");
			System.out.println();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.print(datum.toString());
		return datum.getTime();
		

	}
	public static long getMinutes(Date startDate, Date finishDate){
		long minutes =0; //
		minutes = TimeUnit.MILLISECONDS.toMinutes(finishDate.getTime()-startDate.getTime());
		
		return minutes;
	}
	public static long getSeconds(Date startDate, Date finishDate){
		long seconds =0; //
		seconds = TimeUnit.MILLISECONDS.toSeconds(finishDate.getTime()-startDate.getTime());

		return seconds;
	}
    public static String toPathDate(Date date){
        String DATE_FORMAT_NOW = "MM-dd-yyyy-HH-mm-ss";

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date );

        return stringDate;
    }
	public static Date addTimeByMinutes(Date date, int minutes){

		Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
		calendar.setTime(date);
		Date dateStart =calendar.getTime();
		calendar.add(Calendar.SECOND, minutes*60);
		Date dateFinish = calendar.getTime();
		return  dateFinish;
	}
	public static Date addTimeBySeconds(Date date, int seconds){

		Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
		calendar.setTime(date);
		Date dateStart =calendar.getTime();
		calendar.add(Calendar.SECOND, seconds);
		Date dateFinish = calendar.getTime();
		return  dateFinish;
	}


}
