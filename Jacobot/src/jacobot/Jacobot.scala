/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jacobot

import java.util.Date
import org.jibble.pircbot.PircBot

object Jacobot {

  def main(args: Array[String]): Unit = {

    val bot = new Jacobot
    bot.setVerbose(true)

    bot.setEncoding(Conf.ServerEnc)
    bot.connect(Conf.ServerName)
    bot.joinChannel("#jacotest")
  }

}

class Jacobot extends PircBot{
  this.setName(Conf.BotName)
  this.setVersion(Conf.BotVersion)
  this.setFinger(Conf.BotFinger)
  this.setLogin(Conf.BotLogin)

  override def onMessage(channel: String, sender: String, login: String, hostname: String, message: String) {
    message match {
      case "おはよう" => sendNotice(channel, "おはよう" + sender)
      case "今何時？" => sendNotice(channel, new Date().toString)
      case "さようなら" => quitServer
      case "わけあり" => quitServer("サラダバー")
    }

  }
}
