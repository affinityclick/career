//
//  MovieDetailViewController.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit
import Kingfisher
import Cosmos

class MovieDetailViewController: UIViewController {

    @IBOutlet weak var backdropImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var ratingView: CosmosView!
    @IBOutlet weak var genresLabel: UILabel!
    @IBOutlet weak var releaseDateLabel: UILabel!
    @IBOutlet weak var overviewLabel: UILabel!

    let viewModel = MovieDetailViewModel()

    // MARK: - Life cycle

    override func viewDidLoad() {
        super.viewDidLoad()
        setupNavigationBar()
        setMovieUI()
        viewModel.bind(to: self)
        viewModel.fetchGenres()
    }

    // MARK: - Private

    private func setupNavigationBar() {
        title = viewModel.movie.title
        navigationItem.largeTitleDisplayMode = .never
    }

    private func setMovieUI() {
        let backdropImageURL = URL(string: Constants.imageBaseURL + viewModel.movie.backdropPath)
        backdropImageView.kf.setImage(with: backdropImageURL)
        titleLabel.text = viewModel.movie.title
        ratingView.settings.fillMode = .precise
        ratingView.rating = viewModel.movie.voteAverage / 2
        releaseDateLabel.text = viewModel.movie.releaseDate
        overviewLabel.text = viewModel.movie.overview
    }

    // MARK: - Actions

    @IBAction func creditsPressed(_ sender: Any) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        guard let vc = storyboard.instantiateViewController(withIdentifier: "CreditsViewController") as? CreditsViewController else {
            return
        }
        navigationController?.pushViewController(vc, animated: true)
    }
}

extension MovieDetailViewController: MovieDetailViewModelDelegate {
    func didFetchGenres(_ genres: String) {
        genresLabel.text = genres
    }
}
