package pieces

import fields.CyanField
import fields.GreyField
import utils.Symbols

/*
represents the pawn and inherits from pieces
The dawn is initialized with piece color and field color,
also the exact position on the board is kept
 */
class Pawn(posColumn: Int, posRow: Int, fieldColor: String, pieceColor: String) : Pieces(posColumn, posRow) {

    var fieldWithSymbol = String()
    var name = String()
    var pieceColor = String()
    var fieldColor = String()

    init {
        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

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

        val cyanField = CyanField(0,0)
        val greyField = GreyField(0,0)

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
    fun isMovePossible(posColumn: Int, posRow: Int, board: Array<Array<Pieces?>>, pieceColor: String): Boolean{


        return if (pieceColor == "white"){
            var check = this.posColumn - posColumn
            // wenn der bauer auf anfangsposition ist kann er max 2 felder ziehen
            // ist er nicht auf anfangsposition kann er nur 1 feld ziehen
            check(6, check)

        } else{
            var check = posColumn - this.posColumn
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