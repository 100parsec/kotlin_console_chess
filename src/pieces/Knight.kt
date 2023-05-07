package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

class Knight(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var fieldWithSymbol = String()
    var name = String()
    //var pieceColor = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

        if (fieldColor == "cyan"){
            if (pieceColor == "white"){
                fieldWithSymbol = cyanField.setSymbol(Symbols.KNIGHT.symbol, "white")
                this.name = "knight_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.KNIGHT.symbol, "black")
                this.name = "knight_black"
            }
        } else{
            if (pieceColor == "white"){
                fieldWithSymbol = greyField.setSymbol(Symbols.KNIGHT.symbol, "white")
                this.name = "knight_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.KNIGHT.symbol, "black")
                this.name = "knight_black"
            }
        }
    }

    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.KNIGHT.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.KNIGHT.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(posColumn: Int, posRow: Int): Boolean{
        return false
    }
}