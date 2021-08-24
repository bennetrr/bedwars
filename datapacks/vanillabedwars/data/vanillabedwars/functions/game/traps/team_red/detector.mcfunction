# Deactivate alarm
execute unless entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] run scoreboard players set trapActive teamRed 0

#region player detection
# alarmTrap
execute if entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] unless score trapActive teamRed matches 1..5 if score alarmTrap teamRed matches 1.. run function vanillabedwars:game/traps/team_red/actions/alarm_trap

# noMiningTrap
execute if entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] unless score trapActive teamRed matches 1..5 if score noMiningTrap teamRed matches 1.. run function vanillabedwars:game/traps/team_red/actions/no_mining_trap

# counteroffensiveTrap
execute if entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] unless score trapActive teamRed matches 1..5 if score counteroffensiveTrap teamRed matches 1.. run function vanillabedwars:game/traps/team_red/actions/counteroffensive_trap

# detectionTrap
execute if entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] unless score trapActive teamRed matches 1..5 if score detectionTrap teamRed matches 1.. run function vanillabedwars:game/traps/team_red/actions/detection_trap

# detectionTrap
execute if entity @a[x=612,z=-92,dx=31,dz=24,y=0,dy=100,team=!teamRed] unless score trapActive teamRed matches 1..5 if score itsATrap teamRed matches 1.. run function vanillabedwars:game/traps/team_red/actions/its_a_trap
#endregion

#region effects
execute if score trapActive teamRed matches 2 run function vanillabedwars:game/traps/team_red/effects/no_mining_trap
execute if score trapActive teamRed matches 3 run function vanillabedwars:game/traps/team_red/effects/counteroffensive_trap
execute if score trapActive teamRed matches 4 run function vanillabedwars:game/traps/team_red/effects/detection_trap
execute if score trapActive teamRed matches 5 run function vanillabedwars:game/traps/team_red/effects/its_a_trap
#endregion