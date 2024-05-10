DESCRIPTION OF THE TOPIC
The website includes 3 types of interacting users: users without an account (guest), users with an account (customer), and system administrators (admin).
Users without an account (guest) have the following functions:

View the list of products (computer devices, cosmetics, clothing ... depending on the topic, this list is taken from the database)
View details of each product from the product list.
Select to buy each product (can be selected from the Web product list page or from the Web detail page of each product), the product after being selected for purchase will be added to the cart.
View the shopping cart (list of products selected for purchase, this information is stored in the Session variable, no need to update the database).
When viewing the cart, you can adjust the quantity of each product in the cart (if the quantity is adjusted to 0, remove that product from the cart)
Can register for a website account with the necessary information (email not duplicated with other accounts), after successful registration with valid information, store in the database + send email + notification about the account.

Users with an account (customer) can perform the functions of Users without an account (guest), in addition, users with an account (customer) can also:

Process payment (this function is performed when the cart has products and the user is successfully logged into the system): update information into the database + send email + notification of successful order registration with accompanying information. After successful processing, the Session is reset to null.

System administrators (admin) can perform functions like a user with an account (customer). In addition, other functions for system administrators (admin)

Back-End:
Search for information about products/product categories, user accounts, product order forms.
Manage product/product category information:

View the list of products/product categories.
View details of each product/product category.
Delete products/product categories in case the product is not in any order or the product category does not have any products.
Add new, update product/product category information.


Manage user account information:

View the list of registered user accounts.
View details of each user account, cannot view the user's password.
Delete a user account if the user has not made any online orders.
Update user account information.


Manage online order information:

View the list of orders (sorted by purchase date)
View order details.
Update the quantity of items in the online order



Note for information management functions:

Constraints when deleting data
In case of adding or updating data, it can be checked on the Client side using JavaScript/jQuery or checked using the Model on the Server side, do not use Functions/Check constraints/Stored Procedures in the database management system.
