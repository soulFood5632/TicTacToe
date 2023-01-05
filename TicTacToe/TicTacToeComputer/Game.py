from enum import Enum


class TicTacToe:

    def __init__(self):
        self.board = Board()
        self.moveMapX = dict()
        self.moveMapO = dict()

    def make_move(self, move, player):
        if player == GamePiece.X:
            self.moveMapX[self.board.grid] = move
        else:
            self.moveMapO[self.board.grid] = move

        return self.board.make_move(move, player)

    def get_valid_moves(self):
        return self.board.get_valid_moves()

    def is_game_over(self):
        return self.board.is_game_over()

    def __who_won(self):
        return self.board.who_won()

    # Only to be called when the game is complete
    def get_moves(self, game_piece):
        if game_piece == GamePiece.X:
            return self.moveMapX
        else:
            return self.moveMapO



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
        if self.__is_full():
            return True
        for triplets in self.__winnerList:
            if self.grid[triplets[0]] == self.grid[triplets[1]] or self.grid[triplets[1]] == self.grid[triplets[2]] and self.grid[triplets[0]] != GamePiece.NO:
                return True
        return False

    def __is_full(self):
        for val in self.grid:
            if val.NO:
                return False
        return True

    def who_won(self):
        if self.__is_full():
            for triplets in self.__winnerList:
                if (self.grid[triplets[0]] and self.grid[triplets[1]] and self.grid[triplets[2]]) == GamePiece.X:
                    return GamePiece.X
                if (self.grid[triplets[0]] and self.grid[triplets[1]] and self.grid[triplets[2]]) == GamePiece.O:
                    return GamePiece.O
            return GamePiece.NO


class GamePiece(Enum):
    X = 1
    O = 2
    NO = 3
