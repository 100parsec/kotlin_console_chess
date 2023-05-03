package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols


class Rook(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow) {

    var fieldWithSymbol = String()
    var name = String()
    var pieceColor = String()

    init {
        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

        this.pieceColor = pieceColor

        if (fieldColor == "cyan") {
            if (pieceColor == "white") {
                fieldWithSymbol = cyanField.setSymbol(Symbols.ROOK.symbol, "white")
                this.name = "rook_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.ROOK.symbol, "black")
                this.name = "rook_black"
            }
        } else{
            if (pieceColor == "white"){
                fieldWithSymbol = greyField.setSymbol(Symbols.ROOK.symbol, "white")
                this.name = "rook_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.ROOK.symbol,"black")
                this.name = "rook_black"
            }
        }
    }

    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.ROOK.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.ROOK.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(row: Int, column: Int): Boolean{
        return false
    }
}