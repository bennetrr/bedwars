execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect give @s minecraft:glowing 2 1 true
execute as @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] at @s run effect clear @s minecraft:invisibility
execute if score trapActive teamGray matches 1 run function vanillabedwars:game/traps/team_gray/effects/detection_trap