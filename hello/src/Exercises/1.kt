// 2. Mobile notifications
// Typically, your phone provides you with a summary of notifications.

// In the initial code provided in the following code snippet, write a program that prints the summary message based on the number of notifications that you received. The message should include:

// The exact number of notifications when there are less than 100 notifications.
// 99+ as the number of notifications when there are 100 notifications or more.

// fun main() {
//     val morningNotification = 51
//     val eveningNotification = 135
    
//     printNotificationSummary(morningNotification)
//     printNotificationSummary(eveningNotification)
// }


// fun printNotificationSummary(numberOfMessages: Int) {
//     // Fill in the code.
// }
// Complete the printNotificationSummary() function so that the program prints these lines:


// You have 51 notifications.
// Your phone is blowing up! You have 99+ notifications.

//

fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

val lessComment = "You have 51 notifications."
val muchComment = "Your phone is blowing up! You have 99+ notifications."

fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100) println(lessComment) else println(muchComment)
}