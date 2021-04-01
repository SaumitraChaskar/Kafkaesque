import { Component, HostListener, OnInit, OnDestroy } from '@angular/core';
import { IWeatherInfo } from '../../app/models'
import { Observable } from 'rxjs'
import { WeatherInfoService } from '../weatherinfo.service'

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})

export class WeatherComponent implements OnInit, OnDestroy {

  weatherInfo$: Observable<IWeatherInfo[]>;
  all: IWeatherInfo[];

  constructor(private service: WeatherInfoService) { }
  
  ngOnInit() {
    this.service.startWeatherInfoEventSource();
    this.weatherInfo$ = this.service.weatherData;
    console.log(this.weatherInfo$);
  }

  ngOnDestroy() {
    this.service.onClose();
  }

  @HostListener('window:beforeunload', [ '$event' ])
  unloadHandler(event) {
    console.log('unloadHandler');
    this.service.onClose();
  }

}
