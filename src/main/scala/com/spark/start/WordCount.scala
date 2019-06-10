package com.spark.start

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Hello world!
 *
 */
object WordCount extends App {

  val config = new SparkConf().setMaster("local").setAppName("wordcount")
  val sc = new SparkContext(config)
  var rdd = sc.textFile("a.txt")
  rdd.foreach(println)
  println( "Hello World!" )
  sc.stop()
}
