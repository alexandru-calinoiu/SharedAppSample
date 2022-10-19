//
//  Screen.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import ExploreShared

struct RepoListView: View {
    @ObservedObject var viewModel: RepoListViewModel
    
    var body: some View {
        let loadMore: (Repo?) -> Void = { repo in Task { await viewModel.loadRepos(repo) } }
        
        List(viewModel.repoList) { repo in
            repoView(repo).onAppear {
                loadMore(repo)
            }
        }
    }
    
    // MARK: - Subviews
    
    private var listView: some View {
        ForEach(self.viewModel.repoList, id: \.name) { repo in
            repoView(repo)
        }
    }
    
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
        RepoListView(viewModel: viewModel)
    }
}
