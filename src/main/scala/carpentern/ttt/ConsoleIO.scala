package carpentern.ttt

class ConsoleIO extends IO {
  def getUserInput() : String = {
    scala.io.StdIn.readLine()
  }

  def display(output:String) = {
    print(output)
  }
}