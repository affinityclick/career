//
//  MenuViewController.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit

protocol MenuViewControllerDelegate: class {
    func didSelectTopRatedMovies()
    func didSelectNowPlayingMovies()
}

class MenuViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!

    weak var delegate: MenuViewControllerDelegate?

    // MARK: - Life cycle

    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }

    // MARK: - Private

    private func setupUI() {
        tableView.dataSource = self
        tableView.delegate = self
    }
}

extension MenuViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell()
        cell.textLabel?.numberOfLines = 0
        cell.textLabel?.text = indexPath.row == 0 ? "Top Rated Movies" : "Now Playing Movies"
        cell.imageView?.image = UIImage(named: indexPath.row == 0 ? "star-icon" : "movie-reel-icon")
        return cell
    }
}

extension MenuViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        if indexPath.row == 0 {
            dismiss(animated: true) { [weak self] in
                self?.delegate?.didSelectTopRatedMovies()
            }
        } else if indexPath.row == 1 {
            dismiss(animated: true) { [weak self] in
                self?.delegate?.didSelectNowPlayingMovies()
            }
        }
    }
}
