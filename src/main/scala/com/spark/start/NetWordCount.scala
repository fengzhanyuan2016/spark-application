package com.spark.start

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object NetWordCount extends App {
  val conf = new SparkConf().setAppName("NetWordCount").setMaster("local[2]")
  val ssc = new StreamingContext(conf,Seconds(5))
  val lines = ssc.socketTextStream("master",6798)
  val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  result.print()
  ssc.start()
  ssc.awaitTermination()
}