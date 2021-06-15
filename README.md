# Borderhunt
Minecraft java plugin that makes the worldborder expand over time.

![worldborder](https://user-images.githubusercontent.com/85688159/121939720-97546b00-cd4d-11eb-9e84-ef48ca7f5733.png)

## Information
This plugin can be used on its own, but it was created to be used in a minecraft manhunt in combination with a [player tracker].

Game version: **1.16**

## Usage

`/borderhunt <option> (value)`

Options: `start , stop , pause , resume , increment, initial , time`    

**Functions**  
| Command | Explanation |
| ------ | ------ |
| start | Spawns the border and starts the timer |
| stop | Stops the border timer|
| pause | Pauses the border timer |
| resume | Resumes the border timer |

**Variables**  
| Command | Explanation |
| ------ | ------ |
| initial | How many blocks wide should the border be at the start |
| increment | By how many blocks should the border increase |
| time | After how many seconds should the border increase |

## Example

Setting up and starting:
```
/borderhunt initial 50
/borderhunt time 30
/borderhunt increment 30
/borderhunt start
```
Pausing, changing a value and resuming:
```
/borderhunt pause
/borderhunt time 45
/borderhunt resume
```

[player tracker]: https://www.spigotmc.org/resources/compass-tracker-nether-compatible.87102/
