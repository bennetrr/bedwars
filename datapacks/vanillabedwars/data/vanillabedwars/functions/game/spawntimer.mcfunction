# Time when a piece of iron, gold, diamond or emerald should spawn
#region teamOrange
scoreboard players add ironTimer teamOrange 1
execute if score ironTimer teamOrange >= ironMax teamOrange run scoreboard players set ironTimer teamOrange 0
scoreboard players add goldTimer teamOrange 1
execute if score goldTimer teamOrange >= goldMax teamOrange run scoreboard players set goldTimer teamOrange 0
#endregion

#region teamRed
scoreboard players add ironTimer teamRed 1
execute if score ironTimer teamRed >= ironMax teamRed run scoreboard players set ironTimer teamRed 0
scoreboard players add goldTimer teamRed 1
execute if score goldTimer teamRed >= goldMax teamRed run scoreboard players set goldTimer teamRed 0
#endregion

#region teamGray
scoreboard players add ironTimer teamGray 1
execute if score ironTimer teamGray >= ironMax teamGray run scoreboard players set ironTimer teamGray 0
scoreboard players add goldTimer teamGray 1
execute if score goldTimer teamGray >= goldMax teamGray run scoreboard players set goldTimer teamGray 0
#endregion


#region teamGreen
scoreboard players add ironTimer teamGreen 1
execute if score ironTimer teamGreen >= ironMax teamGreen run scoreboard players set ironTimer teamGreen 0
scoreboard players add goldTimer teamGreen 1
execute if score goldTimer teamGreen >= goldMax teamGreen run scoreboard players set goldTimer teamGreen 0
#endregion

#region Increase spawn rate over time
execute if score minutes timer matches 6 run scoreboard players set diamondMax timer 333
execute if score minutes timer matches 12 run scoreboard players set emeraldMax timer 533

execute if score minutes timer matches 18 run scoreboard players set diamondMax timer 250
execute if score minutes timer matches 24 run scoreboard players set emeraldMax timer 400

execute if score minutes timer matches 30 run scoreboard players set diamondMax timer 125
execute if score minutes timer matches 36 run scoreboard players set emeraldMax timer 200
#endregion

#region diamonds
scoreboard players add diamondTimer timer 1
execute if score diamondTimer timer >= diamondMax timer run scoreboard players set diamondTimer timer 0
#endregion

#region emeralds
scoreboard players add emeraldTimer timer 1
execute if score emeraldTimer timer >= emeraldMax timer run scoreboard players set emeraldTimer timer 0
#endregion