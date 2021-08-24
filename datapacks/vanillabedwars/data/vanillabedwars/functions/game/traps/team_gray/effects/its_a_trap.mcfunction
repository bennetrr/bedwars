execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect give @s minecraft:blindness 2 1 true
execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect give @s minecraft:slowness 2 2 true
execute if score trapActive teamGray matches 1 run function vanillabedwars:game/traps/team_gray/effects/its_a_trap