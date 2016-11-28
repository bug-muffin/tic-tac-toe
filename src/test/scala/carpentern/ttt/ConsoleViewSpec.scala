import org.scalatest.FunSpec
import carpentern.ttt.ConsoleView
import carpentern.ttt.MoveValidator

class ConsoleViewSpec extends UnitSpec {
  describe("#getPlayerMove") {
    it("returns a valid move") {
      val mockIO = new MockConsoleIO()
      val validator = new MoveValidator()
      val view = new ConsoleView(mockIO, validator)
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      mockIO.stubUserInput("3")
      assert(view.getPlayerMove(tempBoard) == "3")
      assert(mockIO.getUserInputCalled == true)
    }
  }
}