import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
/**
 * Created by A662943 on 11/05/2017.
 */

@Injectable()
export class CarService {

  constructor(private http: Http) {}

  getCarsSmall() {
    return this.http.get('https://www.primefaces.org/primeng/showcase/resources/data/cars-small.json')
      .map(res => res.json());
  }
}
