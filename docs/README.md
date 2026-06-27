/// BARANGAY SERVICES MANAGEMENT SYSTEM \\\

A java source code simulating a management system of a barangay's services.
The source code demonstrates core OOP principles and SOLID principles.


**GROUP MEMBERS**
-Chico Santos
-Rico Mendoza
-Jacob Cagang


|FEATURES|
=Resident Registration: Register residents with duplicate ID detection and input validation
=Payment Simulation: Process payments with custom exception handling
=Statistical Reporting: Console dashboard showing transaction totals and resident count
=Sorting Engine: Sort residents alphabetically by last name using Comparator
=Search/Filter: Search residents by last name using Java Streams


----- PROJECT STRUCTURE -----

src/
├── com/barangay/exception/     → ExceptionHandling.java
├── com/barangay/interfaces/    → Payment.java, Reportable.java
├── com/barangay/models/        → BarangayService.java, Resident.java, PaymentTransaction.java
├── com/barangay/services/      → ResidentService.java, PaymentService.java, ReportService.java
├── com/barangay/ui/            → Main.java
└── com/barangay/util/          → Repository.java
bin/                            → All compiled classes
docs/                           → README.md, UML Class Diagram


## How to Compile and Run
COMPILE PROGRAM == "javac -d out $(find src -name "*.java")"
RUN PROGRAM == "java -cp out com.barangay.ui.Main"


||OOP CONCEPTS DEMONSTRATED IN THE PROJECT||
**Encapsulation** — All fields private with validated getters/setters
**Inheritance** — `PaymentService` and `ResidentService` extend abstract `BarangayService`
**Polymorphism** — Interface overriding (`Payment`, `Reportable`), method overloading (`registerResident`)
**Abstraction** — Abstract class `BarangayService`, interfaces `Payment` and `Reportable`
**Generics** — `Repository<T>` utility class
**Streams & Lambdas** — Used in filtering and sorting collections
**Custom Exception** — `ExceptionHandling` used across all service layers


===== GROUP CONTRIBUTIONS ======

Chico
* Created files and directories
* Programmed Resident file
* Input error handling in Resident file
* Created Interfaces
* Added error handling in barangay services
* Added Repository file and folder
* Added no duplicate id handling
* added hash and equals to barangay service file
* added resident count in report service
* Created abstract class and extended them
* Created UML
* Formatted the README file
* Added streams and hashes to 5 files

Rico
* Added PaymentTransaction.java
* Added validation for setters
* Added Validation in Setters
* Added the right path of the package and added rejection for negative vales
* Added equals
* Added PaymentService.java
* Initialize Main file
* Fixed Main.java
* Fixed the Exception method
* Compiled Java files

Jacob
* Programmed BarangayService file
* Updated BarangayService
* Programmed Main file
* Programmed ReportService
* Adjusted ReportService
* Assisted in ExceptionHandling file

