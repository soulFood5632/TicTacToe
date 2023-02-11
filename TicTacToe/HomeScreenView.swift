//
//  ContentView.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-01-04.
//

import SwiftUI

struct HomeScreenView: View {
    var body: some View {
        NavigationView {
            VStack {
                
                Text("Tic Tac Toe")
                    .font(.system(size: 55))
                    .bold()
                    .padding()
                    .background(
                        RoundedRectangle(cornerRadius: 10)
                        
                            .opacity(0.4)
                            .frame(height: 150)
                            .foregroundColor(.cyan)
                    )
                
                
                
            
                Spacer(minLength: 10)
                    .frame(height: 75)
                
                NavigationLink {
                    PlayerScreen()
                } label: {
                    
                    Text("Play Now")
                        .bold()
                        .foregroundColor(.black)
                        .background(
                            RoundedRectangle(cornerRadius: 10)
                                .opacity(0.8)
                                .frame(width: 100, height: 50)
                                .foregroundColor(.red)
                            
                            
                        )
                    
                }
                
                
            }
        }
    }
}

struct HomeScreenView_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreenView()
    }
}
