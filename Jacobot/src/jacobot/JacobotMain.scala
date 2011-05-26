/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jacobot

object JacobotMain {

  def main(args: Array[String]): Unit = {
    val bot = new Jacobot
    bot.setVerbose(true)
    bot.setEncoding("UTF-8")
    bot.connect("irc.o-in.dwango.co.jp")
    bot.joinChannel("#komitest")
  }

}
