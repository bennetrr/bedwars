# Deactivate alarm
execute unless entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] run scoreboard players set trapActive teamGreen 0

#region player detection
# alarmTrap
execute if entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] unless score trapActive teamGreen matches 1..5 if score alarmTrap teamGreen matches 1.. run function vanillabedwars:game/traps/team_green/actions/alarm_trap

# noMiningTrap
execute if entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] unless score trapActive teamGreen matches 1..5 if score noMiningTrap teamGreen matches 1.. run function vanillabedwars:game/traps/team_green/actions/no_mining_trap

# counteroffensiveTrap
execute if entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] unless score trapActive teamGreen matches 1..5 if score counteroffensiveTrap teamGreen matches 1.. run function vanillabedwars:game/traps/team_green/actions/counteroffensive_trap

# detectionTrap
execute if entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] unless score trapActive teamGreen matches 1..5 if score detectionTrap teamGreen matches 1.. run function vanillabedwars:game/traps/team_green/actions/detection_trap

# detectionTrap
execute if entity @a[x=683,z=-139,dx=-22,dz=26,y=0,dy=100,team=!teamGreen] unless score trapActive teamGreen matches 1..5 if score itsATrap teamGreen matches 1.. run function vanillabedwars:game/traps/team_green/actions/its_a_trap
#endregion

#region effects
execute if score trapActive teamGreen matches 2 run function vanillabedwars:game/traps/team_green/effects/no_mining_trap
execute if score trapActive teamGreen matches 3 run function vanillabedwars:game/traps/team_green/effects/counteroffensive_trap
execute if score trapActive teamGreen matches 4 run function vanillabedwars:game/traps/team_green/effects/detection_trap
execute if score trapActive teamGreen matches 5 run function vanillabedwars:game/traps/team_green/effects/its_a_trap
#endregion