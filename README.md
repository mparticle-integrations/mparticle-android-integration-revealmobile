## Reveal Mobile Kit Integration

This repository contains the [Reveal Mobile](http://www.revealmobile.com/) integration for the [mParticle Android SDK](https://github.com/mParticle/mparticle-android-sdk).

### Adding the integration

1. [Enable the integration](https://app.mparticle.com/providers) for your mParticle app.
2. Add the kit dependency to your project. Kits are all made available via Maven Central, you can add them to your project just by adding their maven artifact (ex. `com.mparticle:android-revealmobile-kit`). [See here for the current list of all kits](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mparticle%22).
    
    > If you would like to specify an explicit Reveal SDK version that you would like to use, add the following snipit to the `dependencies` section of you `build.gradle` file, after replacing {custom-version} with the explicit version number (i.e `1.3.31`)
    >
    >       compile('com.mparticle:android-reveal-kit:4.15.3') {
    >               exclude group: 'com.stepleaderdigital.reveal'
    >       }
    >       
    >       //include your custom version
    >       compile 'com.stepleaderdigital.reveal:reveal:{custom-version}'     
    > 
3. If you haven't already added it, the core mParticle Android SDK will automatically be pulled in as a dependency of the kit. Follow the quick start of the mParticle Core SDK, then re-build and launch your app, and verify that you see `"Reveal Mobile detected"` in the output of `adb logcat`.

### License

[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)