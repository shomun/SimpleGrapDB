package com.monirul.simpledb.app


import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.monirul.simpledb.app.GraphOperation.{AddVertex, FindByType}
import com.monirul.simpledb.core.{GraphStore, Vertex}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class GraphActorTest extends TestKit(ActorSystem("SimpleGraphDB"))
                      with ImplicitSender
                      with WordSpecLike
                      with Matchers
                      with BeforeAndAfterAll{


  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "Graph Actor   " should  {
    "add any type of  Vertex" in {
      val attr:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")

      var vertex = new Vertex("Person",attr)

      var sut = system.actorOf(Props[GraphActor])

      sut ! AddVertex(vertex)

      val result = sut ! FindByType("Person")

      assert(result == vertex)
    }
  }

}
