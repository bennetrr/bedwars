scoreboard players set @s start 0
scoreboard players enable @s uiAction

tellraw @s ["\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",{"text":"VanillaBedwars 1.0.0","bold":true,"color":"gold"},"\n",{"text":"by bennetr & halfBloodBuilder","color":"gold"}, "\n"]

# maxPlayerPerTeam <= 1
execute if score maxPlayerPerTeam data matches ..1 run tellraw @s [{"text":"Maximale Anzahl der Spieler pro Team auswählen:","color":"gold"},"\n",{"text":"[-]","color":"gray"}," ",{"score":{"name":"maxPlayerPerTeam","objective":"data"},"color":"gold"}," ",{"text":"[+]","color":"gold","clickEvent":{"action":"run_command","value":"/trigger uiAction set 2"}}]

# 1 < maxPlayerPerTeam < 6
execute if score maxPlayerPerTeam data matches 2..5 run tellraw @s [{"text":"Maximale Anzahl der Spieler pro Team auswählen:","color":"gold"},"\n",{"text":"[-]","color":"gold","clickEvent":{"action":"run_command","value":"/trigger uiAction set 1"}}," ",{"score":{"name":"maxPlayerPerTeam","objective":"data"},"color":"gold"}," ",{"text":"[+]","color":"gold","clickEvent":{"action":"run_command","value":"/trigger uiAction set 2"}}]

# maxPlayerPerTeam >= 6
execute if score maxPlayerPerTeam data matches 6.. run tellraw @s [{"text":"Maximale Anzahl der Spieler pro Team auswählen:","color":"gold"},"\n",{"text":"[-]","color":"gold","clickEvent":{"action":"run_command","value":"/trigger uiAction set 1"}}," ",{"score":{"name":"maxPlayerPerTeam","objective":"data"},"color":"gold"}," ",{"text":"[+]","color":"gray"}]

# trainMode = 1
execute if score trainMode data matches 1.. run tellraw @s ["\n",{"text":"[X]","color":"dark_green","clickEvent":{"action":"run_command","value":"/trigger uiAction set 6"},"hoverEvent":{"action":"show_text","contents":["Das Spiel wird nicht automatisch beendet."]}},{"text":" Übungsmodus aktivieren","color":"gold","hoverEvent":{"action":"show_text","contents":["Das Spiel wird nicht automatisch beendet."]}}]

# trainMode = 0
execute unless score trainMode data matches 1.. run tellraw @s ["\n",{"text":"[ ]","color":"dark_red","clickEvent":{"action":"run_command","value":"/trigger uiAction set 5"},"hoverEvent":{"action":"show_text","contents":["Das Spiel wird nicht automatisch beendet."]}},{"text":" Übungsmodus aktivieren","color":"gold","hoverEvent":{"action":"show_text","contents":["Das Spiel wird nicht automatisch beendet."]}}]

tellraw @s ["\n",{"text":"[SPIEL STARTEN]","color":"gold","clickEvent":{"action":"run_command","value":"/trigger uiAction set 3"}}]