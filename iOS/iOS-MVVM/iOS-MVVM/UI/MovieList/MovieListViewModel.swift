//
//  MovieListViewModel.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

protocol MovieListViewModelDelegate: ErrorReceivableDelegate {
    func didFetchMovies(_ movies: [Movie])
}

class MovieListViewModel {

    private let service: MovieListServiceProtocol
    private weak var delegate: MovieListViewModelDelegate?

    init(service: MovieListServiceProtocol = MovieListService()) {
        self.service = service
    }

    func bind(to delegate: MovieListViewModelDelegate) {
        self.delegate = delegate
    }

    func fetchMovies() {
        service.fetchMovies { [weak self] (result) in
            switch result {
            case .success(let movieList):
                let data = movieList.results
                self?.delegate?.didFetchMovies(data)
            case .failure:
                self?.delegate?.didReceiveError("Failed to get movies")
            }
        }
    }
}
