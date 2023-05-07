package pieces

import fields.CyanField
import fields.GreyField

open class Pieces(var posColumn: Int, var posRow: Int) {

    open fun isThereAPiece(indexFrom: Pair<Int, Int>, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>): Boolean{
        var check = true

        val pieceFromColor = board[indexFrom.first][indexFrom.second]

        if(indexFrom.second == indexTo.second){
            for (i in indexFrom.first + 1..indexTo.first){
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
            //6 0 -- 5 1

        }

        return check
    }
}