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
        let list = self.viewModel.repoList
        let isLastPage = self.viewModel.isLastPage

        ZStack {
            ScrollView(.vertical) {
                LazyVStack {
                    if !list.isEmpty {
                        ListView(list)
                    }
                    
                    if !isLastPage {
                        LoadingView()
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

private struct ListView: View {
    private var list: [Repo]
    
    init(_ list: [Repo]) {
        self.list = list
    }
    
    var body: some View {
        ForEach(list, id: \.name) { repo in
            Text(repo.name)
        }
    }
}

private struct LoadingView: View {
    var body: some View {
        Text("Loading")
    }
}

struct Screen_Previews: PreviewProvider {
    static var previews: some View {
        RepoListView()
    }
}
