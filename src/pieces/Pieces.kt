package pieces

import fields.CyanField
import fields.GreyField

open class Pieces(var posColumn: Int, var posRow: Int,var pieceColor: String) {

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
                        check = true
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


                    val first = indexFrom.first - 1
                    val second = indexTo.first

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
                    for (i in indexFrom.first + 1 until indexTo.first) {
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

    open fun isTargetBeatable(from: Pieces, to: Pieces): Boolean{

        if (from.pieceColor != to.pieceColor)
            return true

        return false
    }
}