//
//  ErrorReceivableDelegate.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit

protocol ErrorReceivableDelegate: class {
    func didReceiveError(_ errorMessage: String)
}

extension ErrorReceivableDelegate where Self: UIViewController & ActivityIndicatorContainer {
    func didReceiveError(_ errorMessage: String) {
        activityIndicator.stopAnimating()
        handleError(errorMessage)
    }
}

extension ErrorReceivableDelegate where Self: UIViewController {
    func didReceiveError(_ errorMessage: String) {
        handleError(errorMessage)
    }
}
