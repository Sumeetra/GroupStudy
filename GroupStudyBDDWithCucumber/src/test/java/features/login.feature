Feature: User should be able to login

Scenario Outline: User should be able to login with correct credentials
Given User is already in Login Page
When User enters "<username>" and "<password>"
Then Dashboard page should display
Examples:
|username				|password|
|techfiosdemo@gmail.com	|abc123	 |
|sumitra				|abc123	 |