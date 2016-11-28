import carpentern.ttt.MoveGenerator

class MockMoveGenerator extends MoveGenerator {
  var selectSpaceCalled = false
  var stubbedSelectSpace = ""

  def selectSpace(gameBoard:List[String]) : String = {
    selectSpaceCalled = true
    stubbedSelectSpace
  }

  def stubSelectSpace(value:String) = {
    stubbedSelectSpace = value
  }
}