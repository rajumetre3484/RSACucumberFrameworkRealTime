Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page


Given User is on GreenCart Landing page
When User searched with Shortname <Name> and extracted actul name of product
Then User searched for <Name> shortname in offers page 
And Validate product name in offers page matches with landing Page

Examples:
| Name |
| Tom  |
| Beet |