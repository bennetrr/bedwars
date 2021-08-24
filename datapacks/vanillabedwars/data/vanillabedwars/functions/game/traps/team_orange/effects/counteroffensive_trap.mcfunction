execute as @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] at @s run effect give @s minecraft:speed 2 10 true
execute as @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] at @s run effect give @s minecraft:jump_boost 2 15 true
execute if score trapActive teamOrange matches 1 run function vanillabedwars:game/traps/team_orange/effects/counteroffensive_trap