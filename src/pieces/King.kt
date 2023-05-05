package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

class King(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow) {

    var fieldWithSymbol = String()
    var name = String()
    var pieceColor = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

        if (fieldColor == "cyan"){
            if (pieceColor == "white"){
                fieldWithSymbol = cyanField.setSymbol(Symbols.KING.symbol, "white")
                this.name = "king_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.KNIGHT.symbol, "black")
                this.name = "king_black"
            }
        } else{
            if (pieceColor == "white"){
                fieldWithSymbol = greyField.setSymbol(Symbols.KING.symbol, "white")
                this.name = "king_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.KING.symbol, "black")
                this.name = "king_black"
            }
        }
    }

    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.KING.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.KING.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(posColumn: Int, posRow: Int): Boolean{
        return false
    }
}