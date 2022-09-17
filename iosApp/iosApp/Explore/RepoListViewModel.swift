//
//  ViewModel.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared
import ExploreShared

@MainActor final class RepoListViewModel: ObservableObject {
    @Published var repoList: [Repo] = []
    
    let pageSize: Int32 = 40
    
    var isLastPage: Bool = false
    var lastCursor: String? = nil
    
    func loadRepos() async {
        let viewerRepo = RepositoryHelper().viewerRepository()
        
        do {
            let result = try await viewerRepo.repos(pageSize: pageSize, after: lastCursor)
            result.fold(
                success: { pagedResponse in self.handleSuccessResponse(pagedResponse: pagedResponse) },
                failure: { (err: KotlinThrowable) -> () in print(err)} )
        } catch {
            print(error)
        }
    }
    
    private func handleSuccessResponse(pagedResponse: SharedPagedResponse<Repo>?) {
        self.repoList.append(contentsOf: pagedResponse?.response as? [Repo] ?? [])
        if let pageInfo = pagedResponse?.pageInfo {
            self.lastCursor = pageInfo.endCursor
            self.isLastPage = !pageInfo.hasNextPage
        }
    }
}
