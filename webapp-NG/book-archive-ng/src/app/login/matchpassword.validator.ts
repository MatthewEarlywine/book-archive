import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export const matchpassword: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {

    let password = control.get('password');
    let username = control.get('username');
    if (password?.value < 8 || username?.value < 8 || password?.value?.includes(" ") || username?.value?.includes(" ")){
        return{
            passwordMatchError: true
        }
    }

    return null;
}