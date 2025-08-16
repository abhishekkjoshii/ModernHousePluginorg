
# ModernHouse (Paper/Spigot Plugin)

A very simple `/modernhouse` command that builds a small modern-style house (quartz + glass).

## Build locally (quick)
1. Install **Java 17** and **Gradle**.
2. In this folder, run:
   ```bash
   gradle build -x test
   ```
3. The jar will be in `build/libs/ModernHouse-1.0.0.jar`.
4. Upload the jar to your server's `/plugins` folder and restart the server.

## Build using GitHub (no local Gradle needed)
1. Create a new **GitHub repository** and upload the contents of this folder.
2. Go to **Actions** → select the **Build Plugin** workflow (it runs automatically on push).
3. When it finishes, download the artifact **ModernHouse-jar** → it contains the compiled plugin jar.

## Usage
- Join your server (Paper/Spigot 1.20+).
- Run: `/modernhouse`
- A 7×7 modern house will appear at your location.

## Notes
- If you're on 1.18–1.19, change `api-version` in `plugin.yml` and Paper API version in `build.gradle` accordingly.
