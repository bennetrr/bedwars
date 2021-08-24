#region Player cleanup
spawnpoint @a 999 43 7
tp @a 999 43 7
clear @a
gamemode adventure @a
#endregion

#region Scoreboards
scoreboard players set gameActive data 0
scoreboard objectives remove timer
scoreboard objectives remove deaths
scoreboard objectives remove armor
scoreboard objectives remove uiAction
scoreboard objectives remove stop
scoreboard objectives remove start
scoreboard objectives remove eliminated

scoreboard objectives add start trigger
scoreboard players enable @a start

scoreboard objectives remove teamOrange
scoreboard objectives remove teamRed
scoreboard objectives remove teamGreen
scoreboard objectives remove teamGray
#endregion

#region Teams
team remove teamGray
team remove teamGreen
team remove teamOrange
team remove teamRed
#endregion

#region Redstone block removal
fill 735 30 -17 704 64 -32 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -17 672 64 -32 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -17 640 64 -32 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -17 608 64 -32 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -33 704 64 -48 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -33 672 64 -48 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -33 640 64 -48 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -33 608 64 -48 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -49 704 64 -64 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -49 672 64 -64 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -49 640 64 -64 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -49 608 64 -64 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -65 704 64 -80 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -65 672 64 -80 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -65 640 64 -80 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -65 608 64 -80 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -81 704 64 -96 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -81 672 64 -96 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -81 640 64 -96 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -81 608 64 -96 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -97 704 64 -112 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -97 672 64 -112 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -97 640 64 -112 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -97 608 64 -112 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -113 704 64 -128 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -113 672 64 -128 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -113 640 64 -128 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -113 608 64 -128 minecraft:polished_granite replace minecraft:redstone_block

fill 735 30 -129 704 64 -144 minecraft:polished_granite replace minecraft:redstone_block
fill 703 30 -129 672 64 -144 minecraft:polished_granite replace minecraft:redstone_block
fill 671 30 -129 640 64 -144 minecraft:polished_granite replace minecraft:redstone_block
fill 639 30 -129 608 64 -144 minecraft:polished_granite replace minecraft:redstone_block
#endregion

#region Entity cleanup
kill @e[tag=trader]
kill @e[type=item]
#endregion