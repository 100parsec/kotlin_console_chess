import board.ChessBoard
import fields.CyanField
import fields.GreyField
import pieces.*
import java.lang.Exception

var whoseMove = "white"
var globalBoard: Array<Array<Pieces?>> = arrayOf(arrayOf(Pieces(0,0,"")))
fun main() {
    printLogo()
    gameMenu()
}

/*
this is the main menu of the game.
here it is said who is on the move and here the move is forwarded to the makeMove function.
And the result is passed to the function printBoard
 */
fun gameMenu() {

    var check = false
    var board = initializeBoard()
    printBoard(board)

    while (!check) {

        var indexFrom = Pair<Int, Int>(0,0)
        var indexTo = Pair<Int, Int>(0,0)
        var move = false

        while (!move){

            if (whoseMove == "white"){
                println("Weiss ist am Zug")
            } else if (whoseMove == "black"){
                println("Schwarz ist am Zug")
            }

            var validInput = false

            while (!validInput){
                print("Welchen Zug wollen Sie machen?: ")
                val input = readln()

                try {
                    val splittedInput = input.split(",")
                    indexFrom = splittedInput[0][1] - '0' - 1 to getSecondIndex(splittedInput[0][0])
                    indexTo = splittedInput[1][1] - '0' - 1 to getSecondIndex(splittedInput[1][0])

                    if (indexFrom.first >= 0 && indexFrom.second <= 7 && indexTo.first >= 0 && indexTo.second <= 7){
                        validInput = true
                    } else{
                        println("Die Koordinaten liegen außerhalb des Boards")
                    }

                }catch (e: Exception){
                    println("Ihre Einfgabe hat das falsche Format")
                    println("Beispiel Format: a7,a5")
                }
            }

            move = whosMove(whoseMove, indexFrom)

        }

        val result = makeMove(indexFrom, indexTo, board)

        if (result.second){
            printBoard(result.first)

            whoseMove = if (whoseMove == "white"){
                "black"
            } else{
                "white"
            }
        }
    }
}

/*
The function checks who is on the move
 */
fun whosMove(whosMove: String, indexFrom:  Pair<Int, Int>): Boolean{
    val piece = globalBoard[indexFrom.first][indexFrom.second]

    if(whosMove == "white"){
        if(piece!!.pieceColor == "black"){
            return false
        }
        return true
    } else{
        if (piece!!.pieceColor == "white"){
            return false
        }
        return true
    }
}

/*
this funktion initializes board
 */
fun initializeBoard(): Array<Array<Pieces?>> {

    // get instance
    val chessBoard = ChessBoard()

    // setup board
    return chessBoard.initialSetup()
}

/*
this function prints the board to the console
 */
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
    globalBoard = board
}

/*
this function makes the movement. first it is checked which figure should be moved. then for checked if the move is possible and if the path to the target is free
 */
fun makeMove(indexFrom: Pair<Int, Int>, indexTo: Pair<Int, Int>, board: Array<Array<Pieces?>>): Pair< Array<Array<Pieces?>>,Boolean>{

    // get both positions from board
    var from = board[indexFrom.first][indexFrom.second]
    var to = board[indexTo.first][indexTo.second]

    var result = true

    var fieldColor = String()

    // sets target index to piece
    var pawn = Pawn(indexTo.first,indexTo.second,"", "")
    var bishop = Bishop(indexTo.first,indexTo.second,"", "")
    var king = King(indexTo.first,indexTo.second,"", "")
    var knight = Knight(indexTo.first,indexTo.second,"", "")
    var queen = Queen(indexTo.first,indexTo.second,"","")
    var rook = Rook(indexTo.first,indexTo.second,"","")

    var check = false

    if(from is Pawn){

        fieldColor = from.fieldColor

        // check is set true if move is possible and there is no piece on the way
        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, pawn, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }


    } else if (from is Bishop){

        fieldColor = from.fieldColor

        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, bishop, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }

    } else if (from is King){

        fieldColor = from.fieldColor

        // check is set true if move is possible and there is no piece on the way
        val check1 = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor)
        val check2 = from.isThereAPiece(indexFrom, indexTo, board)

        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, king, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }

    } else if (from is Knight){
        fieldColor = from.fieldColor

        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor)

        if (check){
            to?.let { from.makeMove(from, knight, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }

    } else if (from is Queen){

        fieldColor = from.fieldColor

        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, queen, it, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }

    } else if (from is Rook){

        fieldColor = from.fieldColor

        check = from.isMovePossible(indexTo.first, indexTo.second, board, from.pieceColor) && !from.isThereAPiece(indexFrom, indexTo, board)

        if (check){
            to?.let { from.makeMove(from, rook, to, indexTo, board) }!!
        } else{
            println("Dieser Zug ist nicht möglich")
            result = false
        }

        globalBoard = board
    }

    if (check){

        if(fieldColor == "cyan"){
            board[indexFrom.first][indexFrom.second] = CyanField(indexFrom.first, indexFrom.second, "")
        } else{
            board[indexFrom.first][indexFrom.second] = GreyField(indexFrom.first, indexFrom.second, "")
        }
    }


    return Pair(board,result)
}

/*
Gets the index of the column
 */
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
    return 8
}

/*
this function prints the logo to the console
 */
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