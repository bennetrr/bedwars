#region Team assignment
execute if score maxPlayerPerTeam data matches 1 run team join teamOrange @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=1,sort=random]
execute if score maxPlayerPerTeam data matches 1 run team join teamRed @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=1,sort=random]
execute if score maxPlayerPerTeam data matches 1 run team join teamGreen @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=1,sort=random]
execute if score maxPlayerPerTeam data matches 1 run team join teamGray @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=1,sort=random]

execute if score maxPlayerPerTeam data matches 2 run team join teamOrange @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=2,sort=random]
execute if score maxPlayerPerTeam data matches 2 run team join teamRed @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=2,sort=random]
execute if score maxPlayerPerTeam data matches 2 run team join teamGreen @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=2,sort=random]
execute if score maxPlayerPerTeam data matches 2 run team join teamGray @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=2,sort=random]

execute if score maxPlayerPerTeam data matches 3 run team join teamOrange @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=3,sort=random]
execute if score maxPlayerPerTeam data matches 3 run team join teamRed @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=3,sort=random]
execute if score maxPlayerPerTeam data matches 3 run team join teamGreen @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=3,sort=random]
execute if score maxPlayerPerTeam data matches 3 run team join teamGray @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=3,sort=random]

execute if score maxPlayerPerTeam data matches 4 run team join teamOrange @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=4,sort=random]
execute if score maxPlayerPerTeam data matches 4 run team join teamRed @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=4,sort=random]
execute if score maxPlayerPerTeam data matches 4 run team join teamGreen @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=4,sort=random]
execute if score maxPlayerPerTeam data matches 4 run team join teamGray @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen,limit=4,sort=random]
#endregion

#region Set villager trades
execute as @e[tag=trader_items] run data merge entity @s {Offers:{Recipes:[{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:iron_ingot",Count:4b},sell:{id:"minecraft:white_wool",Count:32b}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:1b},sell:{id:"minecraft:red_dye",Count:1b,tag:{display:{Name:'{"text":"Alarmfalle","color":"dark_red"}',Lore:['{"text":"Diese Falle löst einen Alarm aus, wenn ein","color":"dark_red"}','{"text":"Spieler aus einem gegnerischen Team deine","color":"dark_red"}','{"text":"Insel betritt.","color":"dark_red"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"dark_red"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:1b},sell:{id:"minecraft:red_dye",Count:1b,tag:{display:{Name:'{"text":"Abbaulämungsfalle","color":"dark_red"}',Lore:['{"text":"Diese Falle löst einen Alarm aus, wenn ein","color":"dark_red"}','{"text":"Spieler aus einem gegnerischen Team deine","color":"dark_red"}','{"text":"Insel betritt, und hindert ihn am abbauen.","color":"dark_red"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"dark_red"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:1b},sell:{id:"minecraft:red_dye",Count:1b,tag:{display:{Name:'{"text":"Gegenoffensive Falle","color":"dark_red"}',Lore:['{"text":"Diese Falle löst einen Alarm aus, wenn ein","color":"dark_red"}','{"text":"Spieler aus einem gegnerischen Team deine","color":"dark_red"}','{"text":"Insel betritt, und gibt ihm Speed und Jump Boost.","color":"dark_red"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"dark_red"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:1b},sell:{id:"minecraft:red_dye",Count:1b,tag:{display:{Name:'{"text":"Aufdeckungsfalle","color":"dark_red"}',Lore:['{"text":"Diese Falle löst einen Alarm aus, wenn ein","color":"dark_red"}','{"text":"Spieler aus einem gegnerischen Team deine","color":"dark_red"}','{"text":"Insel betritt, gibt ihm Glowing und entfernt ggf. Invisibility.","color":"dark_red"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"dark_red"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:1b},sell:{id:"minecraft:red_dye",Count:1b,tag:{display:{Name:'{"text":"It\'s a trap!","color":"dark_red"}',Lore:['{"text":"Diese Falle löst einen Alarm aus, wenn ein","color":"dark_red"}','{"text":"Spieler aus einem gegnerischen Team deine","color":"dark_red"}','{"text":"Insel betritt, und gibt ihm Blindness und Slowness.","color":"dark_red"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"dark_red"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:8b},sell:{id:"minecraft:lime_dye",Count:1b,tag:{display:{Name:'{"text":"Strength","color":"green"}',Lore:['{"text":"Stufe 1: Strength I (für das ganze Team)","color":"green"}','{"text":"Stufe 2: Strength II (für das ganze Team)","color":"green"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"green"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:3b},sell:{id:"minecraft:lime_dye",Count:1b,tag:{display:{Name:'{"text":"Regeneration","color":"green"}',Lore:['{"text":"Regeneration I (für das ganze Team)","color":"green"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"green"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:5b},sell:{id:"minecraft:lime_dye",Count:1b,tag:{display:{Name:'{"text":"Protection","color":"green"}',Lore:['{"text":"Stufe 1: Protection I (für das ganze Team)","color":"green"}','{"text":"Stufe 2: Protection II (für das ganze Team)","color":"green"}','{"text":"Stufe 3: Protection III (für das ganze Team)","color":"green"}','{"text":"Stufe 4: Protection VI (für das ganze Team)","color":"green"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"green"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:4b},sell:{id:"minecraft:lime_dye",Count:1b,tag:{display:{Name:'{"text":"Haste","color":"green"}',Lore:['{"text":"Stufe 1: Haste I (für das ganze Team)","color":"green"}','{"text":"Stufe 2: Haste II (für das ganze Team)","color":"green"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"green"}']}}}},{rewardExp:0b,maxUses:2147483647,xp:0,priceMultiplier:1f,buy:{id:"minecraft:diamond",Count:6b},sell:{id:"minecraft:lime_dye",Count:1b,tag:{display:{Name:'{"text":"Spawner-Upgrades","color":"green"}',Lore:['{"text":"Stufe 1: 50% mehr Ressourcen","color":"green"}','{"text":"Stufe 2: 100% mehr Ressourcen","color":"green"}','{"text":"Stufe 3: Emeralds können spawnen","color":"green"}','{"text":"Stufe 4: 200% mehr Ressourcen","color":"green"}','{"text":"Lege sie in den Upgrade-Dropper zum aktivieren.","color":"green"}']}}}}]}}

execute as @e[tag=trader_items,tag=trader_orange] run data modify entity @s Offers.Recipes[0].sell.id set value "orange_wool"
execute as @e[tag=trader_items,tag=trader_red] run data modify entity @s Offers.Recipes[0].sell.id set value "red_wool"
execute as @e[tag=trader_items,tag=trader_gray] run data modify entity @s Offers.Recipes[0].sell.id set value "gray_wool"
execute as @e[tag=trader_items,tag=trader_green] run data modify entity @s Offers.Recipes[0].sell.id set value "green_wool"
#endregion

#Stop command
scoreboard objectives add stop trigger
scoreboard players enable @a stop

# Start game
scoreboard players set gameActive data 1

# Spectator for everyone who is not in a team
gamemode spectator @a[team=!teamRed,team=!teamOrange,team=!teamGray,team=!teamGreen]

#region Player tp
tp @a[team=teamOrange] 672 45 -31
tp @a[team=teamGray] 722 45 -80
tp @a[team=teamGreen] 672 45 -129
tp @a[team=teamRed] 623 45 -80
#endregion

tellraw @a {"text": "Das spiel wurde gestartet!", "color": "light_green"}