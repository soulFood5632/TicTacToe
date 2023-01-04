from enum import Enum


class TicTacToe:
    board = None
    moveMapX = None
    moveMapO = None

    def __init__(self):
        self.board = Board()
        self.moveMapX = map(list, int)

    def make_move(self, move, player):
        if player == GamePiece.X:
            self.moveMapX[self.board.grid] = move
        else:
            self.moveMapO[self.board.grid] = move

        return self.board.make_move(move, player)

    def get_valid_moves(self):
        return self.board.get_valid_moves()





class Board:




    def __init__(self):
        self.grid = list()
        for index in range(9):
            self.grid.append(GamePiece.NO)

        self.__winnerList = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]

        ]

    def make_move(self, move, player):
        if self.grid[move] != GamePiece.NO:
            return False
        self.grid[move] = player
        return True

    def get_valid_moves(self):
        returnList = list()
        for index in range(9):
            if self.grid[index] == GamePiece.NO:
                returnList.append(index)

        return returnList

    def is_game_over(self):
        for triplets in self.__winnerList:







class GamePiece(Enum):
    X = 1
    O = 2
    NO = 3
