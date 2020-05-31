package lab

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object main_lab
{
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("main_lab").setMaster("local[*]")
    val sc = new SparkContext(conf);
    val spark = SparkSession.builder.appName("Test app").getOrCreate()
    val datafile = spark.read
      .format("com.databricks.spark.csv")
      .option("header",true)
      .load("./avocado_prices.csv")//.load("c:/Projects/school/Java/Lab10/netflix_titles.csv")
    //datafile.show()
    datafile.createOrReplaceTempView("avocado")

    //средняя цена за год
    spark.sql("SELECT year, AVG(AveragePrice) FROM avocado GROUP BY year").show()

    //всего продано в регионе
    spark.sql("SELECT region, SUM(`Total Volume`) FROM avocado GROUP BY region ORDER BY region").show()

    spark.stop()
  }
}