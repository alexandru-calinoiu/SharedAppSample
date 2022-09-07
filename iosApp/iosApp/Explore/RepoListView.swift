//
//  Screen.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct RepoListView: View {
    @StateObject var viewModel = RepoListViewModel()

    var body: some View {
        ForEach(self.viewModel.repoList, id: \.name) { repo in
            VStack {
                Text(repo.name)
            }.padding(.bottom, 10)
        }.onAppear {
            Task {
                await self.viewModel.loadRepos()
            }
        }
    }
}

struct Screen_Previews: PreviewProvider {
    static var previews: some View {
        RepoListView()
    }
}
