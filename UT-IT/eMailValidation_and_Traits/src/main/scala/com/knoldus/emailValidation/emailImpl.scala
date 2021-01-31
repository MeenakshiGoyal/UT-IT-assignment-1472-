package com.knoldus.emailValidation

class emailImpl {
  def isValid(email:String):Boolean = {
    """^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.)+[com|net|org]""".r.unapplySeq(email).isDefined
  }

}
