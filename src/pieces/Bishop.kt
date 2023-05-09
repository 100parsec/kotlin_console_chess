package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

class Bishop(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var fieldWithSymbol = String()
    var name = String()
    //var pieceColor = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

        if(fieldColor == "cyan"){
            if (pieceColor == "white"){
                fieldWithSymbol = cyanField.setSymbol(Symbols.BISHOP.symbol, "white")
                this.name = "bishop_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.BISHOP.symbol, "black")
                this.name = "bishop_black"
            }
        } else{
            if (pieceColor == "white"){
                fieldWithSymbol = greyField.setSymbol(Symbols.BISHOP.symbol, "white")
                this.name = "bishop_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.BISHOP.symbol, "black")
                this.name = "bishop_black"
            }
        }
    }

    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.BISHOP.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.BISHOP.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(column: Int, row: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{

        var fromRow = this.posColumn
        val fromColumn = this.posRow

        val toRow = column
        val toColumn = row

        if (fromRow > toRow){
            for (i in fromRow downTo toRow){
                fromRow--
                if (fromRow >= toRow){

                }
            }
        }

        /*
            fromRow = 7
            fromColumn = 2

            toRow = 5
            toColumn = 4
         */

        return false
    }
}