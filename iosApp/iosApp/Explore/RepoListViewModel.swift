//
//  ViewModel.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import ExploreShared

final class RepoListViewModel: ObservableObject {
    @Published public var state: RepoListState = .init(repos: [], lastCursor: nil, isLastPage: false)
    
    var viewModel: ExploreShared.RepoListViewModel
    private var stateWatcher: SharedCloseable? = nil
    
    init(_ viewModel: ExploreShared.RepoListViewModel) {
        self.viewModel = viewModel
        stateWatcher = viewModel.setStateObserver { state in
            self.state = state
        }
    }
    
    deinit {
        stateWatcher?.close_()
        viewModel.onCleared()
    }
}
