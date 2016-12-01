package carpentern.ttt

trait IO {
  def getUserInput() : String
  def display(output:String)
  def clear()
}