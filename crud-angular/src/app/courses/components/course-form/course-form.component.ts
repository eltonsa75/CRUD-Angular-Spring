import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { CoursesService } from '../../services/courses.service';
import { Course } from '../../model/course';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form = this.formBuilder.group({
    name: [' '],
    category: [' '],
  });


  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute ) {
      // this.form
     }

  ngOnInit(): void {
   const course: Course = this.route.snapshot.data['course'];
   console.log(course);
}

onSubmit() {
  this.service.save(this.form.value)
  .subscribe(result => this.onSuccess(), error => this.onError());
}


onCancel() {
  this.location.back();
}

private onSuccess() {
  this.snackBar.open('Curso Salvo com Sucesso!', '', {duration: 5000});
  this.location.back();
}
private onError() {
  this.snackBar.open('Erro ao salvar curso.', '', {duration: 5000});
}

}
