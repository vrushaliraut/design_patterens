LLD :-

- Warehouse based delivery model
- We have multiple warehouses -- w1, w2 ....... Wn
- Every warehouse has a set of packages to be delivered to customers.  P1, p2......pn

- Every warehouse has a set of delivery boys assigned. S1, s2, ...... sn  
  1 -> Area - List<DeliveryBoysData>
- Every package has some states.
- READY_FOR_DELIVERY
- OUT_FOR_DELIVERY
- DELIVERED
- POSTPONED
- CANCELLED

Assumptions
- The packages do not move inter-warehouse
- Delivery Boys strictly work for warehouses.

Output :
1) Database design
2) Class diagram :- Oops
3. API Design

Database design
W2,W3,W4

W1 => List<Deliveryboys>  
=> List<Packages>

1 -> M  warehouse -> delivery boys
1 -> M  warehouse -> packages
1 -> M  Delivery boy -> many package
* Package to deliveryboy
* DriverInfo (Delivery Boys)
  Id             - primary
  Phone number   - unique_no
  assigned_wearHouse - w1  - FK


* WearHouse
  wearHouseID - primary key
  Location
  Package_id
  
* Orders
  Order_id - primary key
  Receiver_address
  Type_of_delivery ->
  Status
  Metadata
  wearHouse -1  FK

GetOrderStatus()  -

GET /getOrderStatus?order_id&&wearHouse   ->

GET /wearHouseInfo?:id
GET /driverInfo

WearHouse  {
Int wearHouse;
List<DeliveryBoysInfo> list;
// Map<Integer, List<Packages>> hmap;  1 deliveryBoy-> Multiple package
}
1 - > address, phone number, status

// 10
//GetOrder ->
Order {
List<Pakages> package
Status
Phone number
Address
}

Enum STATUS {
READY_FOR_DELIVERY,
OUT_FOR_DELIVERY,
DELIVERED,
POSTPONED,
CANCELLED,
}

DriverInfo{
Int Id,
Long phoneNumber;
Map<Integer, STATUS > mapOfPackageIDToStatus;  package 1 -> 2
}






