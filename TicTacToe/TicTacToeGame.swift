//
//  TicTacToeGame.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-02-11.
//

import SwiftUI

struct TicTacToeGame: View {
    
    
    var body: some View {
        GeometryReader { outwardFrame in
            GeometryReader { geo in
                
                Line(start: CGPoint(x: 0, y: 2 * geo.size.height / 3 ), end: CGPoint(x: geo.size.width, y: geo.size.height * 2 / 3))
                
                Line(start: CGPoint(x: 0, y:  geo.size.height / 3 ), end: CGPoint(x: geo.size.width, y: geo.size.height / 3))
                
                Line(start: CGPoint(x: geo.size.width / 3, y: 0 ), end: CGPoint(x: geo.size.width / 3, y: geo.size.height))
                
                Line(start: CGPoint(x: 2 * geo.size.width / 3, y:  0 ), end: CGPoint(x: 2 * geo.size.width / 3, y: geo.size.height))
            }
            .padding()
            .frame(width: min(outwardFrame.size.width, outwardFrame.size.height), height: min(outwardFrame.size.width, outwardFrame.size.height))
            .frame(width: outwardFrame.size.width, height: outwardFrame.size.height)
        }
    }
}

struct TicTacToeGame_Previews: PreviewProvider {
    static var previews: some View {
        TicTacToeGame()
    }
}
