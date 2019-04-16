//
//  Movie.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct Movie: Decodable {
    let posterPath: String
    let adult: Bool
    let overview: String
    let releaseDate: String
    let id: Int
    let originalTitle: String
    let originalLanguage: String
    let title: String
    let backdropPath: String
    let popularity: Double
    let voteCount: Int
    let voteAverage: Double
}
