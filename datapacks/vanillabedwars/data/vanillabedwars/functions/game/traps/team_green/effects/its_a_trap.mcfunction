execute as @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] at @s run effect give @s minecraft:blindness 2 1 true
execute as @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] at @s run effect give @s minecraft:slowness 2 2 true
execute if score trapActive teamGreen matches 1 run function vanillabedwars:game/traps/team_green/effects/its_a_trap