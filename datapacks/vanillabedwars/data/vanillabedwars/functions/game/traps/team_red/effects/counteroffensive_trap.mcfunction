execute as @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] at @s run effect give @s minecraft:speed 2 10 true
execute as @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] at @s run effect give @s minecraft:jump_boost 2 15 true
execute if score trapActive teamRed matches 1 run function vanillabedwars:game/traps/team_red/effects/counteroffensive_trap