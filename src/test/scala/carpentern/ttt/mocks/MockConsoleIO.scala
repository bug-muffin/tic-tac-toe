import carpentern.ttt.IO

class MockConsoleIO extends IO {
  var getUserInputCalled: Boolean = false
  var displayCalled: Boolean = false
  var displayCalledWith: String = ""
  var stubbedUserInput: String = ""

  def getUserInput() : String = {
    getUserInputCalled = true
    stubbedUserInput
  }

  def display(output:String) = {
    displayCalledWith = output
    displayCalled = true
  }

  def stubUserInput(inputToStub:String) = {
    stubbedUserInput = inputToStub
  }
}