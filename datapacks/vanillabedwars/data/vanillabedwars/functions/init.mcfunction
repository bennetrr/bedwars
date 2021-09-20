tellraw @a {"text": "Bitte warten, das Spiel wird geladen...\n(Kurze Lags möglich!)", "color": "gold"}

#region Scoreboards
scoreboard objectives add timer dummy
scoreboard objectives add deaths deathCount
scoreboard objectives add armor dummy
scoreboard objectives add eliminated dummy
scoreboard objectives add fireball minecraft.used:minecraft.carrot_on_a_stick

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

#region Cleanup blocks
#region 0 - 29
fill 735 29 -17 704 0 -32 air
fill 703 29 -17 672 0 -32 air
fill 671 29 -17 640 0 -32 air
fill 639 29 -17 608 0 -32 air

fill 735 29 -33 704 0 -48 air
fill 703 29 -33 672 0 -48 air
fill 671 29 -33 640 0 -48 air
fill 639 29 -33 608 0 -48 air

fill 735 29 -49 704 0 -64 air
fill 703 29 -49 672 0 -64 air
fill 671 29 -49 640 0 -64 air
fill 639 29 -49 608 0 -64 air

fill 735 29 -65 704 0 -80 air
fill 703 29 -65 672 0 -80 air
fill 671 29 -65 640 0 -80 air
fill 639 29 -65 608 0 -80 air

fill 735 29 -81 704 0 -96 air
fill 703 29 -81 672 0 -96 air
fill 671 29 -81 640 0 -96 air
fill 639 29 -81 608 0 -96 air

fill 735 29 -97 704 0 -112 air
fill 703 29 -97 672 0 -112 air
fill 671 29 -97 640 0 -112 air
fill 639 29 -97 608 0 -112 air

fill 735 29 -113 704 0 -128 air
fill 703 29 -113 672 0 -128 air
fill 671 29 -113 640 0 -128 air
fill 639 29 -113 608 0 -128 air

fill 735 29 -129 704 0 -144 air
fill 703 29 -129 672 0 -144 air
fill 671 29 -129 640 0 -144 air
fill 639 29 -129 608 0 -144 air
#endregion

#region 65 - 128
fill 735 65 -17 704 128 -32 air
fill 703 65 -17 672 128 -32 air
fill 671 65 -17 640 128 -32 air
fill 639 65 -17 608 128 -32 air

fill 735 65 -33 704 128 -48 air
fill 703 65 -33 672 128 -48 air
fill 671 65 -33 640 128 -48 air
fill 639 65 -33 608 128 -48 air

fill 735 65 -49 704 128 -64 air
fill 703 65 -49 672 128 -64 air
fill 671 65 -49 640 128 -64 air
fill 639 65 -49 608 128 -64 air

fill 735 65 -65 704 128 -80 air
fill 703 65 -65 672 128 -80 air
fill 671 65 -65 640 128 -80 air
fill 639 65 -65 608 128 -80 air

fill 735 65 -81 704 128 -96 air
fill 703 65 -81 672 128 -96 air
fill 671 65 -81 640 128 -96 air
fill 639 65 -81 608 128 -96 air

fill 735 65 -97 704 128 -112 air
fill 703 65 -97 672 128 -112 air
fill 671 65 -97 640 128 -112 air
fill 639 65 -97 608 128 -112 air

fill 735 65 -113 704 128 -128 air
fill 703 65 -113 672 128 -128 air
fill 671 65 -113 640 128 -128 air
fill 639 65 -113 608 128 -128 air

fill 735 65 -129 704 128 -144 air
fill 703 65 -129 672 128 -144 air
fill 671 65 -129 640 128 -144 air
fill 639 65 -129 608 128 -144 air
#endregion

#region 129 - 192
fill 735 129 -17 704 192 -32 air
fill 703 129 -17 672 192 -32 air
fill 671 129 -17 640 192 -32 air
fill 639 129 -17 608 192 -32 air

fill 735 129 -33 704 192 -48 air
fill 703 129 -33 672 192 -48 air
fill 671 129 -33 640 192 -48 air
fill 639 129 -33 608 192 -48 air

fill 735 129 -49 704 192 -64 air
fill 703 129 -49 672 192 -64 air
fill 671 129 -49 640 192 -64 air
fill 639 129 -49 608 192 -64 air

fill 735 129 -65 704 192 -80 air
fill 703 129 -65 672 192 -80 air
fill 671 129 -65 640 192 -80 air
fill 639 129 -65 608 192 -80 air

fill 735 129 -81 704 192 -96 air
fill 703 129 -81 672 192 -96 air
fill 671 129 -81 640 192 -96 air
fill 639 129 -81 608 192 -96 air

fill 735 129 -97 704 192 -112 air
fill 703 129 -97 672 192 -112 air
fill 671 129 -97 640 192 -112 air
fill 639 129 -97 608 192 -112 air

fill 735 129 -113 704 192 -128 air
fill 703 129 -113 672 192 -128 air
fill 671 129 -113 640 192 -128 air
fill 639 129 -113 608 192 -128 air

fill 735 129 -129 704 192 -144 air
fill 703 129 -129 672 192 -144 air
fill 671 129 -129 640 192 -144 air
fill 639 129 -129 608 192 -144 air
#endregion

#region 193 - 255
fill 735 193 -17 704 254 -32 air
fill 703 193 -17 672 254 -32 air
fill 671 193 -17 640 254 -32 air
fill 639 193 -17 608 254 -32 air

fill 735 193 -33 704 254 -48 air
fill 703 193 -33 672 254 -48 air
fill 671 193 -33 640 254 -48 air
fill 639 193 -33 608 254 -48 air

fill 735 193 -49 704 254 -64 air
fill 703 193 -49 672 254 -64 air
fill 671 193 -49 640 254 -64 air
fill 639 193 -49 608 254 -64 air

fill 735 193 -65 704 254 -80 air
fill 703 193 -65 672 254 -80 air
fill 671 193 -65 640 254 -80 air
fill 639 193 -65 608 254 -80 air

fill 735 193 -81 704 254 -96 air
fill 703 193 -81 672 254 -96 air
fill 671 193 -81 640 254 -96 air
fill 639 193 -81 608 254 -96 air

fill 735 193 -97 704 254 -112 air
fill 703 193 -97 672 254 -112 air
fill 671 193 -97 640 254 -112 air
fill 639 193 -97 608 254 -112 air

fill 735 193 -113 704 254 -128 air
fill 703 193 -113 672 254 -128 air
fill 671 193 -113 640 254 -128 air
fill 639 193 -113 608 254 -128 air

fill 735 193 -129 704 254 -144 air
fill 703 193 -129 672 254 -144 air
fill 671 193 -129 640 254 -144 air
fill 639 193 -129 608 254 -144 air
#endregion
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