import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export const bookinfo: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {

    let title = control.get('password');
    let author = control.get('username');
    if ((title?.value || author?.value) < 1){
        return{
            bookInfoError: true
        }
    }

    return null;
}