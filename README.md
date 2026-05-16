# Cascades Cool Biomes

A datapack addon for Cascades ( Currently only for Minecraft 1.21.1 ) that adds carefully selected WWEE biomes
on top of Cascades worldgen, while restoring vanilla biomes removed by Cascades.

## Requirements (load order)
1. [William Wythers Overhauled Overworld (WWOO)](https://modrinth.com/datapack/wwoo) — vanilla biome visuals ( Top )
2. **This addon** — biome placement and new biomes
3. [Cascades](https://modrinth.com/datapack/cascades) — terrain generation ( bottom )

<img width="395" height="256" alt="image" src="https://github.com/user-attachments/assets/0c805dd2-5746-47ac-801d-328725c19ea2" />


## Added biomes ( From WWEE )
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


## Why addon format?
Ships only the overworld.json remap and WWEE biome/feature files. ( With permission from WWEE author ) 
Note This is only an addon for Cascades! No files from original pack included — fully compliant with Cascades license.

## Credits
- Terrain: [Cascades](https://modrinth.com/datapack/cascades)
- Biomes: [William Wythers Extended Ecosystem (WWEE)](https://modrinth.com/datapack/wwee)
- Vanilla overhaul: [WWOO](https://modrinth.com/datapack/wwoo)
