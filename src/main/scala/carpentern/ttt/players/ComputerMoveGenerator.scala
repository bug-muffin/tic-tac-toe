package carpentern.ttt.players

import scala.util.control.Breaks.{break, breakable}
import carpentern.ttt.boards.Board
import carpentern.ttt.game.GameRules
import carpentern.ttt.game.MoveGenerator

class ComputerMoveGenerator(
    markers: List[String], 
    board: Board, 
    rules: GameRules) 
  extends MoveGenerator {

  private val currentMarker = markers(0)
  private val opponentMarker = markers(1)
  private val depth = 0
  private val baseDepth = 1000
  private val maxDepth = 7
  private var bestMove = -1

  def selectSpace(gameBoard: List[String]): String = {
    negamax(gameBoard, currentMarker, opponentMarker, depth)
    (bestMove + 1).toString
  }

  private def negamax(gameBoard: List[String], 
                      currentMarker: String, 
                      opponentMarker: String, 
                      depth: Int, 
                      alpha: Double = Double.NegativeInfinity, 
                      beta: Double = Double.PositiveInfinity): Double = {
    if (isTerminalNode(gameBoard, depth))
      analyzeScore(gameBoard, currentMarker, opponentMarker, depth)
    else
      evaluateBoard(gameBoard, currentMarker, opponentMarker, depth, alpha, beta)
  }

  private def evaluateBoard(gameBoard: List[String], 
                            currentMarker: String, 
                            opponentMarker: String, 
                            depth: Int, 
                            alpha: Double, 
                            beta: Double) = {
    var maxScore: Double = Double.NegativeInfinity
    var newAlpha: Double = alpha
    val openSpaces: List[Int] = board.findOpenSpaces(gameBoard)

    breakable {
      for (space <- openSpaces) {
        val tempBoard: List[String] = board.placePiece(gameBoard, space + 1, currentMarker)
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

  private def isTerminalNode(gameBoard: List[String], depth: Int) =
    rules.isGameOver(board, gameBoard) || depth >= maxDepth

  private def analyzeScore(gameBoard: List[String], currentMarker: String, opponentMarker: String, depth: Int): Int = {
    if (rules.isWinningConditionMet(board, gameBoard)) {
      val winner: String = rules.findWinningMarker(board, gameBoard)
      if (winner == currentMarker) 
        baseDepth - depth 
      else 
        depth - baseDepth
    } else {
      return 0
    }
  }
}