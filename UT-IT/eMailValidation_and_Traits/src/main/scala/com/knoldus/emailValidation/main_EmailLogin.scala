package com.knoldus.emailValidation

class main_EmailLogin(validation: emailImpl) {

  val validEmail = "Success"
  val invalidEmail = "Failed"
  def get_email(email:String):String = {
    if(validation.isValid(email)){
      println("Email Id is Valid")
      validEmail
    }else{
      println("Email Id is Invalid")
      invalidEmail
    }
  }
}
