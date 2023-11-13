//
//  HomeViewMoel.swift
//  iosApp
//
//  Created by Serhat on 11.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class HomeViewModel: ObservableObject {
    private let useCase = GetPopularMoviesUseCase.init()
    
    @Published private(set) var movies:[Movie] = []
    @Published private(set) var isLoading: Bool = false
    private (set) var loadFinished: Bool = false
    private var currentPage: Int32 = 1
    
    func getMovies() async {
        if isLoading {
            return
        }
        
        do {
            isLoading = true
            let movies = try await useCase.invoke(page: currentPage)
            isLoading = false
            loadFinished = movies.isEmpty
            
            currentPage += 1
           
            self.movies = (self.movies + movies).uniqued()
        } catch {
            isLoading = false
            loadFinished = true
            print("could not load")
        }
    }
}
