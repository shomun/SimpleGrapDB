package com.monirul.simpledb.core

class GraphStore extends VertexStore with EdgeStore {


  def findAllByRelation(relation:String) ={
    edges.filter(e=> e.label == relation ).map(e=>e.sourceVertex)
  }

  def findAllByRelationAndCondition(relation:String, conds:Map[String,String]) ={
    edges.filter(e=> e.label == relation ).filter(e=>findMatch(e.targetVertex.attr,conds))
      .map(e=>e.sourceVertex)
  }

  private def findMatch(attr:Map[String,String],conds:Map[String,String]) ={
    (conds.keySet collect(attr)).toList == conds.values.toList
  }
}
