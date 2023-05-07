package fields

import pieces.Pieces
import utils.Colors

class GreyField(posColumn: Int, posRow: Int, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var greyField = String()
    var name = String()

    init {
        greyField = "${Colors.GREY_BG.color}   ${Colors.RESET_COLOR.color}"
        this.name = "greyField"
    }

    fun setSymbol(symbol: String, pieceColor: String): String{

        if (pieceColor == "black"){
            greyField = "${Colors.GREY_BG.color}${Colors.BLACK_PI.color}$symbol${Colors.RESET_COLOR.color}"
        } else{
            greyField = "${Colors.GREY_BG.color}$symbol${Colors.RESET_COLOR.color}"
        }
        return greyField
    }
}