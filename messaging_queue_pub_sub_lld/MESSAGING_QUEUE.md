# Message Queue

* https://www.youtube.com/watch?v=4BEzgPlLKTo 

- Design queue supporting publisher-subscriber model. 
  
* It should support following Operations :- 

- Support multiple topics where messages can be published
- Able to publish message to perticuler topic
- ABle to subscribe to a topic 
- Whenever a message is published to a topic, all the subscribers who are subscribed to that topic 
  should receive the message.
- Should be able to reset the offset for a subscriber.
  This means subscriber would restart reading again from the offset. 
  
- Able to run in parallel.
