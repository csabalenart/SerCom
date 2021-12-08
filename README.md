# SerCom
A simple Serial connection tool to test devices connected via serial port.

Check the [release](https://github.com/csabalenart/SerCom/releases/tag/1.0.0) for compiled version and ch340 driver for windows (of course no driver needed for linux nor for windows if that's RS232).

The app was created in [Apache Netbeans](https://netbeans.apache.org/) So, if you would like to modify the code I recommend download that and open the project from there. It has a nice swing gui editor, so it makes the desktop app development super quick and easy. And of course it's free. I know it's not the best IDE ever, but for quick desktop app development it's super.

An extra info: I made the project ANT based (would be better with maven, but for some reason netbeans wouldn't agree with that in my machine :/ ), so when you open the project it probably will marked as error. What you have to do is in "Projects" tab right click on Libraries -> Add jar/Folder and browse the jSerialComm-2.7.0.jar (it's in the dependencies folder). Also do not forget to add the proper JDK (1.8 minimum), but normally it's automatically added with the IDE.

The below screenshot was taken from a raspberry PI 3 and I sent a few AT commands to a SIM900 GSM shield attached with USB via CH340 (it had no SIM CARD that's why it thrown an error at the end). But I've also tested with ESP8266 it works well with that too, as well as tested with TDS100 via RS232 (with RS232 to usb cable from windows...I've attached the driver in the release for that too...it has to be added manually from device manager)
![image](https://user-images.githubusercontent.com/46690477/145181313-b7d1a0e1-bb18-4658-a233-6c2d5a211b8d.png)
