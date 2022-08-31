import SwiftUI
import shared
import explore_shared

@main
struct iOSApp: App {
    init() {
        ExploreKt.doInitKoin(properties: [Properties.shared.SERVER_URL:"https://api.github.com/graphql", Properties.shared.TOKEN: "your personal token"])
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
