import Foundation

public enum Config {
    private static let infoDictionary: [String: Any] = {
        guard let dict = Bundle.main.infoDictionary else {
            fatalError("Plist not found")
        }
        return dict
    }()
    
    static let token: String = {
        guard let url = Config.infoDictionary[Keys.token.rawValue] as? String else {
            fatalError("Token not set in plist")
        }
        return url
    }()
    
    private enum Keys: String {
        case token = "TOKEN"
    }
}
