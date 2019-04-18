package com.monirul.simpledb.core


case class Edge(sourceVertex:Vertex,targetVertex:Vertex,label:String,attr:Map[String,String] = Map())  extends Element(label,attr){

  //def this(sourceVertex:Vertex,targetVertex:Vertex,label:String) = this(sourceVertex,targetVertex,label,Map.empty)
}
