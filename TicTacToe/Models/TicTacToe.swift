//
//  TicTacToe.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-02-11.
//

import Foundation
import Combine

class TicTacToe: ObservableObject {
    
    /// Game board
    @Published private var gameBoard: [GamePiece?]
    
    @Published public var whoseMove: GamePiece
    
    /// Starts a tictactoe game
    init(whoStarts: GamePiece) {
        self.gameBoard = Self.blankBoard
        self.whoseMove = whoStarts
    }
    
    /// A Blank board populated with empty game pieces
    private static let blankBoard: [GamePiece?] = {
        var board = [GamePiece?]()
        
        for _ in 0..<9 {
            board.append(nil)
        }
        
        return board
    }()
    
    
    /// <#Description#>
    /// - Parameters:
    ///   - position: <#position description#>
    ///   - piece: <#piece description#>
    ///
    ///   - throws: MoveException for various different illegal moves.
    ///   The three expceptions are as follows: .notYourMove for
    public func makeMove(position: Int, piece: GamePiece) throws {
        if position < 0 || position > 8 {
            throw MoveException.invalidIndex
        }
        if piece != whoseMove {
            throw MoveException.notYourMove
        }
        if self.gameBoard[position] != nil {
            throw MoveException.occupiedSquare
        }
        
        self.gameBoard[position] = piece
        self.whoseMov
    }
    
    public func getBoard() -> [GamePiece?] {
        return gameBoard
    }
    
    
    
    
    
    
}

enum MoveException: Error {
    case notYourMove
    case occupiedSquare
    case invalidIndex
    
}
