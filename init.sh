#!/usr/bin/env bash
# Initializes development environment.
# Syncs dotfiles following dotfile_mappings.txt.
# Makes all scripts executable.
set -euo pipefail

# Pull dotfiles
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MAP_FILE="$ROOT_DIR/dotfile_mappings.txt"

echo "[init] Syncing dotfiles from mappings..."
while IFS= read -r line; do
	[[ "$line" =~ ^#.*$ || -z "$line" ]] && continue
	
	dst_raw="${line%% -> *}"
	src_rel="${line##* -> }"
	
	# Expand tilde in destination path
	dst="${dst_raw/#\~/$HOME}"
	# Construct full source path
	src="$ROOT_DIR/$src_rel"
	
	echo "[init] Syncing: $src -> $dst"
	
	# Create destination directory
	mkdir -p "$(dirname "$dst")"
	
	# Sync the file/directory
	if [[ -d "$src" ]]; then
		rsync -avh --progress "$src/" "$dst"
	else
		rsync -avh --progress "$src" "$dst"
	fi
done < "$MAP_FILE"

# Make all /scripts files executable.
echo "[init] Making all files in /scripts executable..."
if [[ -d "$ROOT_DIR/scripts" ]]; then
	find "$ROOT_DIR/scripts" -type f -exec chmod +x {} \;
fi

echo "[init] Done."
