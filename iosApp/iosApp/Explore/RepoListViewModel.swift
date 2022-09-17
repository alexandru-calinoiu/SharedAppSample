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
    
    func loadRepos() async {
        let viewerRepo = RepositoryHelper().viewerRepository()
        
        do {
            let result = try await viewerRepo.repos(pageSize: 10, after: nil)
            result.fold(
                success: { (pagedResponse: SharedPagedResponse<Repo>?) -> Any? in
                    self.repoList = pagedResponse?.response as! [Repo] },
                failure: { (err: KotlinThrowable) -> () in print(err)} )
        } catch {
            print(error)
        }
    }
}
