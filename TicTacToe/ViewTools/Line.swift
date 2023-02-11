//
//  Line.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-02-11.
//

import SwiftUI

struct Line: View {
    private var start: CGPoint
    private var end: CGPoint
    
    public init(start: CGPoint, end: CGPoint) {
        self.start = start
        self.end = end
    }
    
    var body: some View {
        Path() { path in
            path.move(to: start)
            path.addLine(to: end)
        }
        .stroke(lineWidth: 10)
    }
    
    
}

struct Line_Previews: PreviewProvider {
    static var previews: some View {
        Line(start: CGPoint(x: 10, y: 10), end: CGPoint(x: 100, y: 100))
    }
}
