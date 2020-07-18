import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormArray } from '@angular/forms';


@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit {

  prescriptionForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) { }

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

    console.log(this.prescriptionForm.value);
  }

  onReset(){
    this.submitted = false;
    this.prescriptionForm.reset();
  }
}
