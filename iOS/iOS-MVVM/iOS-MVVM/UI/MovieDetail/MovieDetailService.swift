//
//  MovieDetailService.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct GenresResponseObject: Decodable {
    let genres: [Genre]
}

protocol MovieDetailServiceProtocol {
    func fetchGenres(for movieId: Int, completion: @escaping (Result<GenresResponseObject>) -> Void)
}

class MovieDetailService: APIClient {
    var session: URLSession

    init(configuration: URLSessionConfiguration = .default) {
        self.session = URLSession(configuration: configuration)
    }
}

extension MovieDetailService: MovieDetailServiceProtocol {
    func fetchGenres(for movieId: Int, completion: @escaping (Result<GenresResponseObject>) -> Void) {
        guard let url = URL(string: Constants.baseURL + "movie/\(movieId)") else {
            completion(.failure)
            return
        }
        let request = URLRequest(url: url)
        fetch(with: request, decode: { $0 as? GenresResponseObject ?? nil }, completion: completion)
    }
}
