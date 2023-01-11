# RISE: Android Frontend

## **Project participants:**

- Nathan Buchin
- Jordan Hermans
- Edgar Antunes

## **Introduction**

In this project we continued to work on the RISE android frontend that began last year. To view the initial diagrams, user stories and how to set up Android Studio, 
check out the README_old.md.

## **Division of work**
### New Technologies
<p>
This project involved the usage of Android Studio which combined the Ktlin are used to program the app. 
Unfortunately, this meant learning to use new technologies before attacking the task at hand. This took us around two weeks to do.
</p>

### **Class diagram overlook**
<p>
We had to check whether the diagrams needed to be updated. According to the previous team, some classes were superfluous and needed deleting, like for example the abstract class "User". 
But in our opinion, such was not the case.
</p>

### **MVC**
<p>
As we did not understand the need for a design pattern like the MVC and because it made the code more confusing, we scrapped it.
</p>

### **Layout**
<p>
We changed the XML files' layout to a constraint layout instead of a relative layout.
</p>

### **Debugging**
<p>
We spent about 80 to 90% percent of our scessions debugging the app as it wasn't initialliy build using android studio. Some implementations like jcenter or PdfViwer
were outdated/deprecated. Additionally, some initialization files were not set up properly.
</p>

### **ViewModel**
<p>
We incorporated the ViewModel pattern to ensure that it caches state and persists it through configuration changes.
</p>

## **Further Improvments**
As the APIs came a bit late, we did not have time to incorporate them into the app. For the futur dev team, we suggest using retrofit 2.

Furthermore some layouts are definetly in need of additional work, in particular the calendar and forum pages.
