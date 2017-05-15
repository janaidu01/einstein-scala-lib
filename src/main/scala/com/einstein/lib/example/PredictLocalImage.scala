package com.einstein.lib.example

import com.einstein.lib.service.{VisionService, Probabilities}
import com.einstein.lib.Constants

/**
  * Created by Rajdeep Dua on 9/5/17.
  */
object PredictLocalImage {
  def main(args: Array[String]) = {
    val url = "http://metamind.io/images/foodimage.jpg"
    val localFilePath = "/home/ubuntu/Downloads/samosa.jpeg"
    val modelId = "FoodImageClassifier"
    val accessToken = Constants.ACCESS_TOKEN
    val list = VisionService.predictLocalImage(localFilePath, modelId, accessToken)
    val itr = list.iterator()
    println( "Label : Probability")
    while(itr.hasNext){
      val probabilities =  itr.next().asInstanceOf[Probabilities]
      val label = probabilities.getLabel
      val probability = probabilities.getProbability
      println(label + " : " + probability)
    }
  }

}