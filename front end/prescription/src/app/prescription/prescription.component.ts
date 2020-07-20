import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormArray } from '@angular/forms';
import { PrescriptionService } from '../services/prescription.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit {

  prescriptionForm: FormGroup;
  submitted = false;
  emailId = localStorage.getItem('username');

  constructor(private formBuilder: FormBuilder,
    private prescriptionService: PrescriptionService,
    private router: Router) { }

  ngOnInit(): void {
    this.prescriptionForm = this.formBuilder.group({
      patient: this.formBuilder.group({
        patientFirstName: ['', Validators.required],
        patientLame: ['', Validators.required],
        gender: ['', Validators.required],
        age: ['', Validators.required],
      }),
      medicine: this.formBuilder.array([])
    });
  }

  get f(){ 
    return this.prescriptionForm.controls; 
  }

  medicine(): FormArray{
    return this.prescriptionForm.get("medicine") as FormArray;
  }

  newMedicine(): FormGroup{
    return this.formBuilder.group({
      medicineName: ['', Validators.required],
      medicineType: ['', Validators.required],
      quantity: ['', Validators.required],
      noOfTimesADay: ['', Validators.required],
      durationOfCourse: ['', Validators.required],
    })
  }

  addMedicine() {
    this.medicine().push(this.newMedicine());
  }

  removeMedicine(i: number){
    this.medicine().removeAt(i);
  }

  onSubmit(){
    this.submitted = true;

    if(this.prescriptionForm.invalid){
      return;
    }
    this.prescriptionService.submitPrescription(this.emailId, this.prescriptionForm.value)
      .subscribe(form => {
        console.log("submitted");
        this.router.navigate(["/"]);
      });
    console.log(this.prescriptionForm.value);
  }

  onReset(){
    this.submitted = false;
    this.prescriptionForm.reset();
  }
}
