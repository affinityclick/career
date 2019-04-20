//
//  Crew.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

struct Crew: Decodable {
    let creditId: String
    let department: String
    let gender: Int
    let id: Int
    let name: String
    let profilePath: String
}
