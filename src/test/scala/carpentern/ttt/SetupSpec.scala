import org.scalatest.FunSpec
import org.scalatest.Matchers._
import scala.collection.immutable.HashMap
import carpentern.ttt.HumanMoveGenerator
import carpentern.ttt.PlayerBuilder
import carpentern.ttt.Setup

class SetupSpec extends UnitSpec {
  val playerBuilder = new MockTTTPlayerBuilder()
  val setup = new Setup(playerBuilder)
  val boardSize = 9

  describe("#createGameBoard") {
    it("should create a list with the board size number of elements as") {
      assert(setup.createGameBoard(boardSize).length == boardSize)
    }

    it("should only contain blanks") {
      val gameBoard = setup.createGameBoard(boardSize)
      assert(gameBoard.distinct.length == 1)
      assert(gameBoard(0) == "")
    }
  }

  describe("#createPlayers") {
    it("should call payerBuilder's buildPlayer method") {
      val name = "Player 1"
      val marker = "X"
      val view = new MockConsoleView()
      val generator = new HumanMoveGenerator(view)
      val player = setup.createPlayer(name, marker, generator)

      assert(playerBuilder.buildPlayerCalled == true)
    }
  }
}