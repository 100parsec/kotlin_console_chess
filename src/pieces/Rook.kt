package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

/*
represents the pawn and inherits from pieces
The rook is initialized with piece color and field color,
also the exact position on the board is kept
 */
class Rook(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var fieldWithSymbol = String()
    var name = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

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

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.ROOK.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.ROOK.symbol, this.pieceColor)
        }
    }

    override fun isMovePossible(row: Int, column: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{
        val fromColumn = this.posRow
        val fromRow = this.posColumn

        val toColumn = column
        val toRow = row

        if (fromColumn == toColumn && fromRow != toRow){
            return true
        }

        if (fromColumn != toColumn && fromRow == toRow){
            return true
        }

        return false
    }

    fun makeMove(from: Rook, rook: Rook, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>){
        rook.pieceColor = from.pieceColor

        rook.fieldColor = targetColor(to)

        when(to){
            is CyanField -> rook.setNewBackground("cyan")
            is GreyField -> rook.setNewBackground("white")
            is Pawn -> rook.setNewBackground(to.fieldColor)
            is Rook -> rook.setNewBackground(to.fieldColor)
            is Knight -> rook.setNewBackground(to.fieldColor)
            is Queen -> rook.setNewBackground(to.fieldColor)
            is King -> rook.setNewBackground(to.fieldColor)
        }


        board[indexTo.first][indexTo.second] = rook
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