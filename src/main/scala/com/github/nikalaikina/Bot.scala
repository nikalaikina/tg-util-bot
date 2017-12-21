package com.github.nikalaikina

import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.api.{ChatActions, Polling, TelegramBot}
import info.mukel.telegrambot4s.methods.SendMessage
import info.mukel.telegrambot4s.models.Message


class Bot extends AbstractBot {

  import info.mukel.telegrambot4s.models.ChatId._

  val fs: Map[String, String => String] = Map(
    "1" -> (_.mkString(" ")),
    "2" -> (s => (s.mkString(" ") :: s.tail.map(_.toString).toList).mkString("\n"))
  )

  run()

  override def receiveMessage(msg: Message): Unit = {
    val (word :: mod :: _) = msg.text.getOrElse("").split(" ").toList
    val resp = fs(mod)(word)
    request(SendMessage(msg.chat.id, resp))
  }

}

import scala.io.Source

trait AbstractBot extends TelegramBot with Polling with ChatActions with Commands {
  def token: String = Source.fromFile("bot.token").getLines().next
}
