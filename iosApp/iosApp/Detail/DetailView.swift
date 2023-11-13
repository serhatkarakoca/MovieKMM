//
//  DetailView.swift
//  iosApp
//
//  Created by Serhat on 13.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct DetailView: View {
    
    let movieId: Int32
    
    @StateObject private var viewModel = DetailViewModel()
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 0) {
                
                ZStack() {
                    AsyncImage(url: URL(string: viewModel.movieDetails?.imageUrl ?? "")) { image in
                        
                        image.resizable().scaledToFill()
                        
                    } placeholder: {
                        ProgressView()
                    }
                }.frame(maxWidth: .infinity, minHeight: 300, maxHeight: 350).clipped()
                
                Text(viewModel.movieDetails?.title ?? "")
                    .font(.title)
                    .bold()
                    .padding(EdgeInsets(top: 16, leading: 0, bottom: 0, trailing: 0))
            
                
                Text("Released in "+(viewModel.movieDetails?.releaseDate ?? ""))
                    .font(.caption)
                    .lineLimit(1)
                    .padding(EdgeInsets(top: 8, leading: 0, bottom: 0, trailing: 0))
                
                Spacer()
                
                Button {
                    print("clicked")
                } label: {
                    HStack {
                        Image(systemName: "play.fill").foregroundColor(.white)
                        Text("Start watching now").foregroundColor(.white)
                    }
                }.frame(maxWidth: .infinity, maxHeight: 40)
                    .padding(16)
                    .background(.red)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                   
                Spacer(minLength: 16)
                
                Text((viewModel.movieDetails?.overview ?? ""))
                    .font(.body)
                    .fixedSize(horizontal: false, vertical: true)
                    .padding(12)
                

            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity).task {
            await viewModel.getMovieDetails(id: movieId)
        }
    }
}

#Preview {
    DetailView(movieId: 2)
}
