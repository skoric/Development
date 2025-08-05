#!/usr/bin/env bash

# Syncs dotfiles folowing dotfile_mappings.txt.

set -euo pipefail

# Push dotfiles
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
MAP_FILE="$ROOT_DIR/dotfile_mappings.txt"
while IFS= read -r line; do
	[[ "$line" =~ ^#.*$ || -z "$line" ]] && continue
	src="${line%% -> *}"
	dst_rel="${line##* -> }"
	dst="$ROOT_DIR/$dst_rel"
	mkdir -p "$(dirname "$dst")"
	if [[ -d "${src/#\~/$HOME}" ]]; then
  		rsync -avh --progress "${src/#\~/$HOME}/" "$dst"
	else
  		rsync -avh --progress "${src/#\~/$HOME}" "$dst"
	fi
done < "$MAP_FILE"
