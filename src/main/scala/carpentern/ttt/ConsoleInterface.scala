package carpentern.ttt

class ConsoleInterface extends UserInterface {
  def getUserInput() : String = {
    scala.io.StdIn.readLine()
  }

  def display(output:String) = {
    print(output)
  }
}