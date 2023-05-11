package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

class King(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

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

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.KING.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.KING.symbol, this.pieceColor)
        }
    }

    fun isMovePossible(posColumn: Int, posRow: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{

        val fromRow = this.posColumn
        val fromColumn = this.posRow


        val toColumn = posRow
        val toRow = posColumn

        val rightFieldFirstIndex = fromRow
        val rightFieldSecondIndex = fromColumn + 1

        if (fromRow - 1 == toRow && fromColumn == toColumn || fromRow + 1 == toRow && fromColumn == toColumn || fromRow - 1 == toRow && fromColumn + 1 == posColumn){
            return true
        }

        if (rightFieldFirstIndex == toRow && rightFieldSecondIndex == toColumn){
            return true
        }








        val lowerRightFieldFirstIndex = fromRow + 1
        val lowerRightFieldSecondIndex = fromColumn + 1


        val lowerLeftFieldFirstIndex = fromRow + 1
        val lowerLeftFieldColumnIndex = fromColumn - 1

        val leftFieldFirstIndex = fromRow
        val leftFieldSecondIndex = fromColumn - 1

        val upperLeftFieldFirstIndex = fromRow - 1
        val upperLeftFieldSecondIndex = fromColumn - 1


        return false
    }

    fun makeMove(from: King, king: King, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>) {
        king.pieceColor = from.pieceColor

        king.fieldColor = targetColor(to)

        when(to){
            is CyanField -> king.setNewBackground("cyan")
            is GreyField -> king.setNewBackground("white")
            is Pawn -> king.setNewBackground(to.fieldColor)
            is Rook -> king.setNewBackground(to.fieldColor)
            is Knight -> king.setNewBackground(to.fieldColor)
            is Queen -> king.setNewBackground(to.fieldColor)
            is King -> king.setNewBackground(to.fieldColor)
        }


        board[indexTo.first][indexTo.second] = king
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