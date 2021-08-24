execute as @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] at @s run effect give @s minecraft:blindness 2 1 true
execute as @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] at @s run effect give @s minecraft:slowness 2 2 true
execute if score trapActive teamOrange matches 1 run function vanillabedwars:game/traps/team_orange/effects/its_a_trap