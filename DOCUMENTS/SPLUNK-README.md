# splunk via docker 

----


## Docker cmd to run splunk 
* $ docker run -p 8000:8000 -e "SPLUNK_START_ARGS=--accept-license" -e "SPLUNK_PASSWORD=password" --name splunk-server splunk/splunk:latest


## splunk gui url 
* http://localhost:8000
	* admin/password