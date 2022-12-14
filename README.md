## Shared App Sample

How can one build a modern mobile app for the future of mobile development where we are going to be application developers

### Goals

- share as much as code as possible
- ideally the app developer should focus on the UI elements only

### Explain arch
TODO

### How to run

- generate a github personal token
- update features .graphqlconfig (copy the example)
- update koin.properties from androidApp (copy the examlpe)
- need to run `gradlew podspec` (for iOS dev)

### TODO

- [x] Find out how to share schema.json between features
- [x] Add iOS feature1 link it to the shared project and main app and make it run
- [x] Add actual async network calls
- [ ] Figure out preview
- [ ] Add pagination list to iOS (Calin)
- [ ] Consider moving UI -> to shared/android/components
- [ ] Details screen implementation (Cipi)
- [ ] Add bottom navigation (Denis)
- [ ] Profile feature (Robert)
- [ ] Consider using https://github.com/icerockdev/moko-mvvm to share view models
- [ ] Add swift format and swift linter
