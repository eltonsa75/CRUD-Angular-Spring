import { CoursesService } from './../services/courses.service';
import { Course } from './../model/course';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  courses: Course[] = [];

  //coursesService : CoursesService;

  displayedColumns = [ 'name', 'category'];

  constructor(private coursesService: CoursesService ) {
    // this.courses = [];
    //this.coursesService = new CoursesService();
    this.courses = this.coursesService.list();
  }

  ngOnInit(): void {
  }

}
