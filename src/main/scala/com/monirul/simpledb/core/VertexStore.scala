package com.monirul.simpledb.core


trait VertexStore {

  var vertexes:Set[Vertex] = Set[Vertex]()

  def addVertex(vertex: Vertex) ={
    vertexes += vertex
  }

  def removeVertex(vertex: Vertex) ={
    vertexes -= vertex
  }

  def findByType(label:String):Set[Vertex] ={

    vertexes filter  ( v=> v.label == label)

  }
}
