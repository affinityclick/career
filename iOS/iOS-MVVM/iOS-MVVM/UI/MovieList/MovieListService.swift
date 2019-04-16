//
//  MovieListService.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct MoviesResponseObject: Decodable {
    let results: [Movie]
}

protocol MovieListServiceProtocol {
    func fetchMovies(completion: @escaping (Result<MoviesResponseObject>) -> Void)
}

class MovieListService: APIClient {
    var session: URLSession

    init(configuration: URLSessionConfiguration = .default) {
        self.session = URLSession(configuration: configuration)
    }
}

extension MovieListService: MovieListServiceProtocol {
    func fetchMovies(completion: @escaping (Result<MoviesResponseObject>) -> Void) {
        guard let url = URL(string: Constants.baseURL + "movie/top_rated") else {
            completion(.failure)
            return
        }
        let request = URLRequest(url: url)
        fetch(with: request, decode: { $0 as? MoviesResponseObject ?? nil }, completion: completion)
    }
}
