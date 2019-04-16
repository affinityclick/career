//
//  APIClient.swift
//  iOS-MVVM
//
//  Created by Guillian on 2019-04-16.
//  Copyright © 2019 AffinityClick. All rights reserved.
//

import Foundation
import UIKit

protocol APIClient {
    var session: URLSession { get }
    func fetch<T: Decodable>(with request: URLRequest,
                             decode: @escaping (Decodable) -> T?,
                             completion: @escaping (Result<T>) -> Void)
}

extension APIClient {
    private func decodingTask<T: Decodable>(with request: URLRequest,
                                            decodingType: T.Type,
                                            completionHandler completion: @escaping (Decodable?) -> Void) -> URLSessionDataTask {
        var mutableRequest = request
        addApiKey(to: &mutableRequest)
        let task = session.dataTask(with: mutableRequest) { data, response, _ in
            guard let httpResponse = response as? HTTPURLResponse else {
                completion(nil)
                return
            }

            print("API Response Status Code: \(httpResponse.statusCode)")

            if (httpResponse.statusCode == 200) {
                if let data = data {
                    do {
                        let decoder = JSONDecoder()
                        decoder.keyDecodingStrategy = .convertFromSnakeCase
                        let genericModel = try decoder.decode(decodingType, from: data)
                        completion(genericModel)
                    } catch {
                        print(error)
                        completion(nil)
                    }
                } else {
                    completion(nil)
                }
            } else {
                completion(nil)
            }
        }

        return task
    }

    private func addApiKey(to request: inout URLRequest) {
        guard let url = request.url,
            var urlComponents = URLComponents(url: url, resolvingAgainstBaseURL: false) else { return }
        let accessKeyQueryItem = URLQueryItem(name: "api_key", value: Constants.apiKey)
        urlComponents.queryItems = (urlComponents.queryItems ?? []) + [accessKeyQueryItem]
        request.url = urlComponents.url
    }

    func fetch<T: Decodable>(with request: URLRequest,
                             decode: @escaping (Decodable) -> T?,
                             completion: @escaping (Result<T>) -> Void) {
        let task = decodingTask(with: request, decodingType: T.self) { json in
            DispatchQueue.main.async {
                guard let json = json else {
                    completion(.failure)
                    return
                }

                if let value = decode(json) {
                    completion(.success(value))
                } else {
                    completion(.failure)
                }
            }
        }

        task.resume()
    }
}
