import SwiftUI
import shared

struct ContentView: View {
	@StateObject var viewModel = HomeViewModel()

    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
	var body: some View {
        NavigationStack {
            ScrollView {
                LazyVGrid(columns: gridColumns, spacing: 16) {
                    
                    ForEach(viewModel.movies, id: \.id) { movie in
                        
                        NavigationLink(value: movie){
                            MovieGridItem(movie: movie).task {
                                if movie == viewModel.movies.last && !viewModel.isLoading && !viewModel.loadFinished {
                                    await viewModel.getMovies()
                                }
                            }
                        }.buttonStyle(PlainButtonStyle())
                    }
                    
                    if viewModel.isLoading {
                        Section(footer: ProgressView()) {
                            
                        }
                    }
                }.padding(.horizontal, 12).navigationDestination(for: Movie.self) { movie in
                    DetailView(movieId: movie.id)
                }.navigationTitle("Movies")
                    .navigationBarTitleDisplayMode(.inline)
            }
        }.task {
            await viewModel.getMovies()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
