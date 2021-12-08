# SerCom
A simple Serial connection tool to test devices connected via serial port.

Check the [release](https://github.com/csabalenart/SerCom/releases/tag/1.0.0) for compiled version and ch340 driver for windows (of course no driver needed for linux nor for windows if that's RS232).

The app was created in [Apache Netbeans](https://netbeans.apache.org/) So, if you would like to modify the code I recommend download that and open the project from there. It has a nice swing gui editor, so it makes the desktop app development super quick and easy. And of course it's free. I know it's not the best IDE ever, but for quick desktop app development it's super.

An extra info: I made the project ANT based (would be better with maven, but for some reason netbeans wouldn't agree with that in my machine :/ ), so when you open the project it probably will marked as error. What you have to do is in "Projects" tab right click on Libraries -> Add jar/Folder and browse the jSerialComm-2.7.0.jar (it's in the dependencies folder). Also do not forget to add the proper JDK (1.8 minimum), but normally it's automatically added with the IDE.
![preview](https://user-images.githubusercontent.com/46690477/145173016-25f12e7b-bbd9-4e68-8e9e-9990265e8719.jpg)
