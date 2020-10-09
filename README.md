# NVIDIA RTX HERO 
 
 
 ![Alt text](screenshot.png?raw=true "Optional Title")
 
 
 
 
 
 
 
 
 
 ## OCT 9th Updates:
 
 #### Working on a packaged release that will hopefully go live this weekend
 #### Looking for a GUI designer to hop onboard this project
 #### Checkout reddit.com/r/GPUBOTS  for GPU Bot discussions
 ### Thanks for the interest in my project. A more detailed README will be coming soon.
 
 
 NVIDIA RTX 3090 add to cart bot.
 
Find 3090 and 3080 cards in stock at Newegg or Bestbuy

Use this behind a proxy or VPN. 

This tool will find an in stock gpu, and send your phone an add to cart link for bestbuy, or a product link on newegg that will have apple pay. This should speed up the checkout process quite a bit. 

Features to integrate:
1. Autocheckout (I had this working prior to the 3080 launch. After the 3080 launch bot detection has increased quiet a bit. It is very hard to not be seen as a bot so I may not fully integrate this feature again. I honestly believe it is faster to just checkout with saved information in your browser to avoid avoid bot detection. 

2. Add product selection options. Currently it checks for all models of 3080/3090s in stock. I will take whatever I can get so I have been running it on everything. I will be adding a user selection method in the near future.

3. NVIDIA store support. I had a working solution for the NVIDIA store but their API has been terrible lately. They are very clearly trying to prevent bots with their API blackouts. I am working on a solution that monitors the NVIDIA store for changes before pushing API requests. I assume the API will come back online before the add to cart buttons go live.

I am open to suggestions! Please let me know of any features you think would help you get a 3090/3080!


#### Instruction

##### NOTE: USE A PROXY OR VPN DURING USE. FAILURE TO DO SO MAY GET YOU BANNED FROM BUYING. KEEP YOU CPU RUNNING THIS SOFTWARE, AND KEEP YOUR PHONE ON YOUR HOME NETWORK WITH NO VPN. NOTIFICATION WILL COME VIA TEXT. CHECKOUT ON YOUR PHONE.

1. Install  >>> https://www.jetbrains.com/idea/

2. Setup a trial twilio account >>> https://www.twilio.com/ 

3. Download and unzip the Twilio .jar files >>> https://jar-download.com/artifact-search/twilio

4. Download and unzip Selenium . jar files >>> https://jar-download.com/?search_box=selenium

5. Download and unzip this repo as zip (TOP RIGHT)

6. Open IntelliJ and open the repo file you just unzip

7. In IntelliJ >>> File > Project Structure > Libraries > + Sign > Java > select all the jar files unziped from twilio download

8. Repeat step 7 with all the .jar files unzipped from the selenium download

9. In main.java enter your twilio sid and auth-token, phone number, and twilio phone number

10. Comment out any cards you are not interested in buying 

11. Run Main.java
