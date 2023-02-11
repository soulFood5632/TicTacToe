//
//  PlayerScreen.swift
//  TicTacToe
//
//  Created by Logan Underwood on 2023-01-04.
//

import SwiftUI
import UIKit


struct PlayerScreen: View {
    @State var isXsTurn = true
    @State var settingScreen = true
    
    @State var tournamentModeGoal = ""
    
    var body: some View {
        VStack {
            HStack {

                
                

            }
            
            Form {
                Section(header: Text("Tournament Mode")) {
                    
                    HStack {
                        Text("Game Goal")
                            .font(.headline)
                            .multilineTextAlignment(.leading)
                        
                        Divider()
                        
                        TextField("Wins", text: $tournamentModeGoal)
                        
                    }
                    
                    

                    
                    
                }
            }
        }
        
            
        
        
    }
}

struct PlayerScreen_Previews: PreviewProvider {
    static var previews: some View {
        PlayerScreen()
    }
}


