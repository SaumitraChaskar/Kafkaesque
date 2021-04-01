import { WeatherComponent} from '../app/weather/weather.component'

import {Routes} from '@angular/router';
import { AppComponent } from './app.component';


export const routes : Routes = [
{
    path : 'weather' , component : WeatherComponent
},
{
    path : '' , component : AppComponent
},
];
