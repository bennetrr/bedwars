scoreboard players set @s stop 0
scoreboard players enable @s uiAction

tellraw @a ["\n\n\n\n\n\n\n\n",{"text":"Sicherheitsabfrage","bold":true,"color":"gold"},"\n",{"text":"Willst du das Spiel wirklich stoppen?","color":"gold"},"\n",{"text":"[JA, SPIEL STOPPEN]","color":"dark_green","clickEvent":{"action":"run_command","value":"/trigger uiAction set 4"}}]