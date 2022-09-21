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
    @StateObject var viewModel = RepoListViewModel()
    
    var body: some View {
        ZStack {
            ScrollView(.vertical) {
                LazyVStack {
                    if !self.viewModel.repoList.isEmpty {
                        listView
                    }
                    
                    if !self.viewModel.isLastPage {
                        loadingView
                            .onAppear {
                                Task {
                                    await self.viewModel.loadRepos()
                                }
                            }
                    }
                }
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
}

struct Screen_Previews: PreviewProvider {
    static var previews: some View {
        RepoListView()
    }
}
