package com.monirul.simpledb.core



trait ElementStore[T <: Element] {
  var elements:Set[T] = Set[T]()

  protected def addElement(element: T) ={
    elements += element
  }

  protected def removeElement(element: T) ={
    elements -= element
  }

//  def findByType(label:String):Set[T] = {
  //    elements filter (e=> e.eleLabel == label)
  //
  //  }


}
