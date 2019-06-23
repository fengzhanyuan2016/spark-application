package com.spark.start

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf

/**
 * Hello world!
 */
object WordCount extends App {
  val config = new SparkConf().setMaster("local[2]").setAppName("wordcount")
  val ssc = new StreamingContext(config,Seconds(5))
  var lines = ssc.textFileStream("file:///home/iven/Downloads/ss/")
  val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  result.print()
  ssc.start()
  ssc.awaitTermination()
}
