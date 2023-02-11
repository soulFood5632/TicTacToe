//
//  GamePiece.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-02-11.
//

import Foundation

enum GamePiece {
    case x
    case o
    
    func getOtherPeice(currentPiece: GamePiece) -> GamePiece {
        switch currentPiece {
        case .x:
            return .o
        case .o:
            return .x
        }
    }
}
