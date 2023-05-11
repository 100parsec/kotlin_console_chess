package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

class Queen(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var fieldWithSymbol = String()
    var name = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

        if (fieldColor == "cyan") {
            if (pieceColor == "white"){
                fieldWithSymbol = cyanField.setSymbol(Symbols.QUEEN.symbol, "white")
                this.name = "queen_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.QUEEN.symbol, "black")
                this.name = "queen_black"
            }
        } else {
            if (pieceColor == "white"){
                fieldWithSymbol = greyField.setSymbol(Symbols.QUEEN.symbol, "white")
                this.name = "queen_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.QUEEN.symbol, "black")
                this.name = "queen_black"
            }
        }
    }

    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.QUEEN.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.QUEEN.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(column: Int, row: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{
        return true
    }

    fun makeMove(from: Queen, queen: Queen, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>){
        queen.pieceColor = from.pieceColor

        queen.fieldColor = targetColor(to)

        when(to){
            is CyanField -> queen.setNewBackground("cyan")
            is GreyField -> queen.setNewBackground("white")
            is Pawn -> queen.setNewBackground(to.fieldColor)
            is Rook -> queen.setNewBackground(to.fieldColor)
            is Knight -> queen.setNewBackground(to.fieldColor)
            is Queen -> queen.setNewBackground(to.fieldColor)
            is King -> queen.setNewBackground(to.fieldColor)
        }


        board[indexTo.first][indexTo.second] = queen
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