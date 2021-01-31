package com.knoldus.Unit_Testing

import com.knoldus.Impl.EmailImpl
import com.knoldus.validator.EmailValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestEmailValidator extends AsyncFlatSpec {
  val MockedEmailValidator: EmailValidator = mock[EmailValidator]
  val EmailId = new EmailImpl(MockedEmailValidator)

  // Unit Test Cases for Email Validation

  "Email Id " should "be Valid" in {
    when(MockedEmailValidator.emailIdIsValid("meenakshi@gmail.net")) thenReturn true
    val result = EmailId.getEmailId("meenakshi@gmail.net")
    assert(result == "yes")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("!!@meenakshi@gmail.com")) thenReturn false
    val result = EmailId.getEmailId("!!meenakshi@gmail.com")
    assert(result == "no")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("meenakshigmail.com")) thenReturn false
    val result = EmailId.getEmailId("meenakshigmail.com")
    assert(result == "no")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("meenakshi@!gmail.com")) thenReturn false
    val result1 = EmailId.getEmailId("meenakshi@!gmail.com")
    assert(result1 == "no")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidator.emailIdIsValid("meenakshi@gmail.ccom")) thenReturn false
    val result1 = EmailId.getEmailId("meenakshi@gmail.ccom")
    assert(result1 == "no")
  }

}
