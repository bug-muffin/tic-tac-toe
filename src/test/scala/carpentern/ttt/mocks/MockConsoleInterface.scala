import carpentern.ttt.UserInterface

class MockConsoleInterface extends UserInterface {
  var getUserInputCalled: Boolean = false
  var displayCalled: Boolean = false
  var stubbedUserInput: String = ""

  def getUserInput() : String = {
    getUserInputCalled = true
    stubbedUserInput
  }

  def display(output:String) = {
    displayCalled = true
  }

  def stubUserInput(inputToStub:String) = {
    stubbedUserInput = inputToStub
  }
}