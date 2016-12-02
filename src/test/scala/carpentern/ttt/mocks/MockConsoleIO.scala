import carpentern.ttt.game.IO

class MockConsoleIO extends IO {
  var getUserInputCalled: Boolean = false
  var displayCalled: Boolean = false
  var displayCalledWith: String = ""
  var clearCalled = false
  var stubbedUserInput: String = ""

  def getUserInput() : String = {
    getUserInputCalled = true
    stubbedUserInput
  }

  def display(output:String) = {
    displayCalledWith = output
    displayCalled = true
  }

  def clear() = {
    clearCalled = true
  }

  def stubUserInput(inputToStub:String) = {
    stubbedUserInput = inputToStub
  }
}