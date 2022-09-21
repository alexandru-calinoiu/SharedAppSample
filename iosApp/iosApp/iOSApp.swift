import SwiftUI
import Shared
import ExploreShared

@main
struct iOSApp: App {
    init() {
        ExploreKt.doInitKoin(properties: [
            Properties.shared.SERVER_URL:"https://api.github.com/graphql",
            Properties.shared.TOKEN: "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"]
        )
    }
    
    var body: some Scene {
        WindowGroup {
            RepoListView()
        }
    }
}
