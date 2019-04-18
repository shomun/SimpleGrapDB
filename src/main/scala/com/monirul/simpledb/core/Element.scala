package com.monirul.simpledb.core

import java.util.UUID.randomUUID

abstract class Element(label:String,attr:Map[String,String]) {

//  val eleLabel = label
  val id = randomUUID().hashCode()


}
