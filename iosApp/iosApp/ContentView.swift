import SwiftUI
import shared
import explore_shared

@MainActor final class ViewModel: ObservableObject {
    @Published var repoList: [Repo] = []
    
    func loadRepos() async {
        let viewerRepo = RepositoryHelper().viewerRepository()
        
        do {
            let result = try await viewerRepo.repos()
            result.fold(success: { (repos: NSArray?) -> Any? in self.repoList = repos as! [Repo] },
                        failure: { (err: KotlinThrowable) -> () in print(err)} )
        } catch {
            print(error)
        }
    }
}

struct ContentView: View {
    @StateObject var viewModel = ViewModel()

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

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
