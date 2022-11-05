# Crime-Information-Management-System
The main aim of this system is to maintain and manage the detail information of the crime happened in  an  area under a particular police station. This software could be used by the police officials in the Police station.



## Tech Stacks 🛠
Java , MySql

## Things before running the application

If you want to run this java application in your system then you need to take care of some things before runing in your system. 

1) You need mySql install in your system.

2) Some tables needs in managementSystem, you need to create managementSystem database then you need to create 4 tables first.

### Tables:

a) Admininfo Table

create table admininfo(
username varchar(20),
password varchar(20)
);

Values:

insert into admininfo  values("admin","admin");

b) Police Stations Tables

create table policeStation(
policeStationNo int primary key,
policeStationArea varchar(20),
policeStationAddress varchar(50)
);

values:

1) Police station Table value 1

insert into policeStation values(
1001,
'Main police Stations',
'Near gas station'
);

2) Police statiion value 2 

insert into policeStation values(
1002,
'Sub police Stations',
'Near Shivaji Park'
);

3) Police statiion value 3

insert into policeStation values(
1003,
'Sub police Stations',
'Main road'
);

c) Crime Information Tables

create table crimeInformation(
crimeId int primary key,
crimeDate date,
crimeDescription varchar(200),
crimeVictims varchar(200),
crimeDetailsDescription varchar(1000),
crimeMainSuspecte varchar(100),
crimeUnderWhichPoliceStationId int,
foreign key(crimeUnderWhichPoliceStationId) references policeStation(policeStationNo)
);
   
d) criminal List Tables

create table criminalList(
criminalId int primary key,
criminalName varchar(20),
criminalAge date,
criminalFaceMarks varchar(30),
criminalFirstArrestLocation varchar(30),
criminalCrimeId int,
criminalGender varchar(5),
foreign key(criminalCrimeId) references crimeInformation(crimeId)

);

3) Add mysql connector jar file in application build path.

4) For accessing the database as admin use Username: "admin" and Password: "admin"

### Application snaps:

![login in crime database](https://user-images.githubusercontent.com/76080960/200118556-8cbd6f07-28e3-42bf-9c91-1c3005bd752f.png)

### Video Links:

https://drive.google.com/file/d/10phgxCALe9bXKFzfwU2anqTq5UQb90Ur/view
