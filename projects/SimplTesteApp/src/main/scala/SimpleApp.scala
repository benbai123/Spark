/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    // Should be some file on your system
    val logFile = "/home/benbai/Things/spark/spark-1.6.0-bin-hadoop2.6/README.md"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("##\n##\n##\n##\n".format(numAs, numBs))
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println("##\n##\n##\n##\n".format(numAs, numBs))
  }
}
