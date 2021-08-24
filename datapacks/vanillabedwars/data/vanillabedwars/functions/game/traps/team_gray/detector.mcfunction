# Deactivate alarm
execute unless entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] run scoreboard players set trapActive teamGray 0

#region player detection
# alarmTrap
execute if entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] unless score trapActive teamGray matches 1..5 if score alarmTrap teamGray matches 1.. run function vanillabedwars:game/traps/team_gray/actions/alarm_trap

# noMiningTrap
execute if entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] unless score trapActive teamGray matches 1..5 if score noMiningTrap teamGray matches 1.. run function vanillabedwars:game/traps/team_gray/actions/no_mining_trap

# counteroffensiveTrap
execute if entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] unless score trapActive teamGray matches 1..5 if score counteroffensiveTrap teamGray matches 1.. run function vanillabedwars:game/traps/team_gray/actions/counteroffensive_trap

# detectionTrap
execute if entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] unless score trapActive teamGray matches 1..5 if score detectionTrap teamGray matches 1.. run function vanillabedwars:game/traps/team_gray/actions/detection_trap

# detectionTrap
execute if entity @a[x=730,z=-70,dx=-25,dz=-20,y=0,dy=100,team=!teamGray] unless score trapActive teamGray matches 1..5 if score itsATrap teamGray matches 1.. run function vanillabedwars:game/traps/team_gray/actions/its_a_trap
#endregion

#region effects
execute if score trapActive teamGray matches 2 run function vanillabedwars:game/traps/team_gray/effects/no_mining_trap
execute if score trapActive teamGray matches 3 run function vanillabedwars:game/traps/team_gray/effects/counteroffensive_trap
execute if score trapActive teamGray matches 4 run function vanillabedwars:game/traps/team_gray/effects/detection_trap
execute if score trapActive teamGray matches 5 run function vanillabedwars:game/traps/team_gray/effects/its_a_trap
#endregion