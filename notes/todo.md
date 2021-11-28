# Things to do
This is basically a list of all the features that the datapack had

## onEnable
- [X] Set the spawnRadius to 0
- [ ] A command that starts the game directly
- [ ] A command to configure, start and stop the game
- [ ] Maybe a GUI for the configuration?
    - Training mode
    - Maximal players per team
- [X] Set the spawnpoint to the spawn island (`999 43 7`)

## Pre-game loop
- [ ] Give all players saturation, regeneration and weakness

## Game initialization
- [ ] Cleanup the game region and copy the map
- [ ] Create teams and assign the members
- [ ] Spawn the villagers and give them their trades (-> `items.md`)
- [ ] Enable the spawners
- [ ] Set the right game modes
- [ ] Teleport the players to their islands
- [ ] Cleanup items, ender chests and inventories

## Game loop
- [ ] Display for how long the game is running
- [ ] Display for teams, active traps and upgrades, etc.
- [ ] Spawn iron, gold, diamonds and emeralds (-> `spawning.md`)
- [ ] Increase the spawn rate of diamonds and emeralds over time
- [ ] Block placing and breaking protections
- [ ] Crafting protection
- [ ] Give every player saturation
- [ ] Check if the bed of a team is destroyed and manage deaths
- [ ] Determine the winner
- [ ] Process special items like fireballs, traps, upgrades, etc.

## Post-game
- [ ] Teleport the players to the spawn (`999 43 7`) and set the spawnpoint
- [ ] Set every player's game mode to adventure
- [ ] Clear inventories
- [ ] Delete the teams and other objects
- [ ] Disable the spawners
- [ ] Cleanup entities

## onDisable
- [ ] Stop all running games