# Mortgage Calculator
A single-activity Android application and demonstrated use of Android Studio and basic UI elements.
Goal of this project was to come up with a simple mortgage calculator. User will input the amount of
money, then chose interest rate and time to pay off, the app will calculate and show mortgage to pay
each month.

## View Layout
The view will have the following elements:
### Amount Borrowed
This will be a [EditText](https://developer.android.com/reference/android/widget/EditText.html) into which the user will enter the amount to be borrowed as a floating-point value (e.g., “1000.00”).
### Interest Rate
This will be a [SeekBar](https://developer.android.com/reference/android/widget/SeekBar.html) ranging from 0.0 to 20.0, indicating the annual percentage rate of the interest. This value should start at 10.0.
### Loan Term
This will be a [RadioGroup](https://developer.android.com/reference/android/widget/RadioGroup.html) with the choices 15, 20, and 30, representing the number of years of the loan.
### Taxes and Insurance
This will be a [CheckBox](https://developer.android.com/reference/android/widget/CheckBox.html) that allows the user to select whether taxes and insurance are to be included in the monthly payment.
### Calculate
This will be a [Button](https://developer.android.com/reference/android/widget/Button.html) that, when pressed, will calculate the user’s monthly payments based on the values entered.
### Monthly Payment
This will be a [TextView](https://developer.android.com/reference/android/widget/TextView.html) that displays the monthly payment.
### Calculation
For interest rates other than 0%, the monthly payment can be calculated as:
> M = {P * [J/(1-(1+J)^-N)]} + T
where:
* P = Principal (the amount borrowed)
* J = Monthly interest in decimal form (annual interest rate / 1200) N = Number of months of the loan
* T = Monthly taxes and insurance, if selected (0.1% of the amount borrowed) For interest rates of 0%, the monthly payment is simply:
> M = P/N + T

## Installation
Use Android Studio to run this application.