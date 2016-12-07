package carpentern.ttt.config

sealed trait Marker

object X extends Marker {
  override def toString: String = {
    "X"
  }
}

object O extends Marker {
  override def toString: String = {
    "O"
  }
}

object EMPTY extends Marker {
  override def toString: String = {
    ""
  }
}