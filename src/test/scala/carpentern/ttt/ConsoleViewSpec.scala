import org.scalatest.FunSpec
import carpentern.ttt.ConsoleView

class ConsoleViewSpec extends UnitSpec {
  describe("#getPlayerMove") {
    it("returns a valid move") {
      val mockIO = new MockConsoleIO()
      val view = new ConsoleView(mockIO)
      val tempBoard = List("", "", "", "", "", "", "", "", "")
      mockIO.stubUserInput("0")
      assert(view.getPlayerMove(tempBoard) == "0")
      assert(mockIO.getUserInputCalled == true)
    }
  }
}