//
//  MovieListCellTableViewCell.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import UIKit
import Kingfisher

class MovieListCell: UITableViewCell {

    @IBOutlet weak var mainView: UIView!
    @IBOutlet weak var posterImageView: UIImageView!
    @IBOutlet weak var yearLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var ratingLabel: UILabel!

    override func layoutSubviews() {
        super.layoutSubviews()
        posterImageView.layer.cornerRadius = 10
        posterImageView.layer.maskedCorners = [.layerMinXMinYCorner, .layerMinXMaxYCorner]
        mainView.layer.cornerRadius = 10
        mainView.layer.shadowColor = UIColor.black.cgColor
        mainView.layer.shadowRadius = 6
        mainView.layer.shadowOpacity = 0.1
        mainView.layer.borderColor = UIColor.lightGray.withAlphaComponent(0.2).cgColor
        mainView.layer.borderWidth = 0.5
        let shadowRect = CGRect(x: 10, y: 10, width: frame.width - 20, height: frame.height - 20)
        mainView.layer.shadowPath = UIBezierPath(roundedRect: shadowRect, cornerRadius: 10).cgPath
    }

    func render(with movie: Movie) {
        let imageURL = URL(string: Constants.imageBaseURL + movie.posterPath)
        posterImageView.kf.setImage(with: imageURL)
        yearLabel.text = movie.releaseDate.components(separatedBy: "-").first
        titleLabel.text = movie.title
        ratingLabel.text = "\(movie.voteAverage)"
    }
}
