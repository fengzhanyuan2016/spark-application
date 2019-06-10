package com.spark.start

object ProFunction extends App {
  val l = List(1, 2, 3, 4, 5, 6, 7, 8)
  l.map((x: Int) => x + 1)
  l.map((x: Int) => x * 2)
  println(l)
  l.map(x => x * 2)
  l.map(_ * 2)
  l.foreach(println)

  l.filter(x => x > 4)
  l.filter(_ > 4)

  l.take(2)


  println(l.reduce(_ + _))
  println(l.reduceRight(_ - _))
  println(l.reduceLeft(_ - _))







}
