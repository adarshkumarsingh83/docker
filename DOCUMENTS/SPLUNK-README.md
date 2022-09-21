# splunk via docker 

----
### splunk docker iamge docker hub link 
* https://hub.docker.com/r/splunk/splunk/

## Docker cmd to run splunk 
* $ docker run -p 8000:8000 -e "SPLUNK_START_ARGS=--accept-license" -e "SPLUNK_PASSWORD=password" --name splunk-server splunk/splunk:latest


## splunk gui url 
* http://localhost:8000
	* admin/password


---
* settings -> DataInputs -> Http Event Collector -> 
	* Global Settings 
		* AllTokens = enabled 
		* Default Source Type = json 
		* Default index = main 
		* http port no = 8088
			* save 
	* New Token 
		* name = xxx service 
		* source name ovverride = http-event-collector 
			* next 
		* Input Settings 
			* source type 
				* new -> source type 
					* log4j 
			* select allowed index 
				* create a new index (name must have underscore)
					* index name = xxxx_envname
						* save 
				* select the index created 
					* reveiw 
						* take value informations  for jave log4j configuraiton 
						* submit  
* settings -> DataInputs -> Http Event Collector 
	* we can see the list of the event collector and token which is used to connect from log4j  
