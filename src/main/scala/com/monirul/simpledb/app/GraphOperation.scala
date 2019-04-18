package com.monirul.simpledb.app

import com.monirul.simpledb.core.{Edge, Vertex}

object GraphOperation {

  case class AddVertex(vertex:Vertex)

  case class AddEdge(edge:Edge)

  case class FindByType(label:String)

  case class FindByRelation(relation:String)

  case class FindByRelationAndCondition(relation:String,conds:Map[String,String])

}
