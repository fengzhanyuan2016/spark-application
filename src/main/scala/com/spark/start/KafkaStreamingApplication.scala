package com.spark.start

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent

object KafkaStreamingApplication extends App {
  val conf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
  val ssc = new StreamingContext(conf,Seconds(5))
  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "master:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "test-consumer-group",
    "auto.offset.reset" -> "earliest",
    "enable.auto.commit" -> (false: java.lang.Boolean)
  )
  val topics = Array("streaming-topic")
  var stream = KafkaUtils.createDirectStream(ssc,PreferConsistent,Subscribe[String,String](topics,kafkaParams))
  val result = stream.map(x=>x.value)
  result.print()
  ssc.start()
  ssc.awaitTermination()
}
