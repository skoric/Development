```sh
tmux new -s name # Create new session
C-a d # Detach current session
tmux attach -t name # Attach session
tmux ls # List all sessions
tmux kill-session -t name # Kill session

C-a c # Create window
C-a n # Next window (or use number)
C-a p # Previous window (or use number)
C-a w # List all sessions
C-a & # Kill current window

C-a | # Split vertically
C-a - # Split horizontally
C-a o # Cycle panes
C-a x # Kill pane
C-a <arrow> # Resize pane
```