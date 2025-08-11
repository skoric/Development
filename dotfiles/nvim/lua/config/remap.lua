vim.g.mapleader = " "

vim.keymap.set("n", "<leader>pv", vim.cmd.Ex)

vim.keymap.set("n", "<leader>rf", function()
    local pos = vim.api.nvim_win_get_cursor(0)
    vim.cmd("normal! gg=G")
    vim.api.nvim_win_set_cursor(0, pos)
end, {desc = "Reformat file"})

-- Telescope
local builtin = require('telescope.builtin')
vim.keymap.set('n', '<leader>f', builtin.find_files, { desc = 'Telescope find files' })
vim.keymap.set('n', '<leader>g', builtin.live_grep, { desc = 'Telescope live grep' })
vim.keymap.set('n', '<leader>b', builtin.buffers, { desc = 'Telescope buffers' })
vim.keymap.set('n', '<leader>e', builtin.oldfiles, { desc = 'Telescope recently opened' })

-- Buffers
vim.keymap.set("n", "<leader>W", function()
  vim.cmd("wa")  -- write all modified buffers
  vim.notify("All buffers saved", vim.log.levels.INFO, { title = "Neovim" })
end, { desc = "Save all buffers" })
