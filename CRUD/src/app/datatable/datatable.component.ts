import { Component, OnInit } from '@angular/core';
import {Car} from '../Models/Car';
import {PrimeCar} from '../Models/PrimeCar.model';
import {CarService} from '../Services/car.service';


@Component({
  selector: 'app-datatable',
  providers: [CarService],
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.css']
})
export class DatatableComponent implements OnInit {
  displayDialog: boolean;

  car: Car = new PrimeCar('', '', '', '');

  selectedCar: Car;

  newCar: boolean;

  cars: Car[];
  constructor( private carService: CarService) { }

  ngOnInit() {
    this.carService.getCarsSmall().subscribe(cars => this.cars = cars);
  }

  showDialogToAdd() {
    this.newCar = true;
    this.car = new PrimeCar('', '', '', '');
    this.displayDialog = true;
  }

  save() {
    const cars = [...this.cars];
    if (this.newCar) {
      cars.push(this.car);
    }else {
      cars[this.findSelectedCarIndex()] = this.car;
    }
    this.cars = cars;
    this.car = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.findSelectedCarIndex();
    this.cars = this.cars.filter((val, i) => i !== index);
    this.car = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newCar = false;
    this.car = this.cloneCar(event.data);
    this.displayDialog = true;
  }

  cloneCar(c: Car): Car {
    const car = new PrimeCar('', '', '', '');
    for (const prop in c) {
      if (prop !== undefined) {
        car[prop] = c[prop];
      }
    }
    return car;
  }

  findSelectedCarIndex(): number {
    return this.cars.indexOf(this.selectedCar);
  }

}
