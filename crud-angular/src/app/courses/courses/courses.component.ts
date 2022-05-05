import { CoursesService } from './../services/courses.service';
import { Course } from './../model/course';
import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses$: Observable<Course[]>;

  displayedColumns = [ 'name', 'category'];

  constructor(private coursesService: CoursesService ) {
    // this.courses = [];
    //this.coursesService = new CoursesService();

    this.courses$ = this.coursesService.list()
    .pipe(
      catchError(error => {
        return of([])
      })
    );

  }

  ngOnInit(): void {
  }

}
