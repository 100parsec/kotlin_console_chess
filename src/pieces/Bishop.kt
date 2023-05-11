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

    fun makeMove(from: Bishop, bishop: Bishop, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>) {
        bishop.pieceColor = from.pieceColor

        bishop.fieldColor = targetColor(to)

        when(to){
            is CyanField -> bishop.setNewBackground("cyan")
            is GreyField -> bishop.setNewBackground("white")
            is Pawn -> bishop.setNewBackground(to.fieldColor)
            is Rook -> bishop.setNewBackground(to.fieldColor)
            is Knight -> bishop.setNewBackground(to.fieldColor)
            is Queen -> bishop.setNewBackground(to.fieldColor)
            is King -> bishop.setNewBackground(to.fieldColor)
        }

        board[indexTo.first][indexTo.second] = bishop
    }

    private fun targetColor(target: Pieces): String{

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
}