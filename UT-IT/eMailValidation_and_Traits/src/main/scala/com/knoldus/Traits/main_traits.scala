package com.knoldus.Traits

import scala.collection.mutable.ListBuffer

trait main_traits {

  def Divide(numerator:Int,denominator:Int): Int{

  }


  def fibonacci(nterms: Int): ListBuffer[Int] = {
    val fib_series = new ListBuffer[Int]
    fib_series += 0
    fib_series += 1
    if (nterms <= 2)  fib_series
    else {
      var first = 0
      var second = 1
      var ans = 0
      var i = nterms - 2
      while (i > 0) {
        i = i - 1
        ans = first + second
        first = second
        second = ans
        fib_series += ans
      }
      fib_series
    }
  }
}