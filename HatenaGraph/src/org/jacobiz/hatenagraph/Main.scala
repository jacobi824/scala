/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jacobiz.hatenagraph

import java.util.Date

object Main {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    HatenaGraph.post("", "", "", new Date, "")
  }

}
