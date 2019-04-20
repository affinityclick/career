//
//  MovieListDataSource.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit

protocol MovieListDataSourceDelegate: class {
    func didSelectMovie(_ movie: Movie)
}

class MovieListDataSource: NSObject {
    var data: [Movie] = []

    private weak var delegate: MovieListDataSourceDelegate?

    init(delegate: MovieListDataSourceDelegate) {
        self.delegate = delegate
    }
}

extension MovieListDataSource: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "MovieListCell") as? MovieListCell else {
            return UITableViewCell()
        }
        let movie = data[indexPath.row]
        cell.render(with: movie)
        return cell
    }
}

extension MovieListDataSource: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        let movie = data[indexPath.row]
        delegate?.didSelectMovie(movie)
    }
}
