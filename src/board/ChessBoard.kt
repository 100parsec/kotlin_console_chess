package board

import fields.CyanField
import fields.GreyField
import pieces.*

class ChessBoard {


    fun initialSetup(): Array<Array<Pieces?>> {

        val board = Array(8){
            arrayOfNulls<Pieces>(8)
        }

        board[0][0] = Rook(0,0,"white", "black")
        board[0][1] = Knight(0,1, "cyan", "black")
        board[0][2] = Bishop(0,2,"white", "black")
        board[0][3] = Queen(0,3,"cyan", "black")
        board[0][4] = King(0,4,"white", "black")
        board[0][5] = Bishop(0,5,"cyan", "black")
        board[0][6] = Knight(0,6,"white","black")
        board[0][7] = Rook(0,7,"cyan","black")

        board[1][0] = Pawn(1,0,"cyan","black")
        board[1][1] = Pawn(1,1,"white","black")
        board[1][2] = Pawn(1,2,"cyan","black")
        board[1][3] = Pawn(1,3,"white","black")
        board[1][4] = Pawn(1,4,"cyan","black")
        board[1][5] = Pawn(1,5,"white","black")
        board[1][6] = Pawn(1,6,"cyan","black")
        board[1][7] = Pawn(1,7,"white","black")

        board[2][0] = GreyField(2,0)
        board[2][1] = CyanField(2,1)
        board[2][2] = GreyField(2,2)
        board[2][3] = CyanField(2,3)
        board[2][4] = GreyField(2,4)
        board[2][5] = CyanField(2,5)
        board[2][6] = GreyField(2,6)
        board[2][7] = CyanField(2,7)

        board[3][0] = CyanField(3,0)
        board[3][1] = GreyField(3,1)
        board[3][2] = CyanField(3,2)
        board[3][3] = GreyField(3,3)
        board[3][4] = CyanField(3,4)
        board[3][5] = GreyField(3,5)
        board[3][6] = CyanField(3,6)
        board[3][7] = GreyField(3,7)

        board[4][0] = GreyField(4,0)
        board[4][1] = CyanField(4,1)
        board[4][2] = GreyField(4,2)
        board[4][3] = CyanField(4,3)
        board[4][4] = GreyField(4,4)
        board[4][5] = CyanField(4,5)
        board[4][6] = GreyField(4,6)
        board[4][7] = CyanField(4,7)

        board[5][0] = CyanField(5,0)
        board[5][1] = GreyField(5,1)
        board[5][2] = CyanField(5,2)
        board[5][3] = GreyField(5,3)
        board[5][4] = CyanField(5,4)
        board[5][5] = GreyField(5,5)
        board[5][6] = CyanField(5,6)
        board[5][7] = GreyField(5,7)

        board[6][0] = Pawn(6,0,"white", "white")
        board[6][1] = Pawn(6,1,"cyan", "white")
        board[6][2] = Pawn(6,2,"white", "white")
        board[6][3] = Pawn(6,3,"cyan", "white")
        board[6][4] = Pawn(6,4,"white", "white")
        board[6][5] = Pawn(6,5,"cyan", "white")
        board[6][6] = Pawn(6,6,"white", "white")
        board[6][7] = Pawn(6,7,"cyan", "white")

        board[7][0] = Rook(7,0,"cyan", "white")
        board[7][1] = Knight(7,1,"white", "white")
        board[7][2] = Bishop(7,2,"cyan", "white")
        board[7][3] = Queen(7,3,"white", "white")
        board[7][4] = King(7,4,"cyan", "white")
        board[7][5] = Bishop(7,5,"white", "white")
        board[7][6] = Knight(7,6,"cyan", "white")
        board[7][7] = Rook(7,7,"white","white")

        return board
    }
}