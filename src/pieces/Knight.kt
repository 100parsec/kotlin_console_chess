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

    fun isMovePossible(posColumn: Int, posRow: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{
        return true
    }

    fun makeMove(from: Knight, knight: Knight, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>) {
        knight.pieceColor = from.pieceColor

        knight.fieldColor = targetColor(to)

        when(to){
            is CyanField -> knight.setNewBackground("cyan")
            is GreyField -> knight.setNewBackground("white")
            is Pawn -> knight.setNewBackground(to.fieldColor)
            is Rook -> knight.setNewBackground(to.fieldColor)
            is Knight -> knight.setNewBackground(to.fieldColor)
            is Queen -> knight.setNewBackground(to.fieldColor)
            is King -> knight.setNewBackground(to.fieldColor)
        }


        board[indexTo.first][indexTo.second] = knight

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