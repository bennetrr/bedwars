execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect give @s minecraft:speed 2 10 true
execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect give @s minecraft:jump_boost 2 15 true
execute if score trapActive teamGray matches 1 run function vanillabedwars:game/traps/team_gray/effects/counteroffensive_trap