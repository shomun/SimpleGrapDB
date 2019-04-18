package com.monirul.simpledb.core


trait EdgeStore {
  var edges:Set[Edge] = Set[Edge]()

  def addEdge(edge: Edge) ={
    edges += edge
  }

  def removeEdge(edge: Edge) ={
    edges -= edge
  }



}
