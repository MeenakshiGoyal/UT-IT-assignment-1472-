package com.knoldus.Test_emailValidation

import com.knoldus.emailValidation.{emailImpl, main_EmailLogin}
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec



class emailvalidationtest extends AsyncFlatSpec{
  val Mocked : emailImpl = mock(classOf[emailImpl])
  val emailId = new main_EmailLogin(Mocked)

  // unit test cases for email validation
"Email " should "be Valid" in {
  when(Mocked.isValid(email = "meenakshi@gmail.com"))thenReturn true
  val result = emailId.get_email(email = "meenakshi@gmail.com")
  assert(result == "Success")
}
"Email without @ " should "be invalid" in {
  when(Mocked.isValid(email = "meenakshigmail.com"))thenReturn false
  val result = emailId.get_email(email = "meenakshigmail.com")
  assert(result == "Failed")
}
  "Email starting with wrong Recipient name " should "be invalid" in {
    when(Mocked.isValid(email = "mee!!nakshi@gmail.com"))thenReturn false
    val result = emailId.get_email(email = "mee!!nakshi@gmail.com")
    assert(result == "Failed")
  }
  "Email with wrong top-level Domain name" should "be invalid" in {
    when(Mocked.isValid(email = "meenakshi@gmail.mon"))thenReturn false
    val result = emailId.get_email(email = "$!!meenakshi@gmail.mon")
    assert(result == "Failed")
      }
  "Email with wrong  Domain name" should "be invalid" in {
    when(Mocked.isValid(email = "meenakshi@#gmail.com")) thenReturn false
    val result = emailId.get_email(email = "meenakshi@#gmail.com")
    assert(result == "Failed")
  }


}
