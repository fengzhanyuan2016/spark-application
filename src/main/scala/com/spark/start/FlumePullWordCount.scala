package com.spark.start

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.flume.FlumeUtils

object FlumePullWordCount extends App {
  val conf = new SparkConf().setAppName("FlumePullWordCount").setMaster("local[2]")
  val ssc = new StreamingContext(conf,Seconds(5))
  val flumeStream = FlumeUtils.createPollingStream(ssc,"master",55550)
  val result = flumeStream.map(x=>new String(x.event.getBody.array()).trim).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  result.print()
  ssc.start()
  ssc.awaitTermination()
}
