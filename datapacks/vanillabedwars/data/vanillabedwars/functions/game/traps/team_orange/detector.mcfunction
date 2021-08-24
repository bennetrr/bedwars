# Deactivate alarm
execute unless entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] run scoreboard players set trapActive teamOrange 0

#region player detection
# alarmTrap
execute if entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] unless score trapActive teamOrange matches 1..5 if score alarmTrap teamOrange matches 1.. run function vanillabedwars:game/traps/team_orange/actions/alarm_trap

# noMiningTrap
execute if entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] unless score trapActive teamOrange matches 1..5 if score noMiningTrap teamOrange matches 1.. run function vanillabedwars:game/traps/team_orange/actions/no_mining_trap

# counteroffensiveTrap
execute if entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] unless score trapActive teamOrange matches 1..5 if score counteroffensiveTrap teamOrange matches 1.. run function vanillabedwars:game/traps/team_orange/actions/counteroffensive_trap

# detectionTrap
execute if entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] unless score trapActive teamOrange matches 1..5 if score detectionTrap teamOrange matches 1.. run function vanillabedwars:game/traps/team_orange/actions/detection_trap

# detectionTrap
execute if entity @a[x=663,z=-19,dx=18,dz=-25,y=0,dy=100,team=!teamOrange] unless score trapActive teamOrange matches 1..5 if score itsATrap teamOrange matches 1.. run function vanillabedwars:game/traps/team_orange/actions/its_a_trap
#endregion

#region effects
execute if score trapActive teamOrange matches 2 run function vanillabedwars:game/traps/team_orange/effects/no_mining_trap
execute if score trapActive teamOrange matches 3 run function vanillabedwars:game/traps/team_orange/effects/counteroffensive_trap
execute if score trapActive teamOrange matches 4 run function vanillabedwars:game/traps/team_orange/effects/detection_trap
execute if score trapActive teamOrange matches 5 run function vanillabedwars:game/traps/team_orange/effects/its_a_trap
#endregion