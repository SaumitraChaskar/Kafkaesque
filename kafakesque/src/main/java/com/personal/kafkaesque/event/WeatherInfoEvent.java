package com.personal.kafkaesque.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfoEvent {
	
	@JsonProperty("stationId")
    private int stationId;
    
    @JsonProperty("temperature")
    private int temperature;
    
    
    public WeatherInfoEvent() {
		
	}
    
	public WeatherInfoEvent(int stationId, int temperature) {
		super();
		this.stationId = stationId;
		this.temperature = temperature;
	}


	public int getStationId() {
		return stationId;
	}


	public void setStationId(int stationId) {
		this.stationId = stationId;
	}


	public int getTemperature() {
		return temperature;
	}


	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}


	@Override
	public String toString() {
	    return "Weather Data [stationId=" + stationId + ", temperature=" + temperature + "]";
	  }

    
}
