execute as @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] at @s run effect give @s minecraft:glowing 2 1 true
execute as @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] at @s run effect clear @s minecraft:invisibility
execute if score trapActive teamRed matches 1 run function vanillabedwars:game/traps/team_red/effects/detection_trap