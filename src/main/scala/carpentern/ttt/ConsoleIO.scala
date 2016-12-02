package carpentern.ttt

class ConsoleIO extends IO {
  def getUserInput() : String = {
    readLine()
  }

  def display(output:String) = {
    print(output)
  }

  def clear() = {
    print("\033[2J")
    print("\033[;H")
  }
}