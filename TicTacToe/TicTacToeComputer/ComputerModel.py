from Game import TicTacToe, Board, GamePiece

class ComputerModel:
    def __init__(self):


class TacData:

    def __init__(self):
        self.data = dict()

    def addData(self, map_of_moves, win_value):
        for position in map_of_moves.keys():
            if position in self.data:
                if map_of_moves[position] in self.data[position]:
                    self.data[position][map_of_moves[position]][0] = win_value
                    self.data[position]






