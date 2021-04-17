package com.sapient.weather.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.weather.common.constants.CommonConstants;
import com.sapient.weather.data.WeatherDao;
import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;
import com.sapient.weather.entity.Weather;
import com.sapient.weather.entity.WeatherList;
import com.sapient.weather.entity.WeatherWebResponse;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	WeatherDao weatherDao;
	
	WeatherWebResponse weatherWebResponse; 
	
	@Override
	public WeatherWebResponse getWeatherResponse(ListWeatherRequest body) throws Exception {
		ListWeatherResponse response; 
		
		ResponseEntity<ListWeatherResponse> strresponse = weatherDao.getWeatherData(body);
		response = strresponse.getBody();
		
		weatherWebResponse = new WeatherWebResponse();
		weatherWebResponse.setCnt(response.getCnt());
		weatherWebResponse.setCod(response.getCod());
		weatherWebResponse.setMessage(response.getMessage());
		
		List<String> dt = new ArrayList<String>(Arrays.asList(null,null,null));
		List<Float> min_Temp = new ArrayList<Float>(Arrays.asList(null,null,null));
		List<Float> max_Temp = new ArrayList<Float>(Arrays.asList(null,null,null));
		//Float min_Temp = null;
		//Float max_Temp = null;
		List<String> main = new ArrayList<String>(Arrays.asList(null,null,null));
		List<String> description = new ArrayList<String>(Arrays.asList(null,null,null));
		List<Integer> id = new ArrayList<Integer>(Arrays.asList(null,null,null));
		List<String> icon = new ArrayList<String>(Arrays.asList(null,null,null));
		
		List<WeatherList> weatherList = response.getWeatherList();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    String strDate = formatter.format(date);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    
	    GregorianCalendar cal = new GregorianCalendar();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, 1);
	    Date startDt = formatter.parse(formatter.format(cal.getTime()));
	    cal.add(Calendar.DATE, 2);
	    Date endDt = formatter.parse(formatter.format(cal.getTime()));
	    Date testDt;
	    
	    //System.out.println("Start date is " + startDt + "\nEnd Date is " + endDt);
		try {
			//assign first value
			Date x = null;
			Boolean first=true;
			int ctr=0;
			for (WeatherList w : weatherList) {
				testDt = formatter.parse(w.getDt_txt());
				//System.out.println("Test Dt : " + testDt + " * " + "Start Dt:"+startDt + "*" + testDt.compareTo(startDt));
				//System.out.println("Test Dt : " + testDt + " * " + "End Dt:"+endDt + "*" + testDt.compareTo(endDt));
				if (testDt.compareTo(startDt) >= 0 && testDt.compareTo(endDt) <= 0) 
				{
					if (first) 
					{
						x = testDt;
						first = false;
					}
					if(x.compareTo(testDt) != 0) 
					{
						//System.out.println("x = "+x + " -- testDt="+testDt);
						ctr += 1;
						//x = formatter.parse(weatherList.get(ctr).getDt_txt());
						x = testDt;
					}
					else if (x.compareTo(testDt) == 0)
					{
						System.out.println("Testdt="+sdf.format(testDt));
						
						dt.set(ctr,sdf.format(testDt));
						if (min_Temp.get(ctr) == null) min_Temp.set(ctr, w.getMain().getTemp_min());
						if (max_Temp.get(ctr) == null) max_Temp.set(ctr, w.getMain().getTemp_max());
						if (w.getMain().getTemp_min() < min_Temp.get(ctr)) min_Temp.set(ctr, w.getMain().getTemp_min());
						if(w.getMain().getTemp_max() > max_Temp.get(ctr)) max_Temp.set(ctr, w.getMain().getTemp_max());
						//min_Temp.add(w.getMain().getTemp_min());
						//max_Temp.add(w.getMain().getTemp_max());
					  	for (Weather weather : w.getWeather()) {
					  		id.set(ctr, weather.getId());
					  		main.set(ctr, weather.getMain());
					  		description.set(ctr, weather.getDescription());
					  		icon.set(ctr, CommonConstants.IMG_URL + weather.getIcon() + CommonConstants.IMG_EXT);
						}
					}
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		weatherWebResponse.setDt(dt);
		weatherWebResponse.setLow_temp(min_Temp);
		weatherWebResponse.setHigh_temp(max_Temp);
		//weatherWebResponse.setHigh_temp(max_Temp);
		//weatherWebResponse.setLow_temp(min_Temp);
		weatherWebResponse.setId(id);
		weatherWebResponse.setMain(main);
		weatherWebResponse.setDescription(description);
		weatherWebResponse.setIcon(icon);
		weatherWebResponse.setAdvice(getAdviceText(id, max_Temp));
		return weatherWebResponse;
	}

	private List<String> getAdviceText(List<Integer> id, List<Float> max_Temp) {
		List<String> response = new ArrayList<String>(Arrays.asList(null,null,null));
		
		for(int i= 0;i < id.size();i++)
		{
			if (id.get(i) == 200 || id.get(i) == 300 || id.get(i) == 500)
			{
				response.set(i,CommonConstants.CARRY_UMBRELLA);
			}
		}
		
		for (int i=0;i<max_Temp.size();i++)
		{
			if(max_Temp.get(i) > 40)
			{
				response.set(i, CommonConstants.USE_SUNSCREEN);
			}
		}
		
		
		return response;
	}

}
