package com.personal.kafkaesque.event;

public interface WeatherInfoEventListener {
	void onData(WeatherInfoEvent event);
    void processComplete();
}
