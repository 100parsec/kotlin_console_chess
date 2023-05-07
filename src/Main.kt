import board.ChessBoard
import fields.CyanField
import fields.GreyField
import pieces.*

val whoseMove = "white"
fun main() {

    printLogo()
    gameMenu()
}


fun gameMenu() {

    var check = false
    var board = initializeBoard()
    printBoard(board)

    while (!check) {

        if (whoseMove == "white") {
            println("Weiss ist am Zug.")
        } else{
            println("Schwarz ist am Zug.")
        }

        print("Welchen Zug wollen Sie machen?: ")
        val input = readln()

        var splittedInput = input.split(",")

        var indexFrom = splittedInput[0][1] - '0' - 1 to getSecondIndex(splittedInput[0][0])
        var indexTo = splittedInput[1][1] - '0' - 1 to getSecondIndex(splittedInput[1][0])

        printBoard(makeMove(indexFrom, indexTo, board))
    }

}


fun printLogo(){
    println("""
 _      _____ _____ _____   ______ _       _____   __   _____  _   _  _____ _____ _____ 
| |    |  ___|_   _/  ___|  | ___ \ |     / _ \ \ / /  /  __ \| | | ||  ___/  ___/  ___|
| |    | |__   | | \ `--.   | |_/ / |    / /_\ \ V /   | /  \/| |_| || |__ \ `--.\ `--. 
| |    |  __|  | |  `--. \  |  __/| |    |  _  |\ /    | |    |  _  ||  __| `--. \`--. \
| |____| |___  | | /\__/ /  | |   | |____| | | || |    | \__/\| | | || |___/\__/ /\__/ /
\_____/\____/  \_/ \____/   \_|   \_____/\_| |_/\_/     \____/\_| |_/\____/\____/\____/
    """.trimIndent())

    print("Press Enter to Start")
    readln()
    println()
    println()
}

fun initializeBoard(): Array<Array<Pieces?>> {

    // get instance
    val chessBoard = ChessBoard()

    // setup board
    return chessBoard.initialSetup()
}

fun printBoard(board: Array<Array<Pieces?>>){

    for(i in 0..7){
        print("${i+1} ")
        for (j in 0..7){
            val piece = board[i][j]
            if (piece is Rook) print(piece.fieldWithSymbol)
            if (piece is Knight) print(piece.fieldWithSymbol)
            if (piece is Bishop) print(piece.fieldWithSymbol)
            if (piece is Queen) print(piece.fieldWithSymbol)
            if (piece is King) print(piece.fieldWithSymbol)
            if (piece is Pawn) print(piece.fieldWithSymbol)
            if (piece is CyanField) print(piece.cyanField)
            if (piece is GreyField) print(piece.greyField)

        }
        println()
        if (i == 7){
            println("   A  B  C  D  E  F  G  H")
        }

    }
}

fun makeMove(indexFrom: Pair<Int, Int>, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>):  Array<Array<Pieces?>>{

    // get both positions from board
    var from = board[indexFrom.first][indexFrom.second]
    var to = board[indexTo.first][indexTo.second]



    var fieldColor = String()

    var pawn = Pawn(indexTo.first,indexTo.second,"", "")
    var bishop = Bishop(indexFrom.first,indexFrom.second,"", "")
    var king = King(indexFrom.first,indexFrom.second,"", "")
    var knight = Knight(indexFrom.first,indexFrom.second,"", "")
    var queen = Queen(indexFrom.first,indexFrom.second,"","")
    var rook = Rook(indexFrom.first,indexFrom.second,"","")

    var check = false

    if(from is Pawn){

        val test = from.isThereAPiece(indexFrom, indexTo, board)

        fieldColor = from.fieldColor



        // check is set true if move is possible and there is no piece on the way
        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, pawn, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
        }


    } else if (from is Bishop){
        bishop.pieceColor = from.pieceColor
        fieldColor = from.fieldColor

        if (to is CyanField){
            bishop.setNewBackground("cyan")
            board[indexTo.first][indexTo.second] = bishop
        } else{
            bishop.setNewBackground("white")
            board[indexTo.first][indexTo.second] = bishop
        }

    } else if (from is King){
        king.pieceColor = from.pieceColor
        fieldColor = from.fieldColor

        if (to is CyanField){
            king.setNewBackground("cyan")
            board[indexTo.first][indexTo.second] = king
        } else{
            king.setNewBackground("white")
            board[indexTo.first][indexTo.second] = king
        }
    } else if (from is Knight){
        knight.pieceColor = from.pieceColor
        fieldColor = from.fieldColor

        if (to is CyanField){
            knight.setNewBackground("cyan")
            board[indexTo.first][indexTo.second] = knight
        } else{
            knight.setNewBackground("white")
            board[indexTo.first][indexTo.second] = knight
        }
    } else if (from is Queen){
        queen.pieceColor = from.pieceColor
        fieldColor = from.fieldColor

        if (to is CyanField){
            queen.setNewBackground("cyan")
            board[indexTo.first][indexTo.second] = queen
        } else{
            queen.setNewBackground("white")
            board[indexTo.first][indexTo.second] = queen
        }
    } else if (from is Rook){
        rook.pieceColor = from.pieceColor
        fieldColor = from.fieldColor

        if (to is CyanField){
            queen.setNewBackground("cyan")
            board[indexTo.first][indexTo.second] = rook
        } else{
            queen.setNewBackground("white")
            board[indexTo.first][indexTo.second] = rook
        }
    }

    if (check){

        if(fieldColor == "cyan"){
            board[indexFrom.first][indexFrom.second] = CyanField(indexFrom.first, indexFrom.second)
        } else{
            board[indexFrom.first][indexFrom.second] = GreyField(indexFrom.first, indexFrom.second)
        }
    }


    return board
}

private fun getSecondIndex(c: Char): Int {
    when (c) {
        'a' -> return 0
        'b' -> return 1
        'c' -> return 2
        'd' -> return 3
        'e' -> return 4
        'f' -> return 5
        'g' -> return 6
        'h' -> return 7
    }
    return 0
}