package carpentern.ttt.players

import scala.util.control.Breaks.{break, breakable}
import carpentern.ttt.boards.Board
import carpentern.ttt.game.GameRules
import carpentern.ttt.game.MoveGenerator

class ComputerMoveGenerator(markers: List[String], rules: GameRules) extends MoveGenerator {
  private val currentMarker = markers(0)
  private val opponentMarker = markers(1)
  private val depth = 0
  private val baseDepth = 1000
  private val maxDepth = 7
  private var bestMove = -1

  def selectSpace(board: Board): String = {
    negamax(board, currentMarker, opponentMarker, depth)
    (bestMove + 1).toString
  }

  private def negamax(board: Board,
                      currentMarker: String,
                      opponentMarker: String,
                      depth: Int,
                      alpha: Double = Double.NegativeInfinity,
                      beta: Double = Double.PositiveInfinity): Double = {
    if (isTerminalNode(board, depth))
      analyzeScore(board, currentMarker, opponentMarker, depth)
    else
      evaluateBoard(board, currentMarker, opponentMarker, depth, alpha, beta)
  }

  private def evaluateBoard(board: Board,
                            currentMarker: String,
                            opponentMarker: String,
                            depth: Int,
                            alpha: Double,
                            beta: Double) = {
    var maxScore: Double = Double.NegativeInfinity
    var newAlpha: Double = alpha
    val openSpaces: List[Int] = board.findOpenSpaces

    breakable {
      for (space <- openSpaces) {
        val tempBoard: Board = board.placePiece(space + 1, currentMarker)
        val score: Double = -negamax(tempBoard, opponentMarker, currentMarker, depth + 1, -beta, -newAlpha)

        if (score > maxScore) {
          maxScore = score
          if (depth == 0) {
            bestMove = space
          }
        }

        newAlpha = Math.max(maxScore, newAlpha)

        if (newAlpha >= beta) {
          break
        }
      }
    }
    newAlpha
  }

  private def isTerminalNode(board: Board, depth: Int) =
    rules.isGameOver(board) || depth >= maxDepth

  private def analyzeScore(board: Board, currentMarker: String, opponentMarker: String, depth: Int): Int = {
    if (rules.isWinningConditionMet(board)) {
      val winner: String = rules.findWinningMarker(board)
      if (winner == currentMarker)
        baseDepth - depth
      else
        depth - baseDepth
    } else {
      return 0
    }
  }
}
