# Dungeons Game

A Java (LWJGL/Slick2D) game inspired by Pathfinders.

## Setup

### Git (Optional)

Git is optional, but for completeness it is included. First of all, refer to [this github article](https://help.github.com/articles/set-up-git) on how to set up git on your computer. If you're on windows, you may additionally want to install [Github for Windows](http://windows.github.com/).

As for Eclipse, you are also going to need to install the proper git plugins. To do so, follow the steps outlined below.

1. Open Eclipse
2. Go to `Help` > `Install New Software`
3. Under Work with, select your Eclipse version site ( something like `Kepler - http://download.eclipse.org/releases/kepler`)
3. type `git` in the search box
4. Installeverything that doesn't end in ` - Source Code`
5. Accept licenses and install.

### Maven

Install dependencies:

This project uses Slick2D from the [Slick 2D Maven](https://github.com/nguillaumin/slick2d-maven) repository. Below is a quick excerpt on getting it installed.

```
git clone git://github.com/nguillaumin/slick2d-maven.git
cd slick2d-maven
mvn clean install
```

### Eclipse

Use [Maven Natives](https://code.google.com/p/mavennatives/#Eclipse_Plugin) to automatically build the project for your platform. To install Maven Natives, just follow the simple steps below.

1. Open Eclipse
2. Go to `Help` > `Install New Software`
3. Paste the following URL: `http://mavennatives.googlecode.com/svn/eclipse-update/`
4. Install Maven Natives
