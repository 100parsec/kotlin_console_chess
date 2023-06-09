package pieces

import fields.CyanField
import fields.GreyField

/*
Parent class for all pieces. Holds methods to check is there a piece on the way to target
 */
open class Pieces(var posColumn: Int, var posRow: Int, var pieceColor: String) {


    /*
    checks if there is a piece on the way to target
     */
    open fun isThereAPiece(indexFrom: Pair<Int, Int>, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>): Boolean{
        var check = true

        if(indexFrom.second == indexTo.second){
            if (indexFrom.first < indexTo.first){
                for (i in indexFrom.first + 1 .. indexTo.first){
                    if(board[i][indexFrom.second] is CyanField){
                        check = false
                    } else if(board[i][indexFrom.second] is GreyField){
                        check = false
                    } else{
                        check = board[i][indexFrom.second]!!.pieceColor == board[indexFrom.first][indexFrom.second]!!.pieceColor
                        break
                    }
                }
            } else{
                for (i in indexFrom.first - 1 downTo  indexTo.first){
                    if(board[i][indexFrom.second] is CyanField){
                        check = false
                    } else if(board[i][indexFrom.second] is GreyField){
                        check = false
                    } else{

                        check = board[i][indexFrom.second]!!.pieceColor == board[indexFrom.first][indexFrom.second]!!.pieceColor

                        println("")
                        break
                    }
                }
            }

        } else{

            var firstIndexFrom = indexFrom.second

            if (indexFrom.first - 1 == indexTo.first) {
                if (board[indexTo.first][indexTo.second] !is CyanField && board[indexTo.first][indexTo.second] !is GreyField){
                    if (isTargetBeatable(board[indexFrom.first][indexFrom.second]!!, board[indexTo.first][indexTo.second]!!)){
                        check = false
                    }
                } else{
                    check = false
                }
            }else if (indexFrom.first + 1 == indexTo.first){
                if (board[indexTo.first][indexTo.second] !is CyanField && board[indexTo.first][indexTo.second] !is GreyField){
                    if (isTargetBeatable(board[indexFrom.first][indexFrom.second]!!, board[indexTo.first][indexTo.second]!!)){
                        check = false
                    }
                }

            } else{
                if (indexFrom.first > indexTo.first) {

                    for (i in indexFrom.first - 1 downTo indexTo.first - 1) {
                        if (board[i][firstIndexFrom] is CyanField || board[i][firstIndexFrom] is GreyField) {
                            check = false
                        } else {
                            check = true
                            break
                        }
                        firstIndexFrom++
                    }
                } else {

                    if (indexFrom.first == indexTo.first){
                        if (indexFrom.second < indexTo.second){
                            for (i in indexFrom.second until indexTo.second){
                                if (board[indexFrom.first][i + 1] is GreyField){
                                    check = false
                                } else if (board[indexFrom.first][i + 1] is CyanField){
                                    check = false
                                } else{
                                    check = true
                                    break
                                }
                            }
                        }
                    }

                    for (i in indexFrom.first + 1 .. indexTo.first) {
                        if (board[firstIndexFrom + 1][i] is CyanField || board[firstIndexFrom + 1][i] is GreyField) {
                            check = false
                        } else {
                            check = true
                            break
                        }
                        firstIndexFrom--
                    }
                }
            }

        }

        return check
    }

    /*
    gets the color of target piece or field
     */
    open fun targetColor(target: Pieces): String{

        return when(target){
            is Pawn -> target.fieldColor
            is Rook -> target.fieldColor
            is Knight -> target.fieldColor
            is Bishop -> target.fieldColor
            is Queen -> target.fieldColor
            is King -> target.fieldColor
            is CyanField -> "cyan"
            else -> "white"
        }
    }

    /*
    Method to check if move is possible. will be overritten in all child classes
     */
    open fun isMovePossible(row: Int, column: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{
        return true
    }

    /*
    checks if target is beatable
     */
    open fun isTargetBeatable(from: Pieces, to: Pieces): Boolean{

        if (from.pieceColor != to.pieceColor)
            return true

        return false
    }
}