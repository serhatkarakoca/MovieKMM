//
//  MovieGridItem.swift
//  iosApp
//
//  Created by Serhat on 11.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    let movie: Movie
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            
            ZStack{
                AsyncImage(url: URL(string: movie.imageUrl)) { image in
                    image.resizable()
                } placeholder: {
                        ProgressView()
                }.frame(minHeight: 180)
                Circle()
                    .frame(width: 50, height: 50)
                    .foregroundColor(.black.opacity(0.6))
                Image(systemName: "play.fill").foregroundColor(.white)
                
            }.frame(maxWidth: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(movie.title )
                .font(.title3)
                .lineLimit(1)
            
            Text(movie.releaseDate)
                .font(.caption)
                .lineLimit(1)
            
        }.frame(maxWidth: .infinity, maxHeight: 260)
    }
}

#Preview {
    MovieGridItem(movie: Movie(id: 21, originalLanguage: "english", originalTitle: "title", imageUrl: "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_FMjpg_UX1000_.jpg", releaseDate: "release date", title: "title", voteAverage: 3.2, voteCount: 23))
}
