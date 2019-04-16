//
//  Result.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation

enum Result<Value> {
    case success(Value)
    case failure
}
