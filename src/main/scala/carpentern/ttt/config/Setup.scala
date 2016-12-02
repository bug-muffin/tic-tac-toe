package carpentern.ttt.config

import scala.collection.mutable.ListBuffer
import carpentern.ttt.boards.Board
import carpentern.ttt.game.View
import carpentern.ttt.game.PlayerBuilder
import carpentern.ttt.players.Player

class Setup(playerBuilder: PlayerBuilder, board: Board, view: View) {
  def setupBoard: List[String] = {
    view.clearScreen

    val prompt: String = "Do you want to play with a 3x3 board or a 4x4 board?\n"
    val options: List[String] = List("1 - 3x3\n", "2 - 4x4\n")
    view.promptOrderedOptions(prompt, options)
    createBoard(view.getOrderedOptionsSelection(options))
  }

  def setupPlayers(markers: List[String]): List[Player] = {
    val playMode: String = selectPlayMode
    createPlayers(playMode, markers)
  }

  private def createBoard(selection: String): List[String] =
    if (selection == "1") board.createGameBoard(9) else board.createGameBoard(16)

  private def selectPlayMode: String = {
    val prompt: String = "\nPlease select your mode of play:\n"
    val options: List[String] = List("1 - Player vs Player\n", "2 - Player vs Computer\n")
    view.promptOrderedOptions(prompt, options)
    view.getOrderedOptionsSelection(options)
  }

  private def createPlayers(playMode: String, markers: List[String]): List[Player] = {
    val players = new ListBuffer[Player]()
    val playerNames: List[String] = assignPlayerNames(playMode)
    val playerMarkers: List[String] = assignPlayerMarkers(playerNames, markers)
    val playAttributeSets: List[(String,String)] = pairNamesAndMarkers(playerNames, playerMarkers)
    for (attributeSet <- playAttributeSets) {
      val player = playerBuilder.buildPlayer(attributeSet._1, attributeSet._2)
      players += player
    }
    players.toList
  }

  private def assignPlayerNames(playMode: String): List[String] = {
    val playerNames = new ListBuffer[String]()
    playerNames += view.getPlayerName("First")
    if (playMode == "1") playerNames += view.getPlayerName("Second") else playerNames += "Computer"
    playerNames.toList
  }

  private def assignPlayerMarkers(players: List[String], markers: List[String]): List[String] = {
    val selection: String = getPlayerMarkerSelection(players, markers)
    assignPlayerMarkersBySelection(selection, markers)
  }

  private def getPlayerMarkerSelection(players:List[String], markers: List[String]): String = {
    val prompt: String = s"\n${players(0)}, do you want to play with ${markers(0)} or ${markers(1)}?\n"
    val options: List[String] = List(s"1 - ${markers(0)}\n", s"2 - ${markers(1)}\n")
    view.promptOrderedOptions(prompt, options)
    view.getOrderedOptionsSelection(options)
  }

  private def assignPlayerMarkersBySelection(selection: String, markers: List[String]): List[String] =
    if (selection == "1") markers else reverse(markers)

  private def pairNamesAndMarkers(playerNames: List[String], playerMarkers: List[String]): List[(String,String)] =
    playerNames.zip(playerMarkers)

  private def reverse[A](ls: List[A]) = ls.reverse
}