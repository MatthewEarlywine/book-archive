import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";






export const matchpassword: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {

    let password = control.get('password');
    let username = control.get('username');
    if (password.length() || username.length() < 8){
        return{
            passwordMatchError: true
        }
    }

    return null;
}