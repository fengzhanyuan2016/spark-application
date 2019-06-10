package com.spark.start

object FunctionApp extends App {
  //匿名函数
  val f = (x:Int)=>x
  def add = (x:Int,y:Int)=>x+y


  //柯理化函数
  def sum(a:Int,b:Int)= a+b
  println(sum(1,2))

  def sum2(a:Int)(b:Int)= a+b
  println(sum2(2)(3))






}
