## Problem statement 

* We need to design an online hotel booking system where a user can search a hotel in a given city and book it.
* This is an OOP design question, so I have not written the full code in this solution. 

* I have created the classes and attributes only.

* Solution :
* Main Classes :
    1. User
    2. Room
    3. Hotel
    4. Booking
    5. Address
    6. Facilities
  
## Explanations 
* Enums are self-explanatory.
* User,room and Address are self-explanatory.
* The class facilities contains a list of facilities(enum) that the hotel provides.
* We can add more facilities in the facility enum if required. 
* The duration class as to and from. 

* Class "Hotel" contains :
- List of rooms 
- Address 
- Facilities 

* Class "Booking" contains : 
- User 
- Hotel 
- List of rooms 
- Payment Status 

* Reference 
- https://www.geeksforgeeks.org/design-online-hotel-booking-system-like-oyo-rooms/
