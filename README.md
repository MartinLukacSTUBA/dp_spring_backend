# Systém správy firemných vozidiel

**Tento projekt je diplomovým projektom inžinierskeho štúdia na FEI STU.**

Projekt sa skladá z dvoch častí

Frontend - React-Native: [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_react_native)

Backend - Java Spring: [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_spring_backend)

**Ide o Open-Source softvér, ktorý firmám umožňuje prevádzkovať vlastný firemný softvér pre Správu firemných vozidiel.**
_______________________________
Cieľom diplomovej práce bolo vyvinúť aplikáciu na monitorovanie a správu vozidiel. Aplikácia
by mala byť použiteľná pre mnoho firiem, ktoré majú firemnú flotilu vozidiel a
chceli by jednotlivé vozidlá monitorovať. V teoretickej časti diplomovej práce sme si opísali
protokol On board diagnostic 2, rôzne možnosti vývoja frontendovej časti aplikácie
a taktiež aj môžnosti vývoja serverovej časti aplikácie. Popísali sme si ako v súčastnej
dobe komunikujú aplikácie naprieč internetom, a predstavili sme si jednotlivé typy databáz.
V praktickej časti sme sa venovali vývoju aplikácie na frontendovej a serverovej
časti, taktiež sme vytvorili databázu aplikácie. V aplikácii je možné prihlásiť sa pomocou
jedinečného účtu zabezpečeného pomocou JWT tokenu. Používatelia aplikácie s rolou
Admin, dokážu vytvárať a meniť používateľské účty v aplikácii alebo vytvárať a meniť
vozidlá vo firemnej flotile, taktiež majú možnosť prezriet si všetky historické dáta jednotlivých
jázd. Používatelia aplikácie s rolou User, si vedia priradiť už existujúce vozidlá a
zaznamenávať parametre jednotlivých jázd, taktiež si vedia pozrieť históriu svojich jázd
s podrobnými parametrami. Všetky tieto údaje sú uložené v databáze, a používateľ si
ich môže kedykoľvek pozrieť. Pre vyhnutie sa problémom s neplatnými dokumentmi, ako
je Stav technickej kontroly, sme implementovali v aplikácii kontrolu stavu vozidiel. Ak
vozidlu čoskoro končí platnosť dokumentov, majiteľovi vozidla je zaslaný email o čoskorom
expirovaní platnosti dokumentov. Navrhnutá aplikácia je jednoducho nasaditeľná a
nakonfigurovateľná pre rôzne typy konektorov On Board Diagnostic 2. Implementovaním
v JavaScript knižnici Reac-Native je táto aplikácia kompatibilná pre operačné systémy
Android a iOS.

#### Kľúčové slová: OBD2, frontend, react-native, backend, framework spring, database

____________________________________
Využívané technológie pri vývoji serverovej časti: **Java 17, PostgreSQL 15**

Vývojové prostredie servera  : **Intelij Idea 2023**

_____________________________________
Pre jednoduchšie nasadenie serverovej časti sme aplikovali aj **technológiu Docker**.

Pre potreby nasadenia serveru s dockerom musíte mať nainštalovaný Docker Destkop.

Ak chcete nasadiť kontajner obsahujúci server, napíšte do konzoly, kde je vytvorený projekt **docker-compose up --build**

Pre mobilnú aplikáciu detailnejšie informácie v README.MD  projektu [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_react_native)

_________

____
# Vehicle Management System

**This project was developed as a diploma thesis.**

It is composed of 2 parts

Frontend - React-Native: [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_react_native)

Backend - Java Spring: [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_spring_backend)

**It is Open-Source software that allows you runs own Company vehicle management system.**
_______________________________
The aim of the present diploma thesis was to develop an application for monitoring and
managing vehicles. The application should be suitable for many companies that possess a
fleet of company vehicles and would like to monitor individual ones. In the theoretical part
of diploma thesis, we described the On board diagnostic 2 protocol, different possibilities
of frontend development and also the possibilities of server side development.We described
how applications communicate across the Internet nowadays and introduced various types
of databases. The analytical part examined the development of application on the frontend
and server side, we also created the database of the application. Users can log in to the
application with a unique account secured with a JWT token. The Admin users of the
application can create and change user accounts or create and change vehicles in the
company fleet, they are able to view all the historical data of individual trips. Users with
the User role can assign existing vehicles and record trip parameters, as well as view the
history of their trips with detailed parameters. All this data is stored in a database, so the
user can see it at any time. To prevent issues with invalid documents, such as Technical
Inspection Status, we implemented a vehicle status check in the application. If a vehicle’s
documents are about to expire, the owner of the vehicle will receive an email, notifying
them of impending expiry. The designed application is easy to deploy and configure with
various types of On Board Diagnostic 2 connectors. Thanks to the React-Native JavaScript
library ), this app is compatible with both Android and iOS operating systems.

#### Keywords: OBD2, frontend, react-native, backend, framework spring, database

____________________________________
Required technologies for backend side: **Java 17, PostgreSQL 15**

Development environment  : **Intelij Idea 2023**

_____________________________________
For easier deployment we applied also **Docker technology**.

For needs of deploy with docker you needs to have installed Docker desktop.

If you want to deploy docker container write into console where is builded project **docker-compose up --build**

For the mobile application, more detailed information in README.MD of the  [GitHub Repository](https://github.com/MartinLukacSTUBA/dp_react_native)
