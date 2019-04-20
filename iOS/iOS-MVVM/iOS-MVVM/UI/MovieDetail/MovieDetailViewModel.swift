//
//  MovieDetailViewModel.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

protocol MovieDetailViewModelDelegate: ErrorReceivableDelegate {
    func didFetchGenres(_ genres: String)
}

class MovieDetailViewModel {

    var movie: Movie!

    private let service: MovieDetailServiceProtocol
    private weak var delegate: MovieDetailViewModelDelegate?

    init(service: MovieDetailServiceProtocol = MovieDetailService()) {
        self.service = service
    }

    func bind(to delegate: MovieDetailViewModelDelegate) {
        self.delegate = delegate
    }

    func fetchGenres() {
        service.fetchGenres(for: movie.id) { [weak self] (result) in
            switch result {
            case .success(let genresResponseObject):
                let genresString = genresResponseObject.genres.map { $0.name }.joined(separator: ", ")
                self?.delegate?.didFetchGenres(genresString)
            case .failure:
                self?.delegate?.didReceiveError("Failed to get genres")
            }
        }
    }
}
