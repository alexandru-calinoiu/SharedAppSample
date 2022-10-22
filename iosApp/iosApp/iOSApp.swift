import SwiftUI
import Shared
import ExploreShared

@main
struct iOSApp: App {
    init() {
        ExploreKt.doInitKoin(properties: [
            Properties.shared.SERVER_URL:"https://api.github.com/graphql",
            Properties.shared.TOKEN: "your token"]
        )
    }
    
    var body: some Scene {
        WindowGroup {
            RepoListView(wViewModel: ViewModelWrapper.init(ViewModelHelper().viewModel()))
        }
    }
}
