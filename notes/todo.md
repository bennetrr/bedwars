# Things to do

This is basically a list of all the features that the datapack had

## onEnable

- [X] Set the spawnRadius to 0
- [X] A command that starts the game directly
- [ ] A command to configure, start and stop the game
- [ ] (Optional) Maybe a GUI for the configuration?
    - Training mode
    - Maximal players per team
- [X] Set the spawnpoint to the spawn island

## Pre-game loop

- [X] Give all players saturation, regeneration and weakness

## Game initialization

- [X] Cleanup the game region and copy the map
- [X] Create teams and assign the members
- [X] Spawn the villagers and give them their trades (-> `items.md`)
- [X] Set the right game modes
- [X] Teleport the players to their islands
- [X] Cleanup items, ender chests and inventories

## Game loop

- [ ] Display for teams, active traps and upgrades, etc.
- [ ] Check if the bed of a team is destroyed and manage deaths
- [ ] Determine the winner
- [ ] Process special items like fireballs, traps, upgrades, etc.
- [X] Crafting protection
- [X] Display for how long the game is running
- [X] Spawn iron, gold, diamonds and emeralds (-> `spawning.md`)
- [X] Increase the spawn rate of diamonds and emeralds over time
- [X] Block placing and breaking protections
- [X] Give every player saturation

## Post-game

- [ ] Teleport the players to the spawn (`999 43 7`) and set the spawnpoint
- [ ] Clear inventories
- [ ] Delete the teams and other objects
- [ ] Cleanup entities
- [X] Set every player's game mode to adventure

## Fixes

- [ ] Fix that the spawners spawn the items not in the middle of the block
- [ ] Add onLogin-Event and teleport the players to spawn
- [ ] Add game area to forceload-chunks
- [ ] Build a barrier around the game area
- [ ] Test TNT-Jumping and Fireball-Jumping