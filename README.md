# Swing-Hotel-Booking-System
Swing Hotel Booking System 





CREATE TABLE hotel_project.Bookings (     ID int NOT NULL AUTO_INCREMENT,     TennantId int NOT NULL,  roomNumber int NOT NULL,     noDaysBooked int NOT NULL,  roomStatus varchar(255) NOT NULL,     checkIn datetime NOT NULL,      checkOut datetime NOT NULL,      PRIMARY KEY (ID),  FOREIGN KEY (TennantId) REFERENCES Tennants(ID) );



CREATE TABLE hotel_project.Tennants (ID int NOT NULL AUTO_INCREMENT, Title varchar(255) NOT NULL, FirstName varchar(255) NOT NULL, LastName varchar(255) NOT NULL, NoAdultVisitors varchar(255) NOT NULL, NoMiniorsVisitors varchar(255) NOT NULL, PRIMARY KEY (ID));



CREATE TABLE hotel_project.Payments (
    ID int NOT NULL AUTO_INCREMENT,
    TennantId int NOT NULL,
	BookingId int NOT NULL,
    Total decimal(19,4) NOT NULL,
	PaymentType varchar(255) NOT NULL,
    PaymentStatus varchar(255) NOT NULL,
    Tax decimal(19,4) NOT NULL,
	DateOfPayment date NOT NULL, 
    PRIMARY KEY (ID),
	FOREIGN KEY (TennantId) REFERENCES Tennants(ID),
    FOREIGN KEY (bookingId) REFERENCES Bookings(ID)
);
