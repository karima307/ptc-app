# ptc_android_test

![alt tag](screen-porto-tech-center.jpg)

Jumia Porto Tech Center (PTC) is an Agile IT development center, with around 200 IT-specialists, 
where you will have the opportunity to participate in developing smart solutions for our group companies. 
We do e-commerce shops, logistics, business intelligence and mobile applications involving a wide range of high-end technologies for tens of millions customers.  

You can check our job opportunities at our site: https://group.jumia.com/careers.  

We were founded in 2012 and today we are part of Jumia Group powered by Rocket Internet, Millicom, MTN, Axa Group, 
Goldman Sachs, Orange and CDC.   Working at PTC means being in the first line of e-commerce development in emerging markets.  

What you will find in PTC?  

In PTC you will have an opportunity to develop and apply e-business software solutions for a wide range of business areas. 

You will belong to the international team with the top experts who will inspire and support you in working on an international scale impacting millions of revenue (travelling, logistics, e-shops) and users. 

We are humble and pragmatic. 

We are passionate about what we do, and we have fun while doing it. 

We move in a fast-pace and we are ready to challenge risks. 

We value sharing knowledge and learning from each other. We are flexible and we believe that anything is possible. 

We will offer you second home where you will find the opportunity for growth and career development.
You will have the opportunity to earn the bonus based on your excellent results. 
The benefit list includes but is not limited to health insurance, parental bonus, snacks and fruits.

This repo represents the current admission test that is needed to apply for an Android Developer Position.

Android Challenge:
-

The idea is to create an application that can list the products requested by a query, supporting offline mode.

Description:
-

The application should be composed by:

    - Splash screen 
    - Result list page 

The following requirements need to be met:

The search must be able to list items from a query.

1. The splash screen:
    - Is the entry page. 

2. The search result list page:
    - It's a page that shows the "phone" query and respective result.
    - For each result item, the following should be displayed:
        - Image;
        - Name and brand;
        - Price, old price and discount;
        - Rating;

Submission:
-

- Create a pull request
- Title format "Challenge Admission Test - FIRST_NAME LAST_NAME"
- Write a description about your implementation


Mock API: 
-

NOTE: The mocklab API is based in JSON mocks and only supports the following requests.


- Get "phone" search items

    > http://nd7d1.mocklab.io/search/phone/page/1/

    Parameters:
    - *"phone"* - the query
    - *"1"* - the page number (pagination)
    
    
- Failure cases
    
    HTTP 404 - Not Found:
    > http://nd7d1.mocklab.io/search/phone/page/3/


Required tech implementations:
-
- Android Jetpack;
- Android Architecture Components;
- Material Design Components;
- Kotlin and Coroutines;
- Clean Architecture;
- Offline Mode;


We value the following implementations:
-
- Pagination;
- Animations;
- Image Loader (Volley/Picasso/Glide);
- Retrofit/OKHttp client for API communication;
- Unit tests;


Similar screens:
-

![Screenshot](screen_1.jpg)
