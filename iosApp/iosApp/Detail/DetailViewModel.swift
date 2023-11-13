//
//  DetailViewModel.swift
//  iosApp
//
//  Created by Serhat on 13.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class DetailViewModel : ObservableObject {

    let useCase = GetMovieDetailsUseCase.init()
    @Published private (set) var movieDetails: MovieDetails? = nil
    
    
    func getMovieDetails(id: Int32) async {
        do {
            let details = try await useCase.invoke(id: id)
            
            movieDetails = details
        } catch {
            
        }
    }
    
    
}
