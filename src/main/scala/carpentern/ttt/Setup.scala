package carpentern.ttt

class Setup(playerBuilder: PlayerBuilder) {
  def createPlayer(name:String, marker:String, generator:MoveGenerator) : Player = {
    playerBuilder.buildPlayer(name, marker, generator)
  }
}
