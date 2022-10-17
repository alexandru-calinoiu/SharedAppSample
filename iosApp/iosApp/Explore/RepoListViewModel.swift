//
//  ViewModel.swift
//  iosApp
//
//  Created by Calin on 02.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import ExploreShared

@MainActor final class RepoListViewModel: ObservableObject {
    @Published var repoList: [Repo] = []
    
    let pageSize: Int32 = 40
    
    var viewerRepo: ViewerRepository
    var isLastPage: Bool = false
    var lastCursor: String? = nil
    var loadingCursor: String? = nil
    
    static func build(_ repos: [Repo]) -> RepoListViewModel {
        return RepoListViewModel(viewerRepo: FakeViewerRepository(repos: repos))
    }
    
    static func buildReal() -> RepoListViewModel {
        RepoListViewModel(viewerRepo: RepositoryHelper().viewerRepository())
    }
    
    init(viewerRepo: ViewerRepository) {
        self.viewerRepo = viewerRepo
        
        Task {
            await self.loadRepos(nil)
        }
    }
    
    func loadRepos(_ repo: Repo?) async {
        if (isLoadingCurrentCursor() || self.isLastPage || isNotLast(repo)) {
            return
        }
        
        self.loadingCursor = self.lastCursor
        
        do {
            let result = try await self.viewerRepo.repos(pageSize: pageSize, after: lastCursor)
            result.fold(
                success: { pagedResponse in self.handleSuccessResponse(pagedResponse: pagedResponse) },
                failure: { (err: KotlinThrowable) -> () in print(err) } )
        } catch {
            print(error)
        }
    }
    
    private func isLoadingCurrentCursor() -> Bool {
        self.loadingCursor == self.lastCursor && self.lastCursor != nil
    }
    
    private func isNotLast(_ repo: Repo?) -> Bool {
        self.repoList.last != repo
    }
    
    private func handleSuccessResponse(pagedResponse: SharedPagedResponse<Repo>?) {
        (pagedResponse?.response as? [Repo] ?? []).forEach { repo in
            if !self.repoList.contains(where: { r in
                r.name == repo.name
            }) {
                self.repoList.append(repo)
            }
        }
        
        if let pageInfo = pagedResponse?.pageInfo {
            self.lastCursor = pageInfo.endCursor
            self.isLastPage = !pageInfo.hasNextPage
        }
    }
}
