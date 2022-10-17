//
//  Repo+Identifiable.swift
//  iosApp
//
//  Created by Vlad Stanescu on 17.10.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import ExploreShared

extension Repo: Identifiable {
    public var id: String {
        self.name
    }
}
