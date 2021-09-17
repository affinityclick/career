//
//  MovieListViewController.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit
import SideMenu

class MovieListViewController: UIViewController, ActivityIndicatorContainer {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var activityIndicator: UIActivityIndicatorView!

    private let viewModel = MovieListViewModel()
    private lazy var dataSource = MovieListDataSource(delegate: self)
    private let storyBoard = UIStoryboard(name: "Main", bundle: nil)

    // MARK: - Life cycle

    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
        setupSideMenu()
    }

    // MARK: - Private

    private func startLoading() {
        activityIndicator.startAnimating()
        tableView.isHidden = true
    }
    
    private func setupUI() {
        title = "Top Rated Movies"
        tableView.register(UINib(nibName: "MovieListCell", bundle: nil), forCellReuseIdentifier: "MovieListCell")
        tableView.dataSource = dataSource
        tableView.delegate = dataSource
        tableView.rowHeight = 200
    }

    private func setupSideMenu() {
        guard let vc = storyBoard.instantiateViewController(withIdentifier: "MenuViewController") as? MenuViewController else {
            return
        }
        vc.delegate = self
        let leftMenu = UISideMenuNavigationController(rootViewController: vc)
        leftMenu.navigationBar.isHidden = true
        SideMenuManager.default.menuLeftNavigationController = leftMenu
        SideMenuManager.default.menuPresentMode = .menuSlideIn
        SideMenuManager.default.menuFadeStatusBar = false
        SideMenuManager.default.menuAnimationFadeStrength = 0.3

        if let navigationController = navigationController {
            SideMenuManager.default.menuAddPanGestureToPresent(toView: navigationController.navigationBar)
            SideMenuManager.default.menuAddScreenEdgePanGesturesToPresent(toView: navigationController.view)
        }
    }

    // MARK: - Actions

    @IBAction func menuPressed(_ sender: Any) {
        guard let vc = SideMenuManager.default.menuLeftNavigationController else {
            return
        }
        present(vc, animated: true)
    }
}

extension MovieListViewController: MovieListDataSourceDelegate {
    func didSelectMovie(_ movie: Movie) {
        guard let vc = storyBoard.instantiateViewController(withIdentifier: "MovieDetailViewController") as? MovieDetailViewController else {
            return
        }
        navigationController?.pushViewController(vc, animated: true)
    }
}

extension MovieListViewController: MenuViewControllerDelegate {
    func didSelectTopRatedMovies() {
        if navigationController?.viewControllers.last != self {
            navigationController?.popToRootViewController(animated: true)
        }
    }

    func didSelectNowPlayingMovies() {
        // TODO: Fetch the now playing movies from the movie db API and display them in the table view
        // TODO: change the title of the view controller to "Now Playing Movies"
    }
}
