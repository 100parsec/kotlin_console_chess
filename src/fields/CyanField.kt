package fields

import pieces.Pieces
import utils.Colors

class CyanField(posColumn: Int, posRow: Int, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var cyanField = String()
    var name = String()


    init {
        cyanField = "${Colors.CYAN_BG.color}   ${Colors.RESET_COLOR.color}"
        this.name = "cyanField"
    }

    fun setSymbol(symbol: String, pieceColor: String): String{

        if (pieceColor == "black"){
            cyanField = "${Colors.CYAN_BG.color}${Colors.BLACK_PI.color}$symbol${Colors.RESET_COLOR.color}"
        } else{
            cyanField = "${Colors.CYAN_BG.color}$symbol${Colors.RESET_COLOR.color}"
        }
        return cyanField
    }
}