package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

/*
represents the pawn and inherits from pieces
The pawn is initialized with piece color and field color,
also the exact position on the board is kept
 */
class Pawn(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow, pieceColor) {

    var fieldWithSymbol = String()
    var name = String()
    //var pieceColor = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        this.pieceColor = pieceColor
        this.fieldColor = fieldColor

        // initializes figure with field color
        if (fieldColor == "cyan") {
            if (pieceColor == "white") {
                fieldWithSymbol = cyanField.setSymbol(Symbols.PAWN.symbol, "white")
                this.name = "pawn_white"
            } else{
                fieldWithSymbol = cyanField.setSymbol(Symbols.PAWN.symbol, "black")
                this.name = "pawn_black"
            }
        } else{
            if (pieceColor == "white") {
                fieldWithSymbol = greyField.setSymbol(Symbols.PAWN.symbol, "white")
                this.name = "pawn_white"
            } else{
                fieldWithSymbol = greyField.setSymbol(Symbols.PAWN.symbol, "black")
                this.name = "pawn_black"
            }
        }
    }

    /*
    sets a new field color after a move
    Parameter:
    color as String -> the new field color
     */
    fun setNewBackground(color: String){

        val cyanField = CyanField(0,0, "")
        val greyField = GreyField(0,0, "")

        if (color == "white"){
            fieldWithSymbol = greyField.setSymbol(Symbols.PAWN.symbol, this.pieceColor)
        } else{
            fieldWithSymbol = cyanField.setSymbol(Symbols.PAWN.symbol, this.pieceColor)
        }
    }

    /*
    Checks if the move is possible
    Paramters:
    posColum as Int -> the position to which the figure should move
    posRow as Int -> the position to which the figure should move
    board as Array<Array<Pieces?>> -> the board in its current state
    pieceColor as String -> the color of the figure to be moved
    Return:
    Boolean -> true if the move is possible or false if not
     */
    override fun isMovePossible(posColumn: Int, posRow: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{

        val targetPiece = board[posColumn][posRow]
        /*
        für weiss wenn this.posColumn - posColumn = 1 und posRow - thisPosRow = 1
        check targetfield
         */
        val first = this.posColumn - posColumn
        val second = posRow - this.posRow

        if (first == 1 && second == 1 && targetPiece!!.pieceColor != this.pieceColor){
            if (targetPiece!!.pieceColor == ""){
                return false
            }
            return true
        } else if (second > 1){
            return false
        }

        var dsv = true
        return if (pieceColor == "white"){
            val check = this.posColumn - posColumn
            /*
            if (first != second){
                dsv = dontStrikeVertically(targetPiece!!) //TODO check vertikal strike
            }
             */
            check(6, check)

        } else{
            val check = posColumn - this.posColumn
            /*
            if (first != second){
                dsv = dontStrikeVertically(targetPiece!!) //TODO check vertikal strike
            }
             */
            check(1, check)
        }

    }

    /*
    moves the figure to the desired field
    Parameter:
    from as pawn -> the pawn from initial field
    pawn as pawn -> the new pawn that will be set on new position
    to as Pieces -> the target field
    indexTo as a Pair of Ints -> The target coordinates
    board as Array<Array<Pieces?>> -> the board in its current state
     */
    fun makeMove(from: Pawn, pawn: Pawn, to: Pieces, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>){
        pawn.pieceColor = from.pieceColor

        pawn.fieldColor = targetColor(to)

        when(to){
            is CyanField -> pawn.setNewBackground("cyan")
            is GreyField -> pawn.setNewBackground("white")
            is Pawn -> pawn.setNewBackground(to.fieldColor)
            is Rook -> pawn.setNewBackground(to.fieldColor)
            is Knight -> pawn.setNewBackground(to.fieldColor)
            is Queen -> pawn.setNewBackground(to.fieldColor)
            is King -> pawn.setNewBackground(to.fieldColor)
        }


        board[indexTo.first][indexTo.second] = pawn
    }

    /*
    checks if the pawn my move one or two fileds
    Parameter:
    count as int -> Number of fields to be move
    check as int -> represents the initial position six for white and one for black
     */
    private fun check(count: Int, check: Int): Boolean {

        return if (this.posColumn == count){
            check <= 2
        } else{
            check == 1
        }

    }

    private fun dontStrikeVertically(targetPiece: Pieces): Boolean {
        if (targetPiece!!.pieceColor == "white" || targetPiece!!.pieceColor == "black"){
            return false
        }
        return true
    }
}