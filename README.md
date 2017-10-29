SCHEMA PUBLISHINGJPADB

#------------  
#| CATEGORY |
#------------
#| ID*      |
#| NAME     |
#| VERSION  |
#|----------- 
      /|\ 
       |
       |
#------------
#|   BOOK   |
#------------           --------------
#| ID*      |           | AUTHOR_BOOK |
#| CATEGORY |           ---------------
#| ISBN     |---------- | AUTHOR_ID^   |
#| TITLE    |           | BOOK_ID^     |
#| PRICE    |           --------------
#| VERSION  |          /
#------------         /
      |              /
      |             /
#--------------    /
#|   AUTHOR    |  /
#--------------  /
#| ID*         |/
#| FIRST_NAME  |
#| LAST_NAME   |
#| DESCRIPTION |
#-------------- 

#

