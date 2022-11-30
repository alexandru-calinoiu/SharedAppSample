//
//  FlowCollector.swift
//  iosApp
//
//  Created by Calin on 19.10.2022.
//  Copyright © 2022 orgName. All rights reserved.
//


import SwiftUI
import Shared

class FlowCollector<T> : Kotlinx_coroutines_coreFlowCollector {
    let callback:(T) -> Void

    init(callback: @escaping (T) -> Void) {
        self.callback = callback
    }

    func emit(value: Any?) async throws -> Void   {
        if let updatedValue = value as? T {
          callback(updatedValue)
        }
        return Void()
    }
}
