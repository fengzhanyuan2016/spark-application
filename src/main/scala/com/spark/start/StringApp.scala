package com.spark.start

object StringApp extends App {

  //String Template
  val s = "hello px"
  val name = "iven"
  println(s"hello $name")

  val b =
    """
      |zuohangzifuchuang
      |fengzhanyuan
      |hello
      |pk
      |world
    """.stripMargin
  println(b)
}
