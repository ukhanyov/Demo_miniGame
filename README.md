# Demo_miniGame

Game rules:

At the start of the new game app randomly creates two squads (dark and light).
Each squad has 1 mage, 3 ranged units and 4 melee units.
Existing races: humans, orcs, elves, undead.
Humans and elves vs orcs and undead (obviously).

At the start of the match both squads are randomly generated.
All characters are divided into two groups (with and without priority).
If someone casted "priority" spell on a character, this character will start the next round in a priority group.
Priority expires after a one turn.
Prioritised characters deal x1.5 damage.

Turn schedule is randomized at the start of the every round (for both groups).
During it's turn, character can perform one action (attack or cast spell).
Result of the match is logged in the file

Every character has 100 hp.
List of characters:

Elves:
- Mage (CAST_PRIORITY, DAMAGE_MAGIC (10 HP) )
- Archer (DAMAGE_RANGED (7 HP) , DAMAGE_MELEE (3 HP) )
- Warrior (DAMAGE_MELEE (15 HP) )

Humans:
- Mage (CAST_PRIORITY, DAMAGE_MAGIC (4 HP) )
- Crossbowman (DAMAGE_RANGED (5 HP) , DAMAGE_MELEE (3 HP) )
- Warrior (DAMAGE_MELEE (18 HP) )

Orcs:
- Shaman (CAST_PRIORITY, REMOVE_PRIORITY)
- Archer (DAMAGE_RANGED (3 HP) , DAMAGE_MELEE (2 HP) )
- Goblin (DAMAGE_MELEE (20 HP) )

Undead:
- Necromancer (CAST_DISEASE (Enemy damage x0.5 for 1 turn), DAMAGE_MAGIC (5 HP))
- Archer (DAMAGE_RANGED (4 HP) , DAMAGE_MELEE (2 HP) )
- Zombi (DAMAGE_MELEE (18 HP) )
