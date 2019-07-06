# Mine Sweep Assist (MobileSweeper)

Minesweeper Bomb Placement Analysis Assistant

This application is a helper tool for those who aren't expeert at Minesweeper but wanted to move on as an expert player of the game, this is an analysis tool for reading the bomb patterns or number patterns in the grid to determine bombs placement in the mine field. Recommended for those who have trouble visioning mine patterns predictions when moving on as an expert player.

Note that this is not an actual minesweeper game, it is a tool for expertize the gameplay.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

[Android Studio](https://developer.android.com/studio) (and all of its prerequisites, such as Java)

### Installing

A step by step series of examples that tell you how to get a development environment running

```
1. Download or clone this project, place it somewhere accessible in the computer with enough free space.
2. Run Android Studio and open this project
3. Run by "Run > Run app", make sure you have a real Android phone + USB of it, or an emulated phone within Android Studio.
4. Wait for a while, especially when it says "Installing APK".
5. Enjoy the application
```

### Examples

When we open the application, we start with the empty 10x10 grid.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot0.jpg)

When tap any cell on the grid, supposedly at the center, we place the mine there, and the numbers around it also appears. You can click the mine again to remove it.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot1.jpg)

When a cell have 2 mines in 2 of the adjacent cells, the number would be 2.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot2.jpg)

Same goes for 3.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot3.jpg)

4 mines around a cell.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot4.jpg)

5 mines around a cell.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot5.jpg)

6 mines around a cell. Which is gettering rare in real gameplay.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot6.jpg)

7 mines around a cell. Even rarer.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot7.jpg)

8 mines around a cell. When you see this in real gameplay, the game is a real trouble.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot8.jpg)

You can even fill the whole grid with mines, you can't see this in the real gameplay.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot9.jpg)

You can make arts of it.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot10.jpg)
![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot13.jpg)

Here is the more serious use for helping the gameplay, if you remember the 1-2-1 and 1-2-2-1 patterns (certain mines patterns)  where the mines are certain in some spots in there. Some of these patterns may be hidden by the overlapping mines those modified the numbers of the pattern, you can use this tool to emulate the situation, and remove the overlapping mines away to uncover the certain mines patterns.

![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot11.jpg)
![alt text](https://github.com/jzrlza/MobileSweeper/blob/master/screenshots/shot12.jpg)



## Built With

* [Android Studio](https://developer.android.com/studio) - The development IDE used


## Authors

* **JJ Parinvut Rochanavedya** - *Initial work* - [Jzrlza](https://github.com/jzrlza)

See also the list of [contributors](https://github.com/jzrlza/MobileSweeper/graphs/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.txt](LICENSE.txt) file for details

## Acknowledgments

* Inspiration - From playing the mobile game called [Minesweeper Collector](https://play.google.com/store/apps/details?id=air.com.griffgriffgames.minesweeper&hl=en), where there are lots of challenging minesweeper puzzles, in which I owned a premium account after I became an intermediate player for a while and wanted to be an expert player, at first I have trouble visioning the mines analysis so I have to come up with this.
* Tutorial and What based on - It was based on [this project](https://github.com/marcellelek/Minesweeper), from the 4 parts tutorial of making Minesweeper in a simple way in Android phone. [Part 1.](https://www.youtube.com/watch?v=nORt4szAmkI) [Part 2.](https://www.youtube.com/watch?v=8oodzvSMIuQ) [Part 3.](https://www.youtube.com/watch?v=uYHhlvaNY2Y) [Part 4.](https://www.youtube.com/watch?v=t22KSVbtttE) Special Thanks to Marcell Elek.
