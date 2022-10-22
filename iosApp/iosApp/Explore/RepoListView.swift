//
//  Screen.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import ExploreShared
import Shared

class ViewModelWrapper : ObservableObject {
    @Published public var state: RepoListState = .init(repos: [], lastCursor: nil, isLastPage: false)

    var viewModel: ExploreShared.RepoListViewModel
    var stateWatcher: SharedCloseable? = nil

    init(_ viewModel: ExploreShared.RepoListViewModel) {
        self.viewModel = viewModel
        stateWatcher = viewModel.setStateObserver { state in
            print(state.repos)
            self.state = state
        }
    }
    
    deinit {
        stateWatcher?.close_()
        viewModel.onCleared()
    }
}

struct RepoListView: View {
    @ObservedObject var wViewModel: ViewModelWrapper
    
    var body: some View {
        let loadMore: (Repo?) -> Void = { repo in Task { wViewModel.viewModel.fetchRepos(repo: repo) } }
        
        List(wViewModel.state.repos) { repo in
            repoView(repo).onAppear {
                loadMore(repo)
            }
        }.onAppear {
            loadMore(nil)
        }
    }
    
    // MARK: - Subviews
    
//    private var listView: some View {
//        ForEach(self.viewModel.repoList, id: \.name) { repo in
//            repoView(repo)
//        }
//    }
    
    private var loadingView: some View {
        Text("Loading")
    }
    
    private func repoView(_ repo: Repo) -> some View {
        Text(repo.name)
    }
    
    private var emptyList: some View {
        Text("No repos yet")
    }
}

struct Screen_Previews: PreviewProvider {
    static let repos = [
        Repo(owner: "Owner", name: "Repo 1", description: "description", primaryLanguage: "Test", lastActivity: nil),
        Repo(owner: "Owner", name: "Repo Vlad", description: "description", primaryLanguage: "Test", lastActivity: nil)
    ]
    
    static let viewModel = RepoListViewModel.build(repos)
    
    static var previews: some View {
        EmptyView()
//        RepoListView(viewModel: viewModel)
    }
}
