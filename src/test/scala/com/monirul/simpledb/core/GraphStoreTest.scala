package com.monirul.simpledb.core

import org.scalatest.FunSuite

import scala.collection.mutable

class GraphStoreTest extends FunSuite {
  test("should add vertex person"){

    val attr:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")

    var vertex = new Vertex("Person",attr)

    var sut:GraphStore = new GraphStore

    sut.addVertex(vertex)

    assert(sut.vertexes.contains(vertex))

  }

  test("find all persons"){

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")

    val attrBusiness:Map[String,String] = Map[String,String]("name"->"New Business","location"->"Sydney")

    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)

    var business = new Vertex("Business",attrBusiness)

    var sut:GraphStore = new GraphStore

    sut.addVertex(person1)
    sut.addVertex(person2)
    sut.addVertex(business)

    assert(sut.vertexes.contains(person1))
    assert(sut.vertexes.contains(person2))
    assert(sut.vertexes.contains(business))


    val result:Set[Vertex]= sut.findByType("Person")

    assert(result.size == 2)


  }


  test("add relation to persons"){

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")

    val attrBusiness:Map[String,String] = Map[String,String]("name"->"New Business","location"->"Sydney")

    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)

    val friendOf:Edge = new Edge(person1,person2,"friendOf")

    var business = new Vertex("Business",attrBusiness)

    var sut:GraphStore = new GraphStore

    sut.addVertex(person1)
    sut.addVertex(person2)
    sut.addEdge(friendOf)

    assert(sut.vertexes.contains(person1))
    assert(sut.vertexes.contains(person2))
//    assert(sut.vertexes.contains(business))


    val result:Set[Vertex]= sut.findByType("Person")

    assert(result.size == 2)


  }


  test("find all employed persons"){

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")

    val attrBusiness:Map[String,String] = Map[String,String]("name"->"New Business","location"->"Sydney")

    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)



    var business = new Vertex("Business",attrBusiness)

    val employedBy:Edge = new Edge(person1,business,"employedBy")

    var sut:GraphStore = new GraphStore

    sut.addVertex(person1)
    sut.addVertex(person2)
    sut.addEdge(employedBy)

    assert(sut.vertexes.contains(person1))

    //    assert(sut.vertexes.contains(business))


    val result:Set[Vertex]= sut.findAllByRelation("employedBy")

    assert(result.size == 1)
    assert(result.contains(person1))

  }


  test("find all persons employed at sydney"){



    val attrBusinessSydney:Map[String,String] = Map[String,String]("name"->"New Business","location"->"Sydney")
    val attrBusinessMelborne:Map[String,String] = Map[String,String]("name"->"New Business","location"->"Melborne")

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")
    val attrPerson3:Map[String,String] = Map[String,String]("name"->"Thomas","age"->"21")
    val attrPerson4:Map[String,String] = Map[String,String]("name"->"Albert","age"->"44")
    val attrPerson5:Map[String,String] = Map[String,String]("name"->"Linus","age"->"39")



    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)
    var person3 = new Vertex("Person",attrPerson3)
    var person4 = new Vertex("Person",attrPerson4)
    var person5 = new Vertex("Person",attrPerson5)


    var businessSydney = new Vertex("Business",attrBusinessSydney)
    var businessMelborne = new Vertex("Business",attrBusinessMelborne)

    val employedBy1:Edge = new Edge(person1,businessSydney,"employedBy")
    val employedBy2:Edge = new Edge(person2,businessMelborne,"employedBy")
    val employedBy3:Edge = new Edge(person3,businessSydney,"employedBy")
    val employedBy4:Edge = new Edge(person4,businessMelborne,"employedBy")

    var sut:GraphStore = new GraphStore

    sut.addVertex(person1)
    sut.addVertex(person2)
    sut.addEdge(employedBy1)
    sut.addEdge(employedBy2)
    sut.addEdge(employedBy3)
    sut.addEdge(employedBy4)


    assert(sut.vertexes.contains(person1))

    //    assert(sut.vertexes.contains(business))
    val condSydney:Map[String,String] = Map[String,String]("location"->"Sydney")

    val result:Set[Vertex]= sut.findAllByRelationAndCondition("employedBy",condSydney)

    assert(result.size == 2)
    assert(result.contains(person1))
    assert(result.contains(person2))

  }


  test("should add vertex edge to graph"){

//    val attr:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")


    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)

    var edge = new Edge(person1,person2,"friendOf")

    var sut:GraphStore = new GraphStore

    sut.addEdge(edge  )

    assert(sut.edges.contains(edge))

  }

  test("should find all friends of a person"){

    //    val attr:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")

    val attrPerson1:Map[String,String] = Map[String,String]("name"->"Monirul","age"->"99")
    val attrPerson2:Map[String,String] = Map[String,String]("name"->"John","age"->"89")
    val attrPerson3:Map[String,String] = Map[String,String]("name"->"Thomas","age"->"89")
    val attrPerson4:Map[String,String] = Map[String,String]("name"->"Albert","age"->"89")
    val attrPerson5:Map[String,String] = Map[String,String]("name"->"Linus","age"->"89")



    var person1 = new Vertex("Person",attrPerson1)
    var person2 = new Vertex("Person",attrPerson2)
    var person3 = new Vertex("Person",attrPerson3)
    var person4 = new Vertex("Person",attrPerson4)
    var person5 = new Vertex("Person",attrPerson5)

    var edge = new Edge(person2,person1,"friendOf")
    var edge2 = new Edge(person4,person1,"friendOf")

    var edge3 = new Edge(person4,person3,"friendOf")

    var edge4 = new Edge(person2,person3,"friendOf")

    var sut:GraphStore = new GraphStore

    sut.addEdge(edge  )
    sut.addEdge(edge2  )
    sut.addEdge(edge3  )
    sut.addEdge(edge4  )

    assert(sut.edges.contains(edge))
    val conds:Map[String,String] = Map[String,String]("name"->"Monirul")
    val result:Set[Vertex] = sut.findAllByRelationAndCondition("friendOf",conds)

    assert(result.size == 2)
    assert(result.contains(person2))
    assert(result.contains(person4))

  }


}
