package carpentern.ttt.game

trait IO {
  def getUserInput() : String
  def display(output:String)
  def clear()
}