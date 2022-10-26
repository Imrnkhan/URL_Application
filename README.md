# URL_Application
Introduction
Implementing a URL shortening service is not a complex task, and it is often part of system design interviews. In this post, I will try to explain the process of implementing the service. A URL shortener is a service that is used to create short links from very long URLs. Usually, short links have the size of one-third or even one-fourth of the original URL, which makes them easier to type, present, or tweet. Clicking on a short link user will be automatically redirected to the original URL.
There are many URL shortening services available online, like tiny.cc, bitly.com, cutt.ly, etc.

Theory
Before implementation, it is always a good idea to write down what it is needed to be done in the form of functional and non-functional requirements.

Functional requirements
Users need to be able to enter a long URL. Our service should save that URL and generate a short link.
Clicking on the short link should redirect the user to the original long URL.
Users should have the option to enter the expiration date. After that date passed, the short link should be invalid.
Users should create an account to use the service. Service can have a usage limit per user (optional)
User is allowed to create his own short link*-   Service should have metrics, for example, most visited links (optional)

Then, let’s create a UrlController.java file in the controller folder. The controller should have one POST method for creating short links and one GET method for redirecting to the original URL.

The GET method takes a short URL as a path variable and then gets and redirects to the original URL.

GetOriginalUrl is a method used by the GET method from the controller. It first converts a string to base 10, and the result of that is an id. Then, it gets a record from the database by that id and throws an exception if it does not exist. After that, it returns the original URL to the controller.

Conclusion
I hope that this post helped you a bit to get a general idea about how to create a URL shortener service. You can take this idea and improve it. Write down some new functional requirements and try to implement them. If you have any questions, you can post them under this post.
