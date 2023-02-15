import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";






export const matchpassword: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {

    let password = control.get('password');
    let username = control.get('username');
    if ((password?.value.length() || username?.value.length()) < 8){
        return{
            passwordMatchError: true
        }
    }

    return null;
}