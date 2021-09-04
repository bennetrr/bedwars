# Display how long the game runs
scoreboard players add ticks timer 1
execute if score ticks timer matches 20.. run scoreboard players add seconds timer 1
execute if score ticks timer matches 20.. run scoreboard players set ticks timer 0
execute if score seconds timer matches 60.. run scoreboard players add minutes timer 1
execute if score seconds timer matches 60.. run scoreboard players set seconds timer 0

title @a times 0 20 0
title @a actionbar ["",{"text":"Game läuft seit: ","color":"gold"},{"score":{"name":"minutes","objective":"timer"},"color":"gold"},{"text":":","color":"gold"},{"score":{"name":"seconds","objective":"timer"},"color":"gold"}]
