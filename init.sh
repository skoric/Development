#!/usr/bin/env bash

# Initializes development environment.
# Syncs dotfiles folowing dotfile_mappings.txt.
# Makes all scripts executable.

set -euo pipefail

# Pull dotfiles
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MAP_FILE="$ROOT_DIR/dotfile_mappings.txt"

echo "[init] Syncing dotfiles from mappings..."
while IFS= read -r line; do
	[[ "$line" =~ ^#.*$ || -z "$line" ]] && continue
	dst="${line%% -> *}"
	src_rel="${line##* -> }"
	src="$ROOT_DIR/$src_rel"
	mkdir -p "$(dirname "$dst")"
	if [[ -d "${src/#\~/$HOME}" ]]; then
  		rsync -avh --progress "${src/#\~/$HOME}/" "$dst"
	else
  		rsync -avh --progress "${src/#\~/$HOME}" "$dst"
	fi	
done < "$MAP_FILE"

# Make all /scripts files executable.
echo "[init] Making all files in /scripts executable..."
find "$ROOT_DIR/scripts" -type f -exec chmod +x {} \;

echo "[init] Done."
