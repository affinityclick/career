//
//  Cast.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct Cast: Decodable {
    let castId: Int
    let character: String
    let creditId: String
    let gender: Int
    let name: String
    let id: Int
    let order: Int
    let profilePath: String
}
