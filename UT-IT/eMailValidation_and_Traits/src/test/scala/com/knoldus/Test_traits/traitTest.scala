package com.knoldus.Test_traits

import com.knoldus.Traits.{Traits_impl, main_traits}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

import scala.collection.mutable.ListBuffer

class traitTest extends AsyncFlatSpec{
  val mock_traits : main_traits = mock[main_traits]
  val traits = new Traits_impl()
// Unit testcase for divide
  "Divide" should "be valid when numerator is greater than denominator" in {
    when (mock_traits.Divide(20,2)) thenReturn 10
    val result = traits.getDivide(20,2)
    assert(result == 10)
  }
  "Divide" should "be invalid when numerator is smaller than denominator" in {
    when (mock_traits.Divide(2,20)) thenReturn 0
    val result = traits.getDivide(2,20)
    assert(result == 0)
  }
  // Unit testcase for fibonacci series

  "Fibonacci series  [0 1 1]" should "valid" in{
    when(mock_traits.fibonacci(3))thenReturn(ListBuffer[Int](0 ,1 ,1))
    val result = traits.getfibonacci(3)
    assert(result == ListBuffer[Int](0 ,1 ,1))
  }
  "Fibonacci series  [0 1 1 3 ]" should "invalid" in{
    when(mock_traits.fibonacci(4))thenReturn(ListBuffer[Int](0 ,1 ,1,2))
    val result = traits.getfibonacci(4)
    assert(result != ListBuffer[Int](0 ,1 ,1,3))

  }
}