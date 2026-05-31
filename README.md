# Cascades Cool Biomes

<img width="800" height="400" alt="CascadesCool" src="https://github.com/user-attachments/assets/a7397549-fae6-4b43-872d-7b07a209672d" />

A datapack addon for Cascades ( Currently only for Minecraft 1.21.1 ) that adds carefully selected biomes derived from WWEE
on top of Cascades worldgen, while restoring vanilla biomes removed by Cascades.

## Requirements Mod (Mod)
1. [Cascades](https://modrinth.com/mod/hybrid-beta) — terrain generation 
2. [William Wythers Overhauled Overworld (WWOO)](https://modrinth.com/datapack/wwoo) — vanilla biome OverHaul (No longer need to Use Datapack version)


## Requirements (load order for _**Datapack**_)
1. [William Wythers Overhauled Overworld (WWOO)](https://modrinth.com/datapack/wwoo) — biome overhaul ( Top ) 
2. **This addon** — biome placement and new biomes 
3. [Cascades](https://modrinth.com/mod/hybrid-beta) — terrain generation ( bottom ) 


<img width="395" height="256" alt="image" src="https://github.com/user-attachments/assets/0c805dd2-5746-47ac-801d-328725c19ea2" />

> [!NOTE]
> This pack works without WWOO, but it's not recommended. The vanilla biome visuals don't blend well with the biomes this mod introduces. You can try another vanilla biome enhancement mod as a substitute, but WWOO is what this pack is designed and tested around.

<br>

## Recommended mods/datapacks

- Highly recomended using either [Distant Horizons](https://modrinth.com/mod/distanthorizons) or [Voxy](https://modrinth.com/mod/voxy) for best visuals
- Somes Structure mods that fit nicely
  * [Towns and Towers](https://modrinth.com/mod/towns-and-towers) ( Must use! )
  * [Katters Structures](https://modrinth.com/mod/katters-structures)
  * [ChoiceTheorem's Overhauled Village](https://modrinth.com/mod/ct-overhaul-village)

> [!TIP]
> For Voxy version 1.21.1 You may use this updated [fork](https://github.com/m3t4f1v3/voxy )

<br>

## Added biomes ( Derived from WWEE )
ancient taiga, autumnal forest, bayou, cactus desert, cool stony peaks,
giant sequoia forest, glacial cliffs, highlands, jacaranda savanna,
lapacho plains, larch taiga, maple mountains, mediterranean island,
phantasmal forest, sakura forest, snowy tundra, volcanic crater

## Restored vanilla biomes ( Tht were removed from Cascades )
birch forest, old growth birch forest, windswept hills, windswept forest,
windswept gravelly hills, windswept savanna




## Biome placement logic
All wythers biomes carved from climatically matching vanilla donor slots
so they generate at correct ground level with Cascades terrain:

| Biome | Donor slot |
|---|---|
| autumnal forest | hybrid_beta:autumnal_forest (cold dry) |
| bayou | hybrid_beta:rainforest (hot humid) |
| maple mountains | meadow (temperate elevated) |
| glacial cliffs | frozen_peaks (cold peaks) |
| volcanic crater | badlands (hot rocky) |
| sakura forest | cherry_grove (pink/cherry zone) |
| phantasmal forest | dark_forest (dark eerie) |
| mediterranean island | beach (warm coastal) |

Note: This doesn't include all biomes!


## Why addon format?
Ships only the overworld.json remap and WWEE biome/feature files. ( With permission from WWEE author ).
This is only an addon for Cascades! No files from original pack included — fully compliant with Cascades license.

## Credits
- [Crystalis7](https://modrinth.com/user/Crystalis7) Cascades
- [WilliamWythers](https://modrinth.com/user/WilliamWythers) William Wythers Expanded Ecosphere (WWEE)
- [WinsomeGuy](https://modrinth.com/user/WinsomeGuy) This mods author

