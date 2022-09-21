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
    var list: [Repo] { self.viewModel.repoList }
    var isLastPage: Bool { self.viewModel.isLastPage }

    var listView: some View {
        ForEach(list, id: \.name) { repo in
            RepoView(repo: repo)
        }
    }
    
    var loadingView: some View {
        Text("Loading")
    }
    
    var body: some View {
        ZStack {
            ScrollView(.vertical) {
                LazyVStack {
                    if !list.isEmpty {
                        listView
                    }
                    
                    if !isLastPage {
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
}

struct Screen_Previews: PreviewProvider {
    static var previews: some View {
        RepoListView()
    }
}
