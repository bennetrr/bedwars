tellraw @a {"text": "Bitte warten, das Spiel wird geladen...\n(Kurze Lags möglich!)", "color": "gold"}

#region Scoreboards
scoreboard objectives add timer dummy
scoreboard objectives add deaths deathCount
scoreboard objectives add armor dummy
scoreboard objectives add eliminated dummy

scoreboard players set @a eliminated 0

scoreboard objectives add uiAction trigger
scoreboard objectives remove start
scoreboard objectives add stop trigger

scoreboard objectives add teamOrange dummy
scoreboard objectives add teamRed dummy
scoreboard objectives add teamGreen dummy
scoreboard objectives add teamGray dummy

scoreboard players set seconds timer 0
scoreboard players set minutes timer 0
#endregion

#region Teams
team add teamOrange "Orange"
team modify teamOrange color yellow
team modify teamOrange prefix "[Orange] "

team add teamRed "Rot"
team modify teamRed color dark_red
team modify teamRed prefix "[Rot] "

team add teamGreen "Grün"
team modify teamGreen color dark_green
team modify teamGreen prefix "[Grün] "

team add teamGray "Grau"
team modify teamGray color dark_gray
team modify teamGray prefix "[Grau] "
#endregion

#region Spawntimer
# TODO Zeiten anpassen
scoreboard players set diamondMax timer 500
scoreboard players set emeraldMax timer 800

scoreboard players set ironMax teamOrange 40
scoreboard players set goldMax teamOrange 100

scoreboard players set ironMax teamRed 40
scoreboard players set goldMax teamRed 100

scoreboard players set ironMax teamGreen 40
scoreboard players set goldMax teamGreen 100

scoreboard players set ironMax teamGray 40
scoreboard players set goldMax teamGray 100
#endregion

#region Copy the map
clone 63 26 63 32 60 48 704 30 -32
clone 31 26 63 0 60 48 672 30 -32
clone -1 26 63 -32 60 48 640 30 -32
clone -33 26 63 -64 60 48 608 30 -32

clone 63 26 47 32 60 32 704 30 -48
clone 31 26 47 0 60 32 672 30 -48
clone -1 26 47 -32 60 32 640 30 -48
clone -33 26 47 -64 60 32 608 30 -48

clone 63 26 31 32 60 16 704 30 -64
clone 31 26 31 0 60 16 672 30 -64
clone -1 26 31 -32 60 16 640 30 -64
clone -33 26 31 -64 60 16 608 30 -64

clone 63 26 15 32 60 0 704 30 -80
clone 31 26 15 0 60 0 672 30 -80
clone -1 26 15 -32 60 0 640 30 -80
clone -33 26 15 -64 60 0 608 30 -80

clone 63 26 -1 32 60 -16 704 30 -96
clone 31 26 -1 0 60 -16 672 30 -96
clone -1 26 -1 -32 60 -16 640 30 -96
clone -33 26 -1 -64 60 -16 608 30 -96

clone 63 26 -17 32 60 -32 704 30 -112
clone 31 26 -17 0 60 -32 672 30 -112
clone -1 26 -17 -32 60 -32 640 30 -112
clone -33 26 -17 -64 60 -32 608 30 -112

clone 63 26 -33 32 60 -48 704 30 -128
clone 31 26 -33 0 60 -48 672 30 -128
clone -1 26 -33 -32 60 -48 640 30 -128
clone -33 26 -33 -64 60 -48 608 30 -128

clone 63 26 -49 32 60 -64 704 30 -144
clone 31 26 -49 0 60 -64 672 30 -144
clone -1 26 -49 -32 60 -64 640 30 -144
clone -33 26 -49 -64 60 -64 608 30 -144
#endregion

#region Redstone block placement
fill 735 30 -17 704 64 -32 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -17 672 64 -32 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -17 640 64 -32 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -17 608 64 -32 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -33 704 64 -48 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -33 672 64 -48 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -33 640 64 -48 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -33 608 64 -48 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -49 704 64 -64 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -49 672 64 -64 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -49 640 64 -64 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -49 608 64 -64 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -65 704 64 -80 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -65 672 64 -80 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -65 640 64 -80 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -65 608 64 -80 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -81 704 64 -96 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -81 672 64 -96 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -81 640 64 -96 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -81 608 64 -96 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -97 704 64 -112 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -97 672 64 -112 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -97 640 64 -112 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -97 608 64 -112 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -113 704 64 -128 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -113 672 64 -128 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -113 640 64 -128 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -113 608 64 -128 minecraft:redstone_block replace minecraft:polished_granite

fill 735 30 -129 704 64 -144 minecraft:redstone_block replace minecraft:polished_granite
fill 703 30 -129 672 64 -144 minecraft:redstone_block replace minecraft:polished_granite
fill 671 30 -129 640 64 -144 minecraft:redstone_block replace minecraft:polished_granite
fill 639 30 -129 608 64 -144 minecraft:redstone_block replace minecraft:polished_granite
#endregion

# Kill items
kill @e[type=item]

# Show config ui
function vanillabedwars:startui