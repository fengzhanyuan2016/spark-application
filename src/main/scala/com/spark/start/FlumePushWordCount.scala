package com.spark.start

import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/*
SparkStreaming 整合 Flume的第一种方式
 */
object FlumePushWordCount extends App {
  val conf = new SparkConf().setAppName("FlumePushWordCount").setMaster("local[2]")
  val ssc = new StreamingContext(conf,Seconds(5))
  val flumeStream = FlumeUtils.createStream(ssc,"master",55555)
  val result = flumeStream.map(x=>new String(x.event.getBody.array()).trim).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
  result.print()
  ssc.start()
  ssc.awaitTermination()
}
