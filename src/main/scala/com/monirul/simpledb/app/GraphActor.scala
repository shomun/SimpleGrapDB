package com.monirul.simpledb.app

import akka.actor.{Actor, ActorLogging}
import com.monirul.simpledb.app.GraphOperation._
import com.monirul.simpledb.core.GraphStore

class GraphActor(graphStore: GraphStore) extends Actor with ActorLogging{

  private implicit val _ = context.dispatcher

  override def receive: Receive = {
    case AddVertex(vertex) =>
        graphStore.addVertex(vertex)
    case AddEdge(edge) =>
        graphStore.addEdge(edge)
    case FindByType(label) =>
      graphStore.findByType(label)
    case FindByRelation(relation) =>
        graphStore.findAllByRelation(relation)
    case FindByRelationAndCondition(relation,conds) =>
      graphStore.findAllByRelationAndCondition(relation,conds)
  }
}
