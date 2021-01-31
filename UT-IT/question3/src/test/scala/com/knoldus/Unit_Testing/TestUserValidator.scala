package com.knoldus.Unit_Testing

import com.knoldus.Impl.UserImpl
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class TestUserValidator extends AsyncFlatSpec {

  val MockedCompanyValidator: UserValidator = mock[UserValidator]
  val Company = new UserImpl(MockedCompanyValidator)

  // Checks if company exists in database
  "Company " should "exist in database" in {
    when(MockedCompanyValidator.companyExists("Knoldus")) thenReturn true
    val result = Company.doCompanyExist("Knoldus")
    assert(result == "yes")
  }

  "Company " should "not exist in database" in {
    when(MockedCompanyValidator.companyExists("Microsoft")) thenReturn false
    val result = Company.doCompanyExist("Microsoft")
    assert(result=="no")
  }

  // Email Validation
  val MockedEmailValidation: UserValidator = mock[UserValidator]
  val Email = new UserImpl(MockedEmailValidation)
  "Email Id " should "be Valid" in {
    when(MockedEmailValidation.emailIdIsValid("meenakshi@gmail.net")) thenReturn true
    val result = Email.getEmailId("meenakshi@gmail.net")
    assert(result == "valid")
  }

  "Email Id with wrong Recipient name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("!!@meenakshi@gmail.com")) thenReturn false
    val result = Email.getEmailId("!!meenakshi@gmail.com")
    assert(result == "invalid")
  }

  "Email Id without @ symbol" should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("meenakshigmail.com")) thenReturn false
    val result = Email.getEmailId("meenakshigmail.com")
    assert(result == "invalid")
  }

  "Email Id with wrong Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("meenakshi@!gmail.com")) thenReturn false
    val result1 = Email.getEmailId("meenakshi@!gmail.com")
    assert(result1 == "invalid")
  }

  "Email Id with wrong Top-Level Domain name " should "be invalid" in {
    when(MockedEmailValidation.emailIdIsValid("meenakshi@gmail.ccom")) thenReturn false
    val result1 = Email.getEmailId("meenakshi@gmail.ccom")
    assert(result1 == "invalid")
  }

}
