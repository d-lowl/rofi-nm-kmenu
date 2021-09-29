# rofi-nm-kmenu
The script for rofi, that allows turning Network Manager connections on and off.

## Build and install
Run gradle build:
```
./gradlew build
```

Then copy `./build/bin/native/releaseExecutable` to your `PATH`

## Usage
```
rofi -show nm -modi "nm:rofi-nm-kmenu.kexe"
```