### FILE NAME MUST BE .dockerignore
> Description: \
> this file will help to ignore the inclusion of the unnecessary \
> files into the docker images file  
````
{ term }
term:
'*' matches any sequence of non-Separator characters
'?' matches any single non-Separator character
'[' [ '^' ] { character-range } ']'
character class (must be non-empty)
c matches character c (c != '*', '?', '\\', '[')
'\\' c matches character c
 
character-range:
c matches character c (c != '\\', '-', ']')
'\\' c matches character c
lo '-' hi matches character c for lo &lt;= c &lt;= hi
 
additions:
'**' matches any number of directories (including zero)
'!' lines starting with ! (exclamation mark) can be used to make exceptions to exclusions
'#' lines starting with this character are ignored: use it for comments

````

----
### SAMPLE 

````
# ignore .git and .cache folders
.git
.cache

# ignore all markdown files (md) beside all README*.md other than README-secret.md
*.md
!README*.md
README-secret.md
````