package com.knoldus.Traits

import scala.collection.mutable.ListBuffer

class Traits_impl extends main_traits {

  override  def Divide(numerator: Int, denominator: Int): Int = {
    var result = numerator / denominator
    result
  }
  def getDivide(numerator:Int , denominator:Int):Int = {
    Divide(numerator, denominator)
  }
  def getfibonacci(nterms:Int):ListBuffer[Int] ={
   fibonacci(nterms)
 }
}
