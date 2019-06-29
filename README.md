# cs441-program3

This is a simple application in which the user can control the Fahrenheit and Celsius values by scrolling the seek bar or manually editing either text field. If the user enters a Fahrenheit value, the application automatically converts and updates the Celsius display and vice versa. The user can click the vacation button to view a picture related to the temperature that was entered. The user can return to the main screen and reset the values to their initialized state if desired.

The process behind designing this program was fairly simple because I explored similar widgets and concepts when designing the Hello World program. 

I started by designing the widget layout for the main activity. Once I had them organized in a manageable way, I coded the logic behind how the user interacts with the widgets as well as maintaining the dynamics of how information is displayed on-screen. Once the user interface worked as intended, I designed and implemented the second activity for the photo display. I figured out how to exchange attributes between activities and packaged the Fahrenheit and Celsius values with the second activity callback. The second activity also packages the Fahrenheit and Celsius values, but with the main activity callback, so the information displays on the main activity are restored to their prior values when the user returns.

The most difficult problem I ran into while developing this program was implementing a sync between the two edit text fields and the seek bar. If the Fahrenheit edit text field is altered by the user, the Celsius edit text field and the seek bar must update. The same applies to when the Celsius edit text field or the seek is altered by the user. It was easy to get stuck in an endless loop that crashed the program because if adjusting X updates Y, and adjusting Y updates X, then X updates Y which updates X which updates Y . . . It took a a bit of clever thinking to use boolean values to keep track of whether or not a value is currently changing. It was also difficult to grasp the concept of the different edit text listeners: before text changed, text changed, and after text changed.

# Development schedule
June 18th - Created project and initial main activity design

June 20th - Updated layout and coded handlers for the widgets

June 22nd - Adjusted layout and began coding the dynamic information display when updating wigets

June 23rd - Continued developing and debugging until the user interface worked as intended

June 25th - Designed the second activity to display a photo

June 26th - Coded the logic behind switching activities and exchanging information between them

June 27th - Implemented code to change the temperature display and picture depending on the user's input

June 28th - Added a reset button to the main activity and an indicator of when the user lowers or raises the temperature

