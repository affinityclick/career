//
//  CreditsService.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct CreditsResponseObject: Decodable {
    let cast: [Cast]
    let crew: [Crew]
}

protocol CreditsServiceProtocol {
    func fetchCredits(for movieId: String, completion: @escaping (Result<CreditsResponseObject>) -> Void)
}

class CreditsService: APIClient {
    var session: URLSession

    init(configuration: URLSessionConfiguration = .default) {
        self.session = URLSession(configuration: configuration)
    }
}

extension CreditsService: CreditsServiceProtocol {
    func fetchCredits(for movieId: String, completion: @escaping (Result<CreditsResponseObject>) -> Void) {
        // TODO: fetch credits from the movie's credits endpoint, see
        // https://developers.themoviedb.org/3/movies/get-movie-credits for details
    }
}
