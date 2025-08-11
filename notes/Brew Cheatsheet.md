```sh
brew install <package>
brew uninstall <package>
brew install --cask <package> # Install from cask
brew uninstall --cask <package> # Uninstall cask package

brew search <name>
brew info <name>

brew update # Updates formulas and brew itself
brew upgrade # Upgrades packages
brew cleanup # Remove old packages and perform cleanup
brew doctor # Check setup for problems
brew outdated # Show outdate packages

brew services list # List services
brew services start <service>
brew services stop <service>
brew services restart <service>
brew services run <service> # Runs service until terminal session is closed.

brew list # List installed CLI packages
brew list --cask # List installed Cask packages
brew list --full-name # List formulea + casks
brew list --versions
```
